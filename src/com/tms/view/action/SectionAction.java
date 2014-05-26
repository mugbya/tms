package com.tms.view.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.tms.base.BaseAction;
import com.tms.entity.chapter.Chapter;
import com.tms.entity.section.Section;

/**
 * @author mugbya
 * 
 * @version 2014年4月25日
 *
 */
@Controller
@Scope("prototype")
public class SectionAction extends BaseAction<Section>{

	private static final long serialVersionUID = 1L;
	
	private Integer chapterId;
	
	/** 列表*/
	public String list() throws Exception {

		return "list";
	}
	
	/** 删除*/
	public String delete() throws Exception {
		sectionService.delete(model.getId());
		return "toList";
	}

	/** 添加页面*/
	public String addUI() throws Exception {	
		return "saveUI";
	}

	/** 添加*/
	public String add() throws Exception {
		System.out.println("-----"+chapterId);
		Chapter chapter = chapterService.getById(chapterId);
		model.setChapter(chapter);
		sectionService.save(model);
		return "toList";
	}
	
	/** 修改页面*/
	public String editUI() throws Exception {
		Section section = sectionService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(section);
		return "saveUI";
	}

	/** 修改*/
	public String edit() throws Exception {
		Section section = sectionService.getById(model.getId());
		
		section.setName(model.getName());
		
		sectionService.update(section);
		
		return "toList";
	}

	
	public Integer getChapterId() {
		return chapterId;
	}

	public void setChapterId(Integer chapterId) {
		this.chapterId = chapterId;
	}	
	
}
