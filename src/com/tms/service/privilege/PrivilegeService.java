package com.tms.service.privilege;

import java.util.Collection;
import java.util.List;

import com.tms.base.DaoSupport;
import com.tms.entity.privilege.Privilege;

/**
 * @author mugbya
 * 
 * @version 2014年4月23日
 *
 */
public interface PrivilegeService extends DaoSupport<Privilege>{

	/**
	 * 查询所有顶级的权限
	 * @return
	 */
	List<Privilege> findTopList();

	/**
	 * 查询所有权限对应的Url集合(不重复)
	 * @return
	 */
	Collection<String> getAllPrivilegeUrls();

}
