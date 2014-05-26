package com.tms.entity.section;

import java.util.Set;

import com.tms.entity.chapter.Chapter;
import com.tms.entity.know.Know;

/**
 * @author mugbya
 * 
 * @version 2014年4月25日
 * 
 */
public class Section {
	private Integer id;
	private String name;
	private Chapter chapter;

	private Set<Know> knows;

	public Set<Know> getKnows() {
		return knows;
	}

	public void setKnows(Set<Know> knows) {
		this.knows = knows;
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

	public Chapter getChapter() {
		return chapter;
	}

	public void setChapter(Chapter chapter) {
		this.chapter = chapter;
	}

}
