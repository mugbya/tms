package com.tms.entity.test;

/**
 * 选择信息表
 * 
 * @author mugbya
 * 
 * @version 2014年5月1日
 * 
 */
public class Choices {
	private Integer id;
	private String value;

	private Test test;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

}
