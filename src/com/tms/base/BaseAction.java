package com.tms.base;

import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.tms.service.chapter.ChapterService;
import com.tms.service.know.KnowService;
import com.tms.service.paper.PaperService;
import com.tms.service.privilege.PrivilegeService;
import com.tms.service.role.RoleService;
import com.tms.service.section.SectionService;
import com.tms.service.subject.SubjectService;
import com.tms.service.test.ChoicesService;
import com.tms.service.test.TestService;
import com.tms.service.user.UserService;

/**
 * @author mugbya
 * 
 * @version 2014年4月22日
 * 
 */
public abstract class BaseAction<T> extends ActionSupport implements
		ModelDriven<T> {
	private static final long serialVersionUID = 1L;

	protected T model;

	public BaseAction() {
		try {
			ParameterizedType pt = (ParameterizedType) this.getClass()
					.getGenericSuperclass();
			@SuppressWarnings("unchecked")
			Class<T> clazz = (Class<T>) pt.getActualTypeArguments()[0];

			model = clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			throw new RuntimeException("model获取实例失败", e);
		}
	}

	@Override
	public T getModel() {
		return model;    
	}

	// ========================Service实例的声明============
	@Resource
	protected RoleService roleService;
	@Resource
	protected UserService userService;
	@Resource
	protected PrivilegeService privilegeService;
	@Resource
	protected SubjectService subjectService;
	@Resource
	protected ChapterService chapterService;
	@Resource
	protected SectionService sectionService;
	@Resource
	protected KnowService knowService;
	@Resource
	protected TestService testService;
	@Resource
	protected ChoicesService choicesService;
	@Resource
	protected PaperService paperService;
	
}
