package com.tms.entity.user;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;
import com.tms.entity.privilege.Privilege;
import com.tms.entity.role.Role;

/**
 * @author mugbya
 * 
 * @version 2014年4月18日
 * 
 */
public class User {
	private Integer id;
	private String loginName;
	private String password;
	private String name;
	private String desc;
	private Set<Role> roles = new HashSet<>();

	/**
	 * 检测该用户是否有指定名称的权限
	 * @param name
	 * @return
	 */
	public boolean hasPrivilegeByName(String name) {
		//root权限
		if (isAdmin()) {
			return true;
		}
		//普通用户
		for (Role role : roles) {
			for (Privilege priv : role.getPrivileges()) {
				if (priv.getName().equals(name)) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 判断本用户是否是root
	 * @return
	 */
	public boolean isAdmin() { 
		return "admin".equals(loginName);
	}

	/**
	 * 检测该用户是否有指定名称的权限
	 * @param name
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public boolean hasPrivilegeByUrl(String url) {
		//root权限
		if (isAdmin()) {
			return true;
		}
		// >> 去掉后面的参数
		int pos = url.indexOf("?");
		if (pos > -1) {
			url = url.substring(0,pos);
		}
		// >> 去掉UI后缀
		if (url.endsWith("UI")) {
			url = url.substring(0, url.length() - 2);
		}
		
		//如果本url不需要控制，则登录用户就可以使用
		Collection<String> allPrivilegeUrls = (Collection<String>) ActionContext.getContext().getApplication().get("allPrivilegeUrls");
		if (!allPrivilegeUrls.contains(url)) {
			return true;
		}else {
			//普通用户
			for (Role role : roles) {
				for (Privilege priv : role.getPrivileges()) {
					if (url.equals(priv.getUrl())) {
						return true;
					}
				}
			}
			return false;			
		}
		

	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
