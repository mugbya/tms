package com.tms.util;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.tms.entity.privilege.Privilege;
import com.tms.entity.user.User;

/**
 * @author mugbya
 * 
 * @version 2014年4月23日
 *
 */
@Component
public class Installer {

	@Resource
	private SessionFactory sessionFactory;
	
	@Transactional
	public void install(){
		Session session = sessionFactory.getCurrentSession();
		
		// 保存超级管理员
		User user = new User();
		user.setLoginName("admin");
		user.setName("超级管理员");
		user.setPassword(DigestUtils.md5Hex("1234"));
		session.save(user);
		
		// 保存权限数据
		Privilege menu, menu1, menu2, menu3, menu4;

		// --------------------
		menu = new Privilege("系统管理", null, null);
		menu1 = new Privilege("角色管理", "/role_list", menu);
		menu2 = new Privilege("用户管理", "/user_list", menu);
		session.save(menu);
		session.save(menu1);
		session.save(menu2);


		session.save(new Privilege("角色列表", "/role_list", menu1));
		session.save(new Privilege("角色删除", "/role_delete", menu1));
		session.save(new Privilege("角色添加", "/role_add", menu1));
		session.save(new Privilege("角色修改", "/role_edit", menu1));

		session.save(new Privilege("用户列表", "/user_list", menu2));
		session.save(new Privilege("用户删除", "/user_delete", menu2));
		session.save(new Privilege("用户添加", "/user_add", menu2));
		session.save(new Privilege("用户修改", "/user_edit", menu2));
		session.save(new Privilege("初始化密码", "/user_initPassword", menu2));

		//-----------------
		menu = new Privilege("科目管理", null, null);
		menu1 = new Privilege("课程管理", "/subject_list", menu);
		menu2 = new Privilege("章节管理", "/chapter_list", menu);
		menu3 = new Privilege("小节管理", "/chapter_list", menu);
		menu4 = new Privilege("知识点管理", "know_list", menu);
		
		session.save(new Privilege("课程列表", "/subject_list", menu1));
		session.save(new Privilege("课程删除", "/subject_delete", menu1));
		session.save(new Privilege("课程添加", "/subject_add", menu1));
		session.save(new Privilege("课程修改", "/subject_edit", menu1));		

		session.save(new Privilege("章节删除", "/chapter_delete", menu2));
		session.save(new Privilege("章节添加", "/chapter_add", menu2));
		session.save(new Privilege("章节修改", "/chapter_edit", menu2));			

		session.save(new Privilege("小节删除", "/section_delete", menu3));
		session.save(new Privilege("小节添加", "/section_add", menu3));
		session.save(new Privilege("小节修改", "/section_edit", menu3));	
		
		session.save(new Privilege("知识点列表", "/know_list", menu4));
		session.save(new Privilege("知识点删除", "/know_delete", menu4));
		session.save(new Privilege("知识点添加", "/know_add", menu4));
		session.save(new Privilege("知识点修改", "/know_edit", menu4));			
		
		session.save(menu);
		session.save(menu1);
		session.save(menu2);		
		session.save(menu3);
		session.save(menu4);
		    
		//----------------------
//		menu = new Privilege("知识点管理",null,null);
//		menu1 = new Privilege("知识点管理", "/know_list", menu);	
//		session.save(menu);
//		session.save(menu1);		
		
		//------------------
		menu = new Privilege("试题库管理", null, null);
		menu1 = new Privilege("试题管理", "/test_list", menu);
		menu2 = new Privilege("试卷管理", "/paper_list", menu);

		session.save(menu);
		session.save(menu1);
		session.save(menu2);	
	}
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		Installer installer = (Installer) ac.getBean("installer");
		installer.install();  
	}
}
