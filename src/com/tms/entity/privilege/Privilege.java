package com.tms.entity.privilege;

import java.util.HashSet;
import java.util.Set;

import com.tms.entity.role.Role;

/**
 * @author mugbya
 * 
 * @version 2014年4月23日
 * 
 */
public class Privilege {
	private Integer id;
	private Set<Role> roles = new HashSet<Role>();
	private String name; // 权限名称
	private String url;
	private Privilege parent;
	private Set<Privilege> children = new HashSet<>();

	
	public Privilege() {
	}
	
	public Privilege(String name, String url, Privilege parent) {
		super();
		this.name = name;
		this.url = url;
		this.parent = parent;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Privilege getParent() {
		return parent;
	}

	public void setParent(Privilege parent) {
		this.parent = parent;
	}

	public Set<Privilege> getChildren() {
		return children;
	}

	public void setChildren(Set<Privilege> children) {
		this.children = children;
	}

}
