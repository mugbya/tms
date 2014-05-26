package com.tms.view.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.tms.base.BaseAction;
import com.tms.entity.subject.Subject;


/**
 * @author mugbya
 * 
 * @version 2014年4月20日
 *
 */    
@Controller
@Scope("prototype")
public class SubjectAction extends BaseAction<Subject>{

	private static final long serialVersionUID = 1L;
	
	
	/** 列表*/     
	public String list() throws Exception {     
//		List<Subject> subjectList = subjectService.findAll();
//		ActionContext.getContext().put("subjectList", subjectList);
		
		//查询科目
		List<Subject>subjectList = subjectService.findAll();
		ActionContext.getContext().put("subjectList", subjectList);	
		
//		List<Chapter>chapterList = chapterService.findAll();
//		ActionContext.getContext().put("chapterList", chapterList);
//		
//		List<Section>sectionList = sectionService.findAll();
//		ActionContext.getContext().put("sectionList", sectionList);
   
//      最初的想法
//		if (subjectId != null) {
//		List<Chapter>chapterList = chapterService.findChapters(subjectId);	
//		ActionContext.getContext().put("chapterList", chapterList);
//	}
//		if (chapterId != null) {
//			List<Section>sectionList = sectionService.findSection(chapterId);
//			ActionContext.getContext().put("sectionList", sectionList);
//		}
		    
		return "list";    
	}
	      
	/** 删除*/
	public String delete() throws Exception {
		subjectService.delete(model.getId());
		return "toList";
	}

	/** 添加科目页面*/
	public String addUI() throws Exception {	
		return "saveUI";
	}
	    
	/** 添加科目*/
	public String add() throws Exception {
		subjectService.save(model);
		return "toList";  
	}
	
	/** 修改页面*/
	public String editUI() throws Exception {
  
		Subject subject = subjectService.getById(model.getId());

		ActionContext.getContext().getValueStack().push(subject);
		return "saveUI";
	}

	/** 修改*/
	public String edit() throws Exception {
		//从数据库中获取原对象
		Subject subject = subjectService.getById(model.getId());
		
		// 设置要修改的属性
		subject.setName(model.getName());
		subject.setDescription(model.getDescription());
		subject.setTime(model.getTime());
		
		//更新到数据库
		subjectService.update(subject);
		return "toList";
	}

	
}
