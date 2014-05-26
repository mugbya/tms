package com.tms.service.test;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tms.base.DaoSupportImpl;
import com.tms.entity.test.Choices;

/**
 * @author mugbya
 * 
 * @version 2014年5月1日
 *
 */
@Service
@Transactional
public class ChoicesServiceImpl extends DaoSupportImpl<Choices>implements ChoicesService{

	@SuppressWarnings("unchecked")
	@Override
	public List<Choices> findByTestId(Integer id) {
		List<Choices> choices = getSession().createQuery("FROM Choices c WHERE c.test.id=?")
				.setParameter(0, id).list();     //c WHERE c.testID=? FROM Chapter c WHERE c.subjectId=?
//		List<Choices> choices = getSession().createQuery("FROM Choices ")
//				.list();
		return choices;
	}

}
