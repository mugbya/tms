package com.tms.view.action;

import java.util.HashSet;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.tms.base.BaseAction;
import com.tms.entity.role.Role;
import com.tms.entity.user.User;


/**
 * @author mugbya
 * 
 * @version 2014年4月22日
 *
 */
@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User>{
	private static final long serialVersionUID = 1L;
	
	private Integer[] roleIds;
	
	/** 列表*/
	public String list() throws Exception {
		List<User>userList = userService.findAll();
		ActionContext.getContext().put("userList", userList);
		return "list";
	}
	
	/** 删除*/
	public String delete() throws Exception {
		userService.delete(model.getId());
		return "toList";
	}

	/** 添加页面*/
	public String addUI() throws Exception {	
		//准备数据
		List<Role>roleList = roleService.findAll();
		ActionContext.getContext().put("roleList", roleList);
		return "saveUI";
	}
	
	/** 添加*/
	public String add() throws Exception {
		// 封装到对象中
		List<Role>roleList = roleService.getByIds(roleIds);
		model.setRoles(new HashSet<Role>(roleList));
		// 设置默认密码
		String md5Digest = DigestUtils.md5Hex("1234");
		model.setPassword(md5Digest);
		
		//保存到数据库
		userService.save(model);
		return "toList";
	}
	
	/** 修改页面*/
	public String editUI() throws Exception {
		//准备数据
		List<Role>roleList = roleService.findAll();
		ActionContext.getContext().put("roleList", roleList);
		
		//准备回显数据
		User user = userService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(user);
		
		 if (user.getRoles()!=null) {
			 roleIds = new Integer[user.getRoles().size()];
			int index = 0;
			for (Role role : user.getRoles()) {
				roleIds[index++] = role.getId();
			}
		}
		
		return "saveUI";
	}

	/** 修改*/
	public String edit() throws Exception {
		// 从数据库中取出原对象
		User user = userService.getById(model.getId());
		
		//设置要修改的属性
		user.setName(model.getName());
		user.setLoginName(model.getLoginName());
		user.setDesc(model.getDesc());
		user.setPassword(model.getPassword());
		
		//设置关联的角色
		List<Role>roleList = roleService.getByIds(roleIds);
		user.setRoles(new HashSet<Role>(roleList));
		
		//更新到数据库
		userService.update(user);
		return "toList";
	}	
	
	/** 初始化密码 1234*/
	public String initPassword() throws Exception {
		User user = userService.getById(model.getId());
		String md5Digest = DigestUtils.md5Hex("1234");
		user.setPassword(md5Digest);
		userService.update(user);
		return "toList";
	}

	/** 登录页面 */
	public String loginUI() throws Exception {
		return "loginUI";
	}
	/** 登录 */
	public String login() throws Exception {
		User user = userService.findByLoginNameAndPassword(model.getLoginName(), model.getPassword());
		if (user == null) {
			addFieldError("login", "用户名或密码不正确！");
			return "loginUI";
		} else {
			// 登录用户
			ActionContext.getContext().getSession().put("user", user);
			return "toIndex";
		}
	} 
	
	/** 注销 */
	public String logout() throws Exception {
		ActionContext.getContext().getSession().remove("user");
		return "logout";
	}
	
	//------------------
	public Integer[] getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(Integer[] roleIds) {
		this.roleIds = roleIds;
	}	
	
	
	
}
