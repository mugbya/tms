package com.tms.view.action;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.tms.base.BaseAction;
import com.tms.entity.chapter.Chapter;
import com.tms.entity.know.Know;
import com.tms.entity.section.Section;
import com.tms.entity.subject.Subject;

/**
 * @author mugbya
 * 
 * @version 2014年4月28日
 * 
 */
@Controller
@Scope("prototype")
public class KnowAction extends BaseAction<Know> {

	private static final long serialVersionUID = 1L;

	private Integer[] sectionIds;
	private Integer[] knowIds;
	private Integer type;
	private Integer sectionId;

	/** 列表 */
	public String list() throws Exception {

//		User user = (User) ActionContext.getContext().getSession().get("user");
//
//		// 只关心type == 2 的角色信息
//		Set<Subject> subjectList = new HashSet<>();
//		for (Role role : user.getRoles()) {
//			if (role.getType() == 2) {
//				subjectList = role.getSubjects();
//			}
//		}

		// 查询科目
		List<Subject> subjectList = subjectService.findAll();
		ActionContext.getContext().put("subjectList", subjectList);

		// 查询章节
		List<Chapter> chapterList = chapterService.findAll();
		ActionContext.getContext().put("chapterList", chapterList);

		// 查询小节
		List<Section> sectionList = sectionService.findAll();
		ActionContext.getContext().put("sectionList", sectionList);

		//

		return "list";
	}

	/** 删除 */
	public String delete() throws Exception {

		// 小节与知识点多对多关系，不能简单删除，一删全删，只删除当前小节下的知识点
		Section section = sectionService.findById(sectionId);
		Set<Know> knowList = section.getKnows();

		for (Know know : knowList) {
			if (know.getId().equals(model.getId())) {
				knowList.remove(know);
			}
		}

		section.setKnows(new HashSet<>(knowList));
		sectionService.update(section);
		// knowService.delete(model.getId());
		return "toList";
	}

	/** 添加页面 */
	public String addUI() throws Exception {

		System.out.println("小节的ID----" + sectionId);

		if (type != null && type == 1) {

			Section section = sectionService.findById(sectionId);

			ActionContext.getContext().put("section", section);

			// 查询所有的知识点信息
			List<Know> knowList = knowService.findAll();
			ActionContext.getContext().put("knowList", knowList);
		}

		if (type != null && type == 2) {
			// 准备小节数据
			List<Section> sectionList = sectionService.findAll();
			ActionContext.getContext().put("sectionList", sectionList);
		}
		return "saveUI";
	}

	/** 添加 */
	public String add() throws Exception {

		if (type == 1) {
			List<Know> knowList = knowService.getByIds(knowIds);
			System.out.println("选择了多少知识点----" + knowList.size());
			System.out.println("小节的ID是" + sectionId);
			Section section = sectionService.findById(sectionId);
			System.out.println("小节信息------" + section);
			section.setKnows(new HashSet<>(knowList));
			sectionService.update(section);
		}

		if (type == 2) {
			List<Section> sections = sectionService.getByIds(sectionIds);
			model.setSections(new HashSet<>(sections));
			knowService.save(model);
		}
		return "toList";
	}

	/** 修改页面 */
	public String editUI() throws Exception {

		// 准备小节数据
		List<Section> sectionList = sectionService.findAll();
		ActionContext.getContext().put("sectionList", sectionList);

		// 准备回显数据
		Know know = knowService.getById(model.getId());

		ActionContext.getContext().getValueStack().push(know);

		if (know.getSections() != null) {
			sectionIds = new Integer[know.getSections().size()];
			int index = 0;
			for (Section section : know.getSections()) {
				sectionIds[index++] = section.getId();
			}
		}

		return "saveUI";
	}

	/** 修改 */
	public String edit() throws Exception {
		// 从数据库中取出原对象
		Know know = knowService.getById(model.getId());

		// 设置要修改的属性
		know.setName(model.getName());
		know.setDescription(model.getDescription());

		// 设置关联的小节
		List<Section> sections = sectionService.getByIds(sectionIds);
		model.setSections(new HashSet<>(sections));

		// 更新到数据库
		knowService.update(know);
		return "toList";
	}

	public Integer[] getSectionIds() {
		return sectionIds;
	}

	public void setSectionIds(Integer[] sectionIds) {
		this.sectionIds = sectionIds;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer[] getKnowIds() {
		return knowIds;
	}

	public void setKnowIds(Integer[] knowIds) {
		this.knowIds = knowIds;
	}

	public Integer getSectionId() {
		return sectionId;
	}

	public void setSectionId(Integer sectionId) {
		this.sectionId = sectionId;
	}

}
