package com.tms.entity.test;

import java.util.HashSet;
import java.util.Set;

import com.tms.entity.chapter.Chapter;
import com.tms.entity.know.Know;
import com.tms.entity.paper.Paper;

/**
 * 试题信息类
 * 
 * @author mugbya
 * 
 * @version 2014年4月30日
 * 
 */
public class Test {
	private Integer id;
	private String question;
	private String answer;
	private Boolean orderly;
	private Integer type;
	private Integer score;
	private Integer difficulty;
	private String testName;
	private Boolean repeat;
	private Boolean status;
	private Set<Know> knows = new HashSet<>();
	private Set<Choices> choices = new HashSet<>();
	private Set<Paper> papers = new HashSet<>();
	private Chapter chapter;

	public Test() {
	}

	public Test(String question, String answer, Boolean orderly, Integer type,
			Integer score, Integer difficulty, String testName) {
		super();
		this.question = question;
		this.answer = answer;
		this.orderly = orderly;
		this.type = type;
		this.score = score;
		this.difficulty = difficulty;
		this.testName = testName;
	}

	public Chapter getChapter() {
		return chapter;
	}

	public void setChapter(Chapter chapter) {
		this.chapter = chapter;
	}

	public Set<Paper> getPapers() {
		return papers;
	}

	public void setPapers(Set<Paper> papers) {
		this.papers = papers;
	}

	public Boolean getRepeat() {
		return repeat;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public void setRepeat(Boolean repeat) {
		this.repeat = repeat;
	}

	public Set<Choices> getChoices() {
		return choices;
	}

	public void setChoices(Set<Choices> choices) {
		this.choices = choices;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Boolean getOrderly() {
		return orderly;
	}

	public void setOrderly(Boolean orderly) {
		this.orderly = orderly;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Integer difficulty) {
		this.difficulty = difficulty;
	}

	public Set<Know> getKnows() {
		return knows;
	}

	public void setKnows(Set<Know> knows) {
		this.knows = knows;
	}

}
