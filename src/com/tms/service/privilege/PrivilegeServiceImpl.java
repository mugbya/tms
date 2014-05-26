package com.tms.service.privilege;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tms.base.DaoSupportImpl;
import com.tms.entity.privilege.Privilege;

/**
 * @author mugbya
 * 
 * @version 2014年4月23日
 *
 */
@Service
@Transactional 
public class PrivilegeServiceImpl extends DaoSupportImpl<Privilege>implements PrivilegeService{

	@SuppressWarnings("unchecked")
	@Override
	public List<Privilege> findTopList() {
		return getSession().createQuery("FROM Privilege p WHERE p.parent IS NULL").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<String> getAllPrivilegeUrls() {
		return getSession().createQuery("SELECT DISTINCT p.url FROM Privilege p where p.url IS NOT NULL").list();
	}

}
