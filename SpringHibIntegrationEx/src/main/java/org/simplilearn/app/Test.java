package org.simplilearn.app;

import java.time.LocalDate;

import org.simplilearn.app.config.HibConfig;
import org.simplilearn.app.dao.EmpDao;
import org.simplilearn.app.dao.EmpDaoImpl;
import org.simplilearn.app.entities.Emp;
import org.simplilearn.app.exceptions.EmployeeNotFoundException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	
	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(HibConfig.class);
		EmpDao dao=context.getBean("empDaoImpl", EmpDaoImpl.class);
		/*
		 * Emp e=new Emp(); e.setName("raman"); e.setAddress("Chennai");
		 * e.setDateOfJoin(LocalDate.of(2010, 05, 01)); dao.insert(e);
		 */
		Emp e=dao.get(1).orElseThrow(()->new EmployeeNotFoundException("Employee Not Found"));
		System.out.println(e.getEno()+"\t"+e.getName()+"\t"+e.getAddress());
	}

}
