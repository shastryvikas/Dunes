package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.daos.DAOFactory;
import com.example.demo.model.Project;
import com.example.demo.model.User;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo.daos", "com.example.demo.controllers", "com.example.demo.utilities"})
@EntityScan({ "com.example.demo.model" })
public class DunesV1Application implements CommandLineRunner{
	
	@Autowired
	private DAOFactory daoFactory;

	public static void main(String[] args) {
		SpringApplication.run(DunesV1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
//		User user = getUser();
//		daoFactory.getUserDAO().createUser(user);
//		
//		Project project = new Project();
//		project.setProjectName("Project1");
//		project.setProjectBudget(10);
//		project.setProjectManager(user);
//		
//		daoFactory.getProjectDAO().createProject(project);
		
//		User user = daoFactory.getUserDAO().get("vikas6", "pass");
//		List<Project> x = daoFactory.getProjectDAO().getProjectsManagedBy(user);
//		
//		String a = "";
		//userDAO.createUser(user);
		
	}
	
	private User getUser() {
		User user = new User();
		user.setName("Vikas6");
		user.setPassword("pass");
		user.setUsername("vikas6");
		user.setRole("Engineer");
		return user;
	}

}
