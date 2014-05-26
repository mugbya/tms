package com.tms.entity.know;

import java.util.Set;

import com.tms.entity.section.Section;
import com.tms.entity.test.Test;

/**
 * @author mugbya
 * 
 * @version 2014年4月27日
 * 
 */
public class Know {
	private Integer id;
	private String name;
	private String description;


	private Set<Section> sections;

	private Set<Test> tests;

	public Set<Test> getTests() {
		return tests;
	}

	public void setTests(Set<Test> tests) {
		this.tests = tests;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Section> getSections() {
		return sections;
	}

	public void setSections(Set<Section> sections) {
		this.sections = sections;
	}

}
