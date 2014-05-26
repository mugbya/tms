package com.tms.entity.chapter;

import java.util.HashSet;
import java.util.Set;

import com.tms.entity.section.Section;
import com.tms.entity.subject.Subject;

/**
 * @author mugbya
 * 
 * @version 2014年4月20日
 * 
 */
public class Chapter {
	private Integer id;
	private String name;

	private Subject subject;

	private Set<Section> sections = new HashSet<>();
	
	public Set<Section> getSections() {
		return sections;
	}

	public void setSections(Set<Section> sections) {
		this.sections = sections;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
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

}
