package com.example.demo.utilities;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HibernateUtilConfig {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	//@Bean
	public SessionFactory getSessionFactory() {
	    if (entityManagerFactory.unwrap(SessionFactory.class) == null) {
	        throw new NullPointerException("factory is not a hibernate factory");
	    }
	    return entityManagerFactory.unwrap(SessionFactory.class);
		
//		return (new Configuration().configure("hibernate.cfg.xml").buildSessionFactory());
		
	}
}