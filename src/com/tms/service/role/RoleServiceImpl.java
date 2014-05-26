package com.tms.service.role;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tms.base.DaoSupportImpl;

import com.tms.entity.role.Role;

/**
 * @author mugbya
 * 
 * @version 2014年4月20日
 *
 */
//implements RoleService
@Service
@Transactional
public class RoleServiceImpl extends DaoSupportImpl<Role>implements RoleService{

//	@Resource
//	private RoleDao roleDao;
//	
//	@Override
//	public List<Role> findAll() {
//		return roleDao.findAll();
//	}
//
//	@Override
//	public void delete(Integer id) {
//		roleDao.delete(id);		
//	}
//
//	@Override
//	public void save(Role role) {
//		roleDao.save(role);
//	}
//
//	@Override
//	public Role getById(Integer id) {
//		return roleDao.getById(id);
//	}
//
//	@Override
//	public void update(Role role) {
//		roleDao.update(role);
//	}
//
//	@Override
//	public List<Role> getByIds(Integer[] ids) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
