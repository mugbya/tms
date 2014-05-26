package test;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author mugbya
 * 
 * @version 2014年4月19日
 *
 */
@Controller
@Scope("prototype")
public class TestAction  extends ActionSupport{

	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		System.out.println("----> TestAction.execute()");
		return "success";
	}
}
