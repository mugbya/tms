package com.tms.util;



import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.tms.entity.user.User;

/**
 * @author mugbya
 * 
 * @version 2014年5月21日
 *
 */
public class CheckPrivilegeInterceptor implements Interceptor{

	private static final long serialVersionUID = 1L;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
//		System.out.println("拦截前------------");
//		String result  = arg0.invoke();
//		System.out.println("拦截后-----------");
		
		//获取信息
		User user = (User) ActionContext.getContext().getSession().get("user");
		String namespace = arg0.getProxy().getNamespace();
		String actionName = arg0.getProxy().getActionName();
		String privUrl = namespace + actionName;
		if (user == null) {		
			 if (privUrl.startsWith("/user_login")) { // "/user_login" /user_loginUI
				//如果是登录，就放行
				 return arg0.invoke();
			}else {
				return "loginUI";	
			}
		}else {
			//已登录时判断权限
			if (user.hasPrivilegeByUrl(privUrl)) {
				//有权限就放行
				return arg0.invoke();
			}else{
				return "noPrivilegeError";
			}
		}
		
//		return null;
	}

}
