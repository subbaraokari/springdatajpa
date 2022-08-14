package org.simplilearn.app.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.Hibernate;
import org.simplilearn.app.entities.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:hibernate.properties")
@ComponentScan(basePackages = "org.simplilearn.app")
@EnableTransactionManagement(proxyTargetClass = true)
public class HibConfig {
	@Autowired
	private Environment environment;
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getProperty("jdbc.driver"));
		dataSource.setUrl(environment.getProperty("jdbc.url"));
		dataSource.setUsername(environment.getProperty("jdbc.username"));
		dataSource.setPassword(environment.getProperty("jdbc.password"));
		return dataSource;
	}
	private Properties hibernateProperties()
	{
		Properties properties=new Properties();
		properties.put(org.hibernate.cfg.Environment.SHOW_SQL, environment.getProperty("hibernate.show_sql"));
		properties.put(org.hibernate.cfg.Environment.FORMAT_SQL, environment.getProperty("hibernate.format_sql"));
		properties.put(org.hibernate.cfg.Environment.HBM2DDL_AUTO, environment.getProperty("hibernate.hbm2ddl.auto"));
		properties.put(org.hibernate.cfg.Environment.DIALECT, environment.getProperty("hibernate.dialect"));
		return properties;
	}
	@Bean
	public LocalSessionFactoryBean localSessionFactoryBean()
	{
		LocalSessionFactoryBean localSessionFactoryBean=
				new LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(dataSource());
		localSessionFactoryBean.setHibernateProperties(hibernateProperties());
		localSessionFactoryBean.setAnnotatedClasses(Emp.class);
		return localSessionFactoryBean;
	}
	@Bean
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager transactionManager=
				new HibernateTransactionManager();
		transactionManager.setSessionFactory(localSessionFactoryBean().getObject());
		return transactionManager;
	}
}
