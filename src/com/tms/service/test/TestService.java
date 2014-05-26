package com.tms.service.test;

import java.util.List;

import com.tms.base.DaoSupport;
import com.tms.entity.test.Test;

/**
 * @author mugbya
 * 
 * @version 2014年4月30日
 *
 */
public interface TestService extends DaoSupport<Test>{

	/**
	 * 依据知识点进行查询
	 * @param knowId
	 * @return
	 */
	List<Test> findByKnow(Integer knowId);

	/**
	 * 依据问题查出test对象
	 * @param question
	 * @return
	 */
	Test findByQuestion(String question);

	/**
	 * 查询所有题库名称
	 * @return
	 */
	List<String> findAllTestName();

	/**
	 *  重置抽提状态（将所有题都置为未抽取状态 --false）
	 */
	void setStatus();

	/**
	 * 查询各种题型的总数
	 * @param subject 
	 * @return
	 */
	List<Object []> selectSumType(String subject);

	/**
	 * 以给定的test对象将试题抽取状态置为true
	 * @param test
	 */
	void setStatus(Test test);

	/**
	 * 根据Id找到其test
	 * @param id
	 * @return
	 */
	Test findById(Integer id);

	/**
	 * 以给定的题库名称返回该题库所有的题型
	 * @param subject
	 * @return
	 */
	List<Test> findAll(String subject);

	/**
	 * 给定章节id，查询相同章节下的所有试题
	 * @param id
	 * @return
	 */
	List<Test> findByChapter(Integer id);


}
