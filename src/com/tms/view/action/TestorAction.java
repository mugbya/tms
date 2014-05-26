package com.tms.view.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tms.entity.chapter.Chapter;
import com.tms.entity.know.Know;
import com.tms.entity.section.Section;
import com.tms.entity.subject.Subject;
import com.tms.entity.test.Choices;
import com.tms.entity.test.Test;
import com.tms.service.chapter.ChapterService;
import com.tms.service.know.KnowService;
import com.tms.service.section.SectionService;
import com.tms.service.subject.SubjectService;
import com.tms.service.test.ChoicesService;
import com.tms.service.test.TestService;

/**
 * @author mugbya
 * 
 * @version 2014年5月2日
 * 
 */
@Controller
@Scope("prototype")
public class TestorAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Resource
	protected KnowService knowService;
	@Resource
	protected TestService testService;
	@Resource
	protected ChoicesService choicesService;
	@Resource
	protected SubjectService subjectService;
	@Resource
	protected ChapterService chapterService;
	@Resource
	protected SectionService sectionService;
	
	private Integer knowId;
//	private Integer[] knowIds;
	private String question;
	private String answer;
	private Boolean orderly;
	private Integer type;
	private Integer score;
	private Integer difficulty;
	private String testName;
	private String value;
	private String number;

//	private Integer chapterId;
	
