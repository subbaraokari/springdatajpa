package org.simplilearn.jpaex1;

import org.simplilearn.jpaex1.entities.Emp;
import org.simplilearn.jpaex1.repositories.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringJpaEx1Application {
	@Autowired
	private EmpRepository empRepository;
	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(SpringJpaEx1Application.class, args);
		/*
		 * EmpRepository repository=context.getBean("employeeRepository",
		 * EmpRepository.class); repository.getAll().forEach(emp->{
		 * System.out.println(emp.getEno()+"\t"+emp.getName()+"\t"+emp.getAddress());
		 * });
		 */
	}
	/*@Bean
	public CommandLineRunner commandLineRunner() {
		CommandLineRunner runner=new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				empRepository.getAll().forEach(emp->{
					System.out.println(emp.getEno()+"\t"+emp.getName()+"\t"+emp.getAddress());
				});
			}
		};
		return runner;
	}*/
	
	@Bean
	public CommandLineRunner commandLineRunner()
	{
		CommandLineRunner runner=(String ...s)->{
			empRepository.getAll().forEach(emp->{
				System.out.println(emp.getEno()+"\t"+emp.getName()+"\t"+emp.getAddress());
			});
		};
		return runner;
	}
	
}
