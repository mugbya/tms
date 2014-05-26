package com.tms.service.paper;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tms.base.DaoSupportImpl;
import com.tms.entity.paper.Paper;

/**
 * @author mugbya
 * 
 * @version 2014年5月4日
 *
 */
@Service
@Transactional
public class PaperServiceImpl extends DaoSupportImpl<Paper>implements PaperService{

	@Override
	public Paper findById(Integer id) {
		return (Paper) getSession().createQuery("from Paper where id=?").setParameter(0, id).uniqueResult();
	}

}
