package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JpaMain {

	public static void main(String[] args) {
	
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		EmpDao dao = (EmpDao)ctx.getBean("empDaoJpaImpl");
		//System.out.println(dao.save(new Emp(1400, "Smith", "Ranchi", 89000)));
		
		Emp e = dao.findOne(1400);
		System.out.println(e);
		
		System.out.println(dao.delete(1300));
		
		for(Emp e1:dao.getAll())
		{
			System.out.println(e1.toString());
		}
		
		

	}

}
