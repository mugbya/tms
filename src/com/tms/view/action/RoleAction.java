package com.tms.view.action;

import java.util.HashSet;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.tms.base.BaseAction;
import com.tms.entity.privilege.Privilege;
import com.tms.entity.role.Role;

/**
 * 
 * @author mugbya
 * 
 * @version 2014年4月19日
 *
 */
@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role>{

	private static final long serialVersionUID = 1L;

	private Integer[] privilegeIds;
	private Integer[] subjectIds;
	
	/** 列表*/
	public String list() throws Exception {
		List<Role> roleList = roleService.findAll();
		ActionContext.getContext().put("roleList", roleList);
		return "list";
	}
	
	/** 删除*/
	public String delete() throws Exception {
		roleService.delete(model.getId());
		System.out.println("删除调用完毕");
		return "toList";
	}

	/** 添加页面*/
	public String addUI() throws Exception {
		 
		return "saveUI";
	}
	
	/** 添加*/
	public String add() throws Exception {
//		Role role = new Role();
//		role.setName(model.getName()); 
//		role.setDesc(model.getDesc());
//		roleService.save(role);
		
		roleService.save(model);
		return "toList";
	}
	
	/** 修改页面*/
	public String editUI() throws Exception {
		//准备回显的数据
		Role role = roleService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(role);
		
		return "saveUI";
	}

	/** 修改*/
	public String edit() throws Exception {
		// 1.从数据库中获取原对象
		Role role = roleService.getById(model.getId());
		
		// 2. 设置要修改的属性
		role.setName(model.getName());
		role.setDescription(model.getDescription());
		
		// 3. 更新到数据库
		roleService.update(role);
		
		return "toList";
	}	
	
	/** 设置权限页面*/
	public String setPrivilegeUI() throws Exception {
		//准备回显的数据
		Role role = roleService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(role);
		
		if (role.getPrivileges() != null) {
			privilegeIds = new Integer[role.getPrivileges().size()];
			int index = 0;
			for (Privilege priv : role.getPrivileges()) {
				privilegeIds[index++] = priv.getId();
			}
		}
		
//		if (role.getSubjects() != null) {
//			subjectIds = new Integer[role.getSubjects().size()];
//			int index = 0;
//			for (Subject s : role.getSubjects()) {
//				subjectIds[index++] = s.getId();
//			}
//		}
		
		// 准备数据 privilegeList
		List<Privilege> privilegeList = privilegeService.findAll();
			
//		if (role.getType() == 2) {
//			//准备课程数据
//			List<Subject>subjectList = subjectService.findAll();
//			ActionContext.getContext().put("subjectList", subjectList);			
//		}
		
		ActionContext.getContext().put("privilegeList", privilegeList); 	
		
		return "setPrivilegeUI";
	}

	/** 设置权限*/
	public String setPrivilege() throws Exception {
		// 1.从数据库中获取原对象
		Role role = roleService.getById(model.getId());
		
		// 2. 设置要修改的属性
		List<Privilege>privilegeList = privilegeService.getByIds(privilegeIds);
		role.setPrivileges(new HashSet<Privilege>(privilegeList));
		
//		if (role.getType() == 2) {
//			List<Subject>subjectList  = subjectService.getByIds(subjectIds);
//			role.setSubjects(new HashSet<>(subjectList));
//		}	
		
		// 3. 更新到数据库
		roleService.update(role);     
		
		return "toList";
	}

	//----------------
	public Integer[] getPrivilegeIds() {
		return privilegeIds;
	}

	public void setPrivilegeIds(Integer[] privilegeIds) {
		this.privilegeIds = privilegeIds;
	}

	public Integer[] getSubjectIds() {
		return subjectIds;
	}

	public void setSubjectIds(Integer[] subjectIds) {
		this.subjectIds = subjectIds;
	}	
			
}
