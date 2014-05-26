package com.tms.entity.paper;

/**
 * 试卷信息表
 * 
 * @author mugbya
 * 
 * @version 2014年5月4日
 * 
 */
public class Paper_param {
	private Integer id;
	private String name;
	private Integer time;
	private String total_score;

	// 各种题型分配的分数
	private Integer single_score;
	private Integer check_srore;
	private Integer judge_score;
	private Integer blank_score;
	private Integer write_score;
	private Integer operating_score;

	// 设置试卷允许重复的比例
	private Double repeated;

	// 设置难度系数比例
	private Double difficulty;

	//设置试卷份数
	private Integer number;
		
	
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
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

	public String getTotal_score() {
		return total_score;
	}

	public void setTotal_score(String total_score) {
		this.total_score = total_score;
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

	public Integer getWrite_score() {
		return write_score;
	}

	public void setWrite_score(Integer write_score) {
		this.write_score = write_score;
	}

	public Integer getOperating_score() {
		return operating_score;
	}

	public void setOperating_score(Integer operating_score) {
		this.operating_score = operating_score;
	}

	public Double getRepeated() {
		return repeated;
	}

	public void setRepeated(Double repeated) {
		this.repeated = repeated;
	}

	public Double getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Double difficulty) {
		this.difficulty = difficulty;
	}

}
