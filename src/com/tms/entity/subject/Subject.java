package com.tms.entity.subject;

import java.util.HashSet;
import java.util.Set;

import com.tms.entity.chapter.Chapter;

/**
 * @author mugbya
 * 
 * @version 2014年4月20日
 * 
 */
public class Subject {
	private Integer id;
	private String name;
	private String description;
	private Integer time;

	// 添加关联属性，用于存储相关的chapters对象
	private Set<Chapter> chapters = new HashSet<>();

	
	public Set<Chapter> getChapters() {
		return chapters;
	}

	public void setChapters(Set<Chapter> chapters) {
		this.chapters = chapters;
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

	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

}
