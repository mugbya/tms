package com.tms.service.test;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tms.base.DaoSupportImpl;
import com.tms.entity.test.Test;

/**
 * @author mugbya
 * 
 * @version 2014年4月30日
 *
 */
@Service
@Transactional
public class TestServiceImpl extends DaoSupportImpl<Test> implements TestService{

	@SuppressWarnings("unchecked")
	@Override
	public List<Test> findByKnow(Integer knowId) {
//		return getSession().createQuery("FROM Test t left join where t.knows=?")
//				.setParameter(0, knowId).list();
//		return (List<Test>)getSession().createSQLQuery("select * from test where id in "
//				+ "(select testId from test_know where knowId = ?)").setParameter(0, knowId).list();
		List<Test> list = getSession().createSQLQuery("select * from test where id in "
				+ "(select testId from test_know where knowId = ?)").addEntity(Test.class).setParameter(0, knowId).list();
		return list;
		
//		return (List<Test>)getSession().createSQLQuery("select * from test where id in "
//				+ "(select testId from test_know where knowId = ?)").setParameter(0, knowId).list();
		
	}

	@Override
	public Test findByQuestion(String question) {
		return (Test) getSession().createQuery("from Test t where question=?")
				.setParameter(0, question).list().get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> findAllTestName() {
		List<String>list = getSession().createQuery("select distinct testName from Test").list();
		return list;
	}

	@Override
	public void setStatus() {
		getSession().createQuery("update Test set status = 'F'").executeUpdate();
		//getSession().clear();
		//System.out.println("更新表中所有的抽取状态----------");
//		getSession().merge(arg0)
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object []> selectSumType(String subject) {
	//	return (List<Test_Num>)getSession().createQuery("select type, count(*) from Test group by type").list();
	//	return getSession().createSQLQuery("select type, count(*) from test group by type").list();
		return getSession().createQuery("select type, count(*) from Test  where testName = ? group by type").setParameter(0, subject).list();
	}

//	@Override
//	public void setStatus(Integer id) {
//		System.out.println("要被改变状态的ID是-----"+id);
//		getSession().createQuery("update Test t set status = 'T' where id = ?").setParameter(0, id).executeUpdate();
//		//getSession().createSQLQuery("update test set t_repeat = 'T' where id = ?").setParameter(0, id).executeUpdate();
//	}

	@Override
	public Test findById(Integer id) {
		return (Test)getSession().createQuery("FROM Test where id=?").setParameter(0, id).uniqueResult();
	}

	@Override
	public void setStatus(Test test) {
		getSession().update(test);
		System.out.println("更新对象的抽取状态-----------");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Test> findAll(String subject) {
		return getSession().createQuery("FROM Test where testName=?").setParameter(0, subject).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Test> findByChapter(Integer id) {
		return getSession().createQuery("FROM Test t where t.chapter.id=?").setParameter(0, id).list();
	}
	
}
