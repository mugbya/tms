package com.tms.service.user;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tms.base.DaoSupportImpl;
import com.tms.entity.user.User;

/**
 * @author mugbya
 * 
 * @version 2014年4月22日
 *
 */
@Service
@Transactional
public class UserServiceImpl extends DaoSupportImpl<User> implements UserService{

	@Override
	public User findByLoginNameAndPassword(String loginName, String password) {
		// 加密后在对比
		String md5 = "";
		if (password != null && password.length() != 0) {
			 md5 = DigestUtils.md5Hex(password);
		}

		return (User) getSession().createQuery("from User u where "
				+ " u.loginName=? and u.password=?")
				.setParameter(0, loginName)
				.setParameter(1, md5).uniqueResult();
	}

}
