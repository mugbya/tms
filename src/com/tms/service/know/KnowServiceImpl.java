package com.tms.service.know;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tms.base.DaoSupportImpl;
import com.tms.entity.know.Know;

/**
 * @author mugbya
 * 
 * @version 2014年4月28日
 *
 */
@Service
@Transactional
public class KnowServiceImpl extends DaoSupportImpl<Know> implements KnowService{

}
