package com.tms.base;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author mugbya
 * 
 * @version 2014年4月22日
 *
 */
@Transactional
@SuppressWarnings("unchecked")
public abstract class DaoSupportImpl<T> implements DaoSupport<T>{
	
	@Resource
	private SessionFactory sessionFactory;

	private Class<T> clazz;

	public DaoSupportImpl() {
		// 使用反射技术得到T的真实类型
		// 获取当前new的对象的泛型的父类类型
		ParameterizedType pt = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		
		//获取第一个类型参数的真实类型
		this.clazz = (Class<T>)pt.getActualTypeArguments()[0];
		
		System.out.println("clazz---" + clazz);
	}

	/**
	 * 获取当前可用的Session
	 * 
	 * @return
	 */
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(T entity) {
		getSession().save(entity);
	}

	@Override
	public void delete(Integer id) {
		Object obj = getById(id);
		if (obj != null) {
			getSession().delete(obj);
		}
	}

	@Override
	public void update(T entity) {
		getSession().update(entity);
	}

	@Override
	public T getById(Integer id) {
		if (id==null) {
			return null;
		}else {
			return (T) getSession().get(clazz, id);
		}
	}

	@Override
	public List<T> findAll() {
		return getSession().createQuery("from " + //
				clazz.getSimpleName()).list();
	}

	@Override
	public List<T> getByIds(Integer[] ids) {
		if (ids == null || ids.length==0) {
			return Collections.EMPTY_LIST;
		} else {
			return getSession().createQuery("from " + //
					clazz.getSimpleName() + " where  id in (:ids)")
					.setParameterList("ids", ids).list();
		}
		
	}

}
