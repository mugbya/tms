package com.tms.base;

import java.util.List;

/**
 * @author mugbya
 * 
 * @version 2014年4月22日
 *
 */
public interface DaoSupport<T> {
	/**
	 * 保存
	 * @param entity
	 */
	void save(T entity);

	/**
	 * 删除
	 * @param id
	 */
	void delete(Integer id);

	/**
	 * 更新
	 * @param entity
	 */
	void update(T entity);

	/**
	 * 按id查询
	 * @param id
	 * @return
	 */
	T getById(Integer id);

	/**
	 *  查询所有
	 * @return
	 */
	List<T> findAll();

	List<T> getByIds(Integer[] ids);
}
