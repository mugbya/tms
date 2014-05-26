package com.tms.view.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.tms.base.BaseAction;
import com.tms.entity.chapter.Chapter;
import com.tms.entity.paper.Paper;
import com.tms.entity.subject.Subject;
import com.tms.entity.test.Test;
import com.tms.util.TestAlgorithm;

/**
 * @author mugbya
 * 
 * @version 2014年5月4日
 * 
 */
@Controller
@Scope("prototype")
public class PaperAction extends BaseAction<Paper> {

	private static final long serialVersionUID = 1L;

	// // 各种题型分配的分数
	// private Integer single_score;
	// private Integer check_srore;
	// private Integer judge_score;
	// private Integer blank_score;
	// private Integer write_score;
	// private Integer operating_score;

	// 考试科目
	private String subject;

	// 设置试卷允许重复的比例
	private Double repeated;

	// 设置难度系数比例
	private Double difficulty;

	// 设置试卷份数
	private Integer number;

	/**
	 * 试卷列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
		List<Paper> paperList = paperService.findAll();
		ActionContext.getContext().put("paperList", paperList);
		return "list";
	}

	public String delete() throws Exception {
		paperService.delete(model.getId());
		return "toList";
	}

	/**
	 * 一张试卷的所有试题
	 * 
	 * @return
	 * @throws Exception
	 */
	public String test() throws Exception {
		Paper paper = paperService.findById(model.getId());
		ActionContext.getContext().put("paper", paper);

		List<Test> singleTest = new ArrayList<>();
		List<Test> checkTest = new ArrayList<>();
		List<Test> judgeTest = new ArrayList<>();
		List<Test> blankTest = new ArrayList<>();

		Set<Test> testList = paper.getTests();
		Iterator<Test> it = testList.iterator();

		while (it.hasNext()) {
			Test test = (Test) it.next();
			int type = test.getType();
			if (type == 1) {
				singleTest.add(test);
			} else if (type == 2) {
				checkTest.add(test);
			} else if (type == 3) {
				judgeTest.add(test);
			} else if (type == 4) {
				blankTest.add(test);
			}
		}

		ActionContext.getContext().put("singleTest", singleTest);
		ActionContext.getContext().put("checkTest", checkTest);
		ActionContext.getContext().put("judgeTest", judgeTest);
		ActionContext.getContext().put("blankTest", blankTest);
		return "test";
	}

	/** 设置试卷页面 */
	public String setParams() throws Exception {
//		// 准备数据（查询题库,即所考的科目）
//		List<String> testName = testService.findAllTestName();
//		List<Test> testList = new ArrayList<>();
//
//		for (int i = 0; i < testName.size(); i++) {
//			System.out.println("试题库的名称：" + testName.get(i));
//			Test test = new Test();
//			test.setId(i);
//			test.setTestName(testName.get(i));
//			testList.add(test);
//		}

		// 准备科目信息
		List<Subject> subjectList = subjectService.findAll();
		ActionContext.getContext().put("subjectList", subjectList);

		// 根据科目返回章节信息
		if (model.getSubject() != null) {
			System.out.println("科目的id是----"+ Integer.parseInt(model.getSubject()));
			List<Chapter> chapterList = chapterService.findChapters(Integer
					.parseInt(model.getSubject()));
			ActionContext.getContext().put("chapterList", chapterList);
		}

//		ActionContext.getContext().put("testList", testList);
		return "set";
	}

	/**
	 * 生成试卷的算法
	 * 
	 * @return
	 * @throws Exception
	 */
	public String generatePaper() throws Exception {
		System.out.println("number 的份数：------------" + number);
		// 准备数据

//		List<String> testName = testService.findAllTestName();

//		subject = testName.get(model.getTestName());
		
		subject = model.getSubject();  // 得到的数值型的值（id值），而不是形如java(name)

		// 计算各种题型占总分数的比例
		double single_scale = (double) model.getSingle_score() / model.getScore();
		double check_scale = (double) model.getCheck_srore() / model.getScore();
		double judge_scale = (double) model.getJudge_score() / model.getScore();
		double blank_scale = (double) model.getBlank_score() / model.getScore();

		System.out.println("单选占得比例是-------" + single_scale);
		System.out.println("多选占得比例是-------" + check_scale);
		System.out.println("判断占得比例是-------" + judge_scale);
		System.out.println("填空占得比例是-------" + blank_scale);

		// 首先处理页面传来生成试卷份数
		if (number == null || number <= 0) {
			return "tolist"; // 简单处理(事实上该抛出相应的异常)
		}
		
		System.out.println(" 要生成的分数为-----------------"+number);
		
		System.out.println("开始抽提");
		for (int i = 0; i < number; i++) {
			System.out.println("第" + i+1 +"次抽题！-----------------");
			generatePapers(subject,single_scale, check_scale, judge_scale, blank_scale);
		}		
		
		return "toList";
	}

