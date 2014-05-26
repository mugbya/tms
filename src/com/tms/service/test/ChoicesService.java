package com.tms.service.test;

import java.util.List;

import com.tms.base.DaoSupport;
import com.tms.entity.test.Choices;

/**
 * @author mugbya
 * 
 * @version 2014年5月1日
 *
 */
public interface ChoicesService extends DaoSupport<Choices>{

	/**
	 * 以试题Id查询相应的选项
	 * @param testId
	 * @return
	 */
	List<Choices> findByTestId(Integer testId);

}
