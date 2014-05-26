package com.tms.service.subject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tms.base.DaoSupportImpl;
import com.tms.entity.subject.Subject;

/**
 * @author mugbya
 * 
 * @version 2014年4月21日
 *
 */
@Service
@Transactional
public class SubjectServiceImpl extends DaoSupportImpl<Subject>implements SubjectService{


}