	public void  generatePapers(String subject,double single_scale,double check_scale,double judge_scale,double blank_scale) {
		// 保存抽取出的各种类型的题的集合
		List<Test> allTest = new ArrayList<>();

		// 处理从页面中按章节分配分数的的信息
		HttpServletRequest request = ServletActionContext.getRequest();
		Integer[] chapter_score;
		List<Chapter> chapterList = new ArrayList<>();
		if (subject != null) {
			chapterList = chapterService.findChapters(Integer.parseInt(subject));

			chapter_score = new Integer[chapterList.size()];

			for (int i = 0; i < chapterList.size(); i++) {
				String oo = "chapter_" + chapterList.get(i).getId();
				chapter_score[i] = Integer.parseInt(request.getParameter(oo));
				System.out.println("第" + i + "个章节分配的分数是---" + chapter_score[i]);
				if (chapter_score[i] > 0) {
					// 如果该章节被分配了分数，则计算该章节出题的各种题型的分数
					int chapter_single_score = (int) Math
							.floor(chapter_score[i] * single_scale);
					int chapter_check_score = (int) Math.floor(chapter_score[i]
							* check_scale);
					int chapter_judge_score = (int) Math.floor(chapter_score[i]
							* judge_scale);
					int chapter_blank_score = (int) Math.floor(chapter_score[i]
							* blank_scale);

					System.out.println("章节中单选该抽取的分数   ----- "
							+ chapter_single_score);
					System.out.println("章节中多选该抽取的分数   ----- "
							+ chapter_check_score);
					System.out.println("章节中判断该抽取的分数   ----- "
							+ chapter_judge_score);
					System.out.println("章节中填空该抽取的分数   ----- "
							+ chapter_blank_score);

					// 查询该章节下的所有试题
					List<Test> testList = testService.findByChapter(chapterList
							.get(i).getId());

					// 保存各个章节下的各种题型的集合
					List<Test> singleTest = new ArrayList<>();
					List<Test> checkTest = new ArrayList<>();
					List<Test> judgeTest = new ArrayList<>();
					List<Test> blankTest = new ArrayList<>();

					for (Test test : testList) {
						if (test.getType() == 1) {
							singleTest.add(test);
						} else if (test.getType() == 2) {
							checkTest.add(test);
						} else if (test.getType() == 3) {
							judgeTest.add(test);
						} else if (test.getType() == 4) {
							blankTest.add(test);
						}
					}

					// 在各种题型的集合中抽取试题

					if (singleTest.size() > 0) {
						// 抽单选
						TestAlgorithm.getTest(singleTest, allTest,
								chapter_single_score);
					}

					if (checkTest.size() > 0) {
						// 抽多选
						if (chapter_check_score % 2 != 0) {
							chapter_check_score = chapter_check_score - 1;
						}
						TestAlgorithm.getTest(checkTest, allTest,
								chapter_check_score);
					}

					if (judgeTest.size() > 0) {
						// 抽判断
						TestAlgorithm.getTest(judgeTest, allTest,
								chapter_judge_score);
					}

					if (blankTest.size() > 0) {
						// 抽填空
						TestAlgorithm.getTest(blankTest, allTest,
								chapter_blank_score);
					}

				}

			}
		}

		// 抽取出来各种题型的分数
		int z_score = 0;
		int z_single_score = 0;
		int z_check_score = 0;
		int z_judge_score = 0;
		int z_blank_score = 0;

		for (Test test : allTest) {
			System.out.println("抽取出来的所有试题的集合的id----- " + test.getId());

			z_score += test.getScore();

			if (test.getType() == 1) {
				z_single_score += test.getScore();
			} else if (test.getType() == 2) {
				z_check_score += test.getScore();
			} else if (test.getType() == 3) {
				z_judge_score += test.getScore();
			} else if (test.getType() == 4) {
				z_blank_score += test.getScore();
			}
		}

		System.out.println("汇总后的抽取的总分数---" + z_score);

		System.out.println("汇总后  单选 的抽取的总分数---" + z_single_score);
		System.out.println("汇总后  多选 的抽取的总分数---" + z_check_score);
		System.out.println("汇总后  判断 的抽取的总分数---" + z_judge_score);
		System.out.println("汇总后  填空 的抽取的总分数---" + z_blank_score);

		// 各种题型不足的分数
		int single_c_score = 0;
		int check_c_score = 0;
		int judge_c_score = 0;
		int blank_c_score = 0;

		if (z_single_score != model.getSingle_score()) {
			single_c_score = model.getSingle_score() - z_single_score;
		}
		if (z_check_score != model.getCheck_srore()) {
			check_c_score = model.getCheck_srore() - z_check_score;
		}
		if (z_judge_score != model.getJudge_score()) {
			judge_c_score = model.getJudge_score() - z_judge_score;
		}
		if (z_blank_score != model.getBlank_score()) {
			blank_c_score = model.getBlank_score() - z_blank_score;
		}

		// 抽取不足的分数
		// 1.得到题库中所有的试题信息-----
		// 查询该科目题库的各种题型的总数
		// List<Object[]> num = testService.selectSumType(subject);
		List<Test> all_Test = testService.findAll();

		// 保存各个章节下的各种题型的集合
		List<Test> single_Test = new ArrayList<>();
		List<Test> check_Test = new ArrayList<>();
		List<Test> judge_Test = new ArrayList<>();
		List<Test> blank_Test = new ArrayList<>();

		System.out.println("移除前的长度----" + all_Test.size());

		// 移除已经抽取过的试题
		all_Test.removeAll(allTest);

		System.out.println("移除后的长度----" + all_Test.size());

		// 在未抽取过的试题集合按题型分类（此次只分题型抽取）
		for (Test test : all_Test) {
			if (test.getType() == 1) {
				single_Test.add(test);
			} else if (test.getType() == 2) {
				check_Test.add(test);
			} else if (test.getType() == 3) {
				judge_Test.add(test);
			} else if (test.getType() == 4) {
				blank_Test.add(test);
			}
		}

		// 抽题
		if (single_c_score > 0) {
			TestAlgorithm.getTest(single_Test, allTest, single_c_score);
		}
		if (check_c_score > 0) {
			TestAlgorithm.getTest(check_Test, allTest, check_c_score);
		}
		if (judge_c_score > 0) {
			TestAlgorithm.getTest(judge_Test, allTest, judge_c_score);
		}
		if (blank_c_score > 0) {
			TestAlgorithm.getTest(blank_Test, allTest, blank_c_score);
		}

		// ---------------------------------

		// 抽取出来各种题型的分数
		z_score = 0;
		z_single_score = 0;
		z_check_score = 0;
		z_judge_score = 0;
		z_blank_score = 0;

		for (Test test : allTest) {
			System.out.println("再次抽取出来的所有试题的集合的id----- " + test.getId());

			z_score += test.getScore();

			if (test.getType() == 1) {
				z_single_score += test.getScore();
			} else if (test.getType() == 2) {
				z_check_score += test.getScore();
			} else if (test.getType() == 3) {
				z_judge_score += test.getScore();
			} else if (test.getType() == 4) {
				z_blank_score += test.getScore();
			}
		}

		System.out.println("第二次汇总后的抽取的总分数---" + z_score);

		System.out.println("第二次 汇总后  单选 的抽取的总分数---" + z_single_score);
		System.out.println("第二次 汇总后  多选 的抽取的总分数---" + z_check_score);
		System.out.println("第二次 汇总后  判断 的抽取的总分数---" + z_judge_score);
		System.out.println("第二次 汇总后  填空 的抽取的总分数---" + z_blank_score);
		
	
		
//		model.setTests(new HashSet<>(allTest));
		
		Subject s = subjectService.getById(Integer.parseInt(subject));
		
//		model.setSubject(s.getName());
		
		Paper paper = new Paper(model.getName(), model.getTime(), model.getScore(), s.getName(), 
				model.getSingle_score()	, model.getCheck_srore(), model.getJudge_score(), model.getBlank_score(),
				new HashSet<>(allTest));
		
		paperService.save(paper);
		
		System.out.println("成功生成一份试卷------------------------");
	}
	
	public Double getRepeated() {
		return repeated;
	}

	public void setRepeated(Double repeated) {
		this.repeated = repeated;
	}

	public Double getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Double difficulty) {
		this.difficulty = difficulty;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}
