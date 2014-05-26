package com.tms.entity.paper;

import java.util.HashSet;
import java.util.Set;

import com.tms.entity.test.Test;

/**
 * @author mugbya
 * 
 * @version 2014年5月4日
 * 
 */
public class Paper {
	private Integer id;
	private String name;
	private Integer time;
	private Integer score;
	private String subject;

	// 各种题型分配的分数
	private Integer single_score;
	private Integer check_srore;
	private Integer judge_score;
	private Integer blank_score;
	// private Integer write_score;
	// private Integer operating_score;

//	//题库 因设计时为把题库表单独拿出来，这里要用整形方便后面   ----------不需要
//	private Integer testName;
	
	private Set<Test> tests = new HashSet<>();

	public Paper(){}
	
	
	
	public Paper(String name, Integer time, Integer score, String subject,
			Integer single_score, Integer check_srore, Integer judge_score,
			Integer blank_score, Set<Test> tests) {
		super();
		this.name = name;
		this.time = time;
		this.score = score;
		this.subject = subject;
		this.single_score = single_score;
		this.check_srore = check_srore;
		this.judge_score = judge_score;
		this.blank_score = blank_score;
		this.tests = tests;
	}



	public Integer getSingle_score() {
		return single_score;
	}

	public void setSingle_score(Integer single_score) {
		this.single_score = single_score;
	}

	public Integer getCheck_srore() {
		return check_srore;
	}

	public void setCheck_srore(Integer check_srore) {
		this.check_srore = check_srore;
	}

	public Integer getJudge_score() {
		return judge_score;
	}

	public void setJudge_score(Integer judge_score) {
		this.judge_score = judge_score;
	}

	public Integer getBlank_score() {
		return blank_score;
	}

	public void setBlank_score(Integer blank_score) {
		this.blank_score = blank_score;
	}

	public Set<Test> getTests() {
		return tests;
	}

	public void setTests(Set<Test> tests) {
		this.tests = tests;
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

	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

//	public Integer getTestName() {
//		return testName;
//	}
//
//	public void setTestName(Integer testName) {
//		this.testName = testName;
//	}
}
