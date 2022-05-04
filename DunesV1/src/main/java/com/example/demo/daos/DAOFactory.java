package com.example.demo.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DAOFactory {
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private ProjectDAO projectDAO;
	
	@Autowired
	private TaskDAO taskDAO;
	
	@Autowired
	private OrdersDAO orderDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	public UserDAO getUserDAO(){
       	return userDAO;       
	}
	
	public ProjectDAO getProjectDAO(){
       	return projectDAO;       
	}
	
	public TaskDAO getTaskDAO(){
       	return taskDAO;       
	}
	
	public OrdersDAO getOrderDAO(){
       	return orderDAO;       
	}
	
	public ProductDAO getProductDAO(){
       	return productDAO;       
	}
	
}
