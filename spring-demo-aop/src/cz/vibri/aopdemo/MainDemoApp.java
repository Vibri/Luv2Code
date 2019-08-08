package cz.vibri.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cz.vibri.aopdemo.dao.AccountDao;

public class MainDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		AccountDao dao = context.getBean("accountDao", AccountDao.class);

		// call the business method
		dao.addAccount();

		// close the context
		context.close();
	}

}
