package com.tms.entity.role;

import java.util.HashSet;
import java.util.Set;

import com.tms.entity.privilege.Privilege;
import com.tms.entity.user.User;

/**
 * @author mugbya
 * 
 * @version 2014年4月18日
 * 
 */
public class Role {
	private Integer id;
	private String name;
	private String description;
//	private Integer type;

	private Set<User> users = new HashSet<>();
	private Set<Privilege> privileges = new HashSet<>();
//	private Set<Subject> subjects = new HashSet<>();

//	public Set<Subject> getSubjects() {
//		return subjects;
//	}
//
//	public void setSubjects(Set<Subject> subjects) {
//		this.subjects = subjects;
//	}

//	public Integer getType() {
//		return type;
//	}
//
//	public void setType(Integer type) {
//		this.type = type;
//	}

	public Set<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Set<Privilege> privileges) {
		this.privileges = privileges;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
