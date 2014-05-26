package com.tms.service.user;

import com.tms.base.DaoSupport;
import com.tms.entity.user.User;

/**
 * @author mugbya
 * 
 * @version 2014年4月22日
 *
 */
public interface UserService extends DaoSupport<User>{

	/**
	 * 根据登录名与密码进行查询用户
	 * @param loginName
	 * @param password
	 * @return
	 */
	User findByLoginNameAndPassword(String loginName, String password);
	
	
}
