package test;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author mugbya
 * 
 * @version 2014年4月19日
 *
 */
public class SpringTest {
	private ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	@Test
	public void  testBean() {
		TestAction testAction = (TestAction) ac.getBean("testAction");
		System.out.println(testAction);
	}

	@Test
	public void  testsessionFactory() {
		SessionFactory sf = (SessionFactory)ac.getBean("sessionFactory");
		System.out.println(sf);
	}
	
	@Test
	public void testTransaction() {
		
	}
}