//	private Integer testId;
	
	private Integer id;
	
	/** 列表 */
	public String list() throws Exception {
		List<Test> testList = null;
//		if (knowId == null) {
//			testList = testService.findAll();
//		} else {
//			testList = testService.findByKnow(knowId);
//		}
		testList = testService.findAll();
		ActionContext.getContext().put("testList", testList);
		return "list";
	}

	/** 删除 */
	public String delete() throws Exception {
		// testService.delete(model.getId());
		testService.delete(id);
		return "toList";
	}

	/** 添加页面 */
	public String addUI() throws Exception {
		// 准备数据
		
		//查询科目，章节
		List<Subject> subjectList = subjectService.findAll();
		ActionContext.getContext().put("subjectList", subjectList);

		// 查询章节
		List<Chapter> chapterList = chapterService.findAll();
		ActionContext.getContext().put("chapterList", chapterList);

		// 查询小节
		List<Section> sectionList = sectionService.findAll();
		ActionContext.getContext().put("sectionList", sectionList);
		
		//查询所有的知识点
//		List<Know> knowList = knowService.findAll();
//		ActionContext.getContext().put("knowList", knowList);
		
		return "saveUI";
	}
   
	/** 添加 */ 
	public String add() throws Exception {   			
  
		System.out.println("知识点的id是多少-------"+knowId);
		Know know = knowService.getById(knowId);
		
		System.out.println("value是是什么形式：----------"+ value);
		System.out.println("number是怎样的形式：-------"+number);
		/* 把页面传替过来的答案拆分出来*/
		String[] values = value.split(",");
		
		System.out.println("values的长度是：-------"+values.length);
		if (type == 1) {
			//单选时保存答案
			answer =  values[Integer.parseInt(number.trim())].trim();			
		}else if (type == 2) {
			// 把正确答案个数拆分出来
			String[] numbers = number.split(",");
			System.out.println("numbers的长度是多少--------------："+numbers.length);	
			//保存答案是先置为""
			answer = "";
			for(int i = 0;i < numbers.length; i++){
				System.out.println("每个numbers的值是----------"+numbers[i].trim());
				answer += "~" + values[Integer.parseInt(numbers[i].trim())].trim();
			}
			//去掉第一个“~”
			answer = answer.substring(1).trim();  			
		}else if (type == 4) {
			// 填空
			//保存答案是先置为""
			answer = "";
			for(int i = 0; i < values.length; i++){
				answer += "~" + values[i].trim();
			}
			//去掉第一个“~”
			answer = answer.substring(1).trim();  			
		}
		
		System.out.println("answer是什么形式..-----------"+answer);
		
		Test test = new Test(question, answer, orderly, type, score, difficulty, testName);
		// 知识点与试题本该是多对多，但用easyUI时，目前只能选择单个，故此做如下更改
//		List<Know>knowList = knowService.getByIds(knowIds);
		List<Know>knowList = new ArrayList<>();
		knowList.add(know);
		test.setKnows(new HashSet<>(knowList));
		testService.save(test);
		
		Test test_c = testService.findByQuestion(question);
		
		for (int i = 0; i < values.length; i++) {
			Choices choices = new Choices();
			choices.setValue(values[i].trim());
			choices.setTest(test_c);
			choicesService.save(choices);	
		}
		return "toList";
	}

	/** 修改页面 */
	public String editUI() throws Exception {
		
		//查询科目，章节
		List<Subject> subjectList = subjectService.findAll();
		ActionContext.getContext().put("subjectList", subjectList);

		// 查询章节
		List<Chapter> chapterList = chapterService.findAll();
		ActionContext.getContext().put("chapterList", chapterList);

		// 查询小节
		List<Section> sectionList = sectionService.findAll();
		ActionContext.getContext().put("sectionList", sectionList);
		
		//准备选项数据

		List<Choices>choicesList = choicesService.findByTestId(id); // choicesService.findAll();
		ActionContext.getContext().put("choicesList", choicesList);
		
		//准备回显数据
		Test test = testService.getById(id);
		
		System.out.println("答案是--------------" + test.getAnswer());
		
		ActionContext.getContext().getValueStack().push(test);		
		
		return "saveUI";
	}

	/** 修改 */
	public String edit() throws Exception {
		
		System.out.println("number的值是：------------ " + number);
		System.out.println("testId的值是：------------ " + id);
		
		//从数据库中取出原对象
		Test test = testService.getById(id);
		List<Choices> choicesList = choicesService.findByTestId(id);
		
		System.out.println("test有值没有：" + test);
		
		/* 把答案拆分出来*/
		String[] values = value.split(",");
		
		if (type == 1) {
			//单选时保存答案
			answer =  values[Integer.parseInt(number.trim())].trim();			
		}else if (type == 2) {
			// 把正确答案个数拆分出来
			String[] numbers = number.split(",");
			System.out.println("numbers的长度是多少--------------："+numbers.length);	
			//保存答案是先置为""
			answer = "";
			for(int i = 0;i < numbers.length; i++){
				System.out.println("每个numbers的值是----------"+numbers[i].trim());
				answer += "~" + values[Integer.parseInt(numbers[i].trim())].trim();
			}
			//去掉第一个“~”
			answer = answer.substring(1).trim();  			
		}else if (type == 4) {
			// 填空 ,其实没用answer(把答案备份到了选项列表中，这么做方便...)
			//保存答案是先置为""
			answer = "";
			for(int i = 0; i < values.length; i++){
				answer += "~" + values[i].trim();
			}
			//去掉第一个“~”
			answer = answer.substring(1).trim();  			
		}		
		
		System.out.println("answer是----------------:"+answer.trim());
		
		
		
		//设置要修改的属性
		test.setAnswer(answer.trim());
		test.setQuestion(question);
		test.setTestName(testName);
		test.setType(type);
		test.setScore(score);
		test.setOrderly(orderly);
		test.setDifficulty(difficulty);
		
		//设置关联属性
		Know know = knowService.getById(knowId);
		List<Know>knowList = new ArrayList<>();
		knowList.add(know);
		test.setKnows(new HashSet<>(knowList));
		
		testService.update(test);;
		
		// 保存相关的选项
		Test test_c = testService.findByQuestion(question);
		
		for (int i = 0; i < values.length; i++) {
			//Choices choices = new Choices();
			Choices choices = choicesList.get(i);
			choices.setValue(values[i].trim());
			choices.setTest(test_c);
			choicesService.save(choices);	
		}
				
		return "toList";
	}

	public Integer getKnowId() {
		return knowId;
	}

	public void setKnowId(Integer knowId) {
		this.knowId = knowId;
	}

//	public Integer[] getKnowIds() {
//		return knowIds;
//	}
//
//	public void setKnowIds(Integer[] knowIds) {
//		this.knowIds = knowIds;
//	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Boolean getOrderly() {
		return orderly;
	}

	public void setOrderly(Boolean orderly) {
		this.orderly = orderly;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Integer difficulty) {
		this.difficulty = difficulty;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

//	public Integer getChapterId() {
//		return chapterId;
//	}
//
//	public void setChapterId(Integer chapterId) {
//		this.chapterId = chapterId;
//	}

}
