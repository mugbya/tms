package com.tms.view.action;


import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionContext;
import com.tms.base.BaseAction;
import com.tms.entity.chapter.Chapter;
import com.tms.entity.section.Section;
import com.tms.entity.subject.Subject;


/**
 * @author mugbya
 * 
 * @version 2014年4月25日
 *
 */
@Controller
@Scope("prototype")
public class ChapterAction extends BaseAction<Chapter>{

	private static final long serialVersionUID = 1L;

	private Integer subjectId;
	
	/** 列表*/
	public String list() throws Exception {
		
//		Map<String, Object> userList = ActionContext.getContext().getSession();
//	
//		User user = (User)userList.get("user");
//		
//		//查询用户对应的角色----
////		Set<Role> roles = user.getRoles();
//		
//		//只关心type == 2 的角色信息
//		Set<Subject>subjectList = new HashSet<>();
//		for (Role role : user.getRoles()) {
//			if (role.getType() == 2) {
//				subjectList = role.getSubjects();
//			}else if (role.getType() == 1) {
////				List<Subject>subjectList = subjectService.findAll();
//			}
//		}				
		
		//查询科目
		List<Subject>subjectList = subjectService.findAll();
		ActionContext.getContext().put("subjectList", subjectList);	
		
		List<Chapter>chapterList = chapterService.findAll();
		ActionContext.getContext().put("chapterList", chapterList);
		
		List<Section>sectionList = sectionService.findAll();
		ActionContext.getContext().put("sectionList", sectionList);
		
		return "list";
	}
	
	/** 删除*/
	public String delete() throws Exception {
		chapterService.delete(model.getId());
		return "toList";
	}

	/** 添加页面*/
	public String addUI() throws Exception {	
		System.out.println("subjectId-----" + subjectId);
		return "saveUI";
	}
	
	/** 添加*/
	public String add() throws Exception {
		System.out.println("进入----- -------" + subjectId);
		
		Subject subject = subjectService.getById(subjectId);
		
		model.setSubject(subject);
		
		//保存
		chapterService.save(model);
		return "toList";
	}
	
	/** 修改页面*/
	public String editUI() throws Exception {
		Chapter chapter = chapterService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(chapter);
		return "saveUI";
	}

	/** 修改*/
	public String edit() throws Exception {
		Chapter chapter = chapterService.getById(model.getId());
		chapter.setName(model.getName());
		chapterService.update(chapter);
		return "toList";
	}

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}
	
	
}
