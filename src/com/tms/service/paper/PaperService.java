package com.tms.service.paper;

import com.tms.base.DaoSupport;
import com.tms.entity.paper.Paper;

/**
 * @author mugbya
 * 
 * @version 2014年5月4日
 *
 */
public interface PaperService extends DaoSupport<Paper>{

	/**
	 * 根据给定Id查询试卷
	 * @param id
	 * @return
	 */
	Paper findById(Integer id);

}
