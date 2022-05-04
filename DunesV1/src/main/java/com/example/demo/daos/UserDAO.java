package com.example.demo.daos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Project;
import com.example.demo.model.User;

@Repository
public class UserDAO extends DAO{
	
	public void createUser(User user) {
		try {
			begin();
			int id = (int) save(user);
			System.out.println("User created with ID: " + id);
			commit();
			
		}catch(Exception e) {
			rollback();
		}
	}
	
	public User get(String username, String password) {
		try {
			begin();
			Query q = getSession().createQuery("from User where username = :un and password = :pw");
			q.setString("un", username);
			q.setString("pw", password);			
			User user = (User) q.uniqueResult();
			commit();
			
			return user;
		} catch (HibernateException e) {
			rollback();
			System.out.println("Could not get user by username and password " +  e.getMessage());
			return null;
		}
	}
	
	public User get(int id) {
		try {
			begin();
			Query q = getSession().createQuery("from User where id = :un ");
			q.setParameter("un", id);
			User user = (User) q.uniqueResult();
			commit();
			
			return user;
		} catch (HibernateException e) {
			rollback();
			System.out.println("Could not get user by username and password " +  e.getMessage());
			return null;
		}
	}
	
	public List<User> getAllEngineers(){
		try {
			begin();
			Query q = getSession().createQuery("From User where role =:username");
			q.setString("username", "Engineer");
			List<User> r = (List<User>)q.list();
			commit();
			
			return r;
		} catch (HibernateException e) {
			rollback(); 
			System.out.println("Could not find user  " +  e.getMessage());
			return null;
		}
	}
	
	public List<User> getAllSuppliers(){
		try {
			begin();
			Query q = getSession().createQuery("From User where role =:username");
			q.setString("username", "Supplier");
			List<User> r = (List<User>)q.list();
			commit();
			
			return r;
		} catch (HibernateException e) {
			rollback(); 
			System.out.println("Could not find user  " +  e.getMessage());
			return null;
		}
	}
	
	public List<User> getAllManagers(){
		try {
			begin();
			Query q = getSession().createQuery("From User where role =:username");
			q.setString("username", "Manager");
			List<User> r = (List<User>)q.list();
			commit();
			
			return r;
		} catch (HibernateException e) {
			rollback(); 
			System.out.println("Could not find user  " +  e.getMessage());
			return null;
		}
	}
	
	public User add(String username, String password, String name, String role)  {
		try {
			begin();
			User u = new User();
			u.setUsername(username);
			u.setPassword(password);
			u.setName(name);
			u.setRole(role);
			
			//check if username is already used
			Query q = getSession().createQuery("From User where username =:username");
			q.setString("username", username);
			List list =q.list();
			if(list.size()>0){
				System.out.println("User already existed");
				return null;
			}
			getSession().save(u);
			commit();
			
			return u;
		} catch (HibernateException e) {
			rollback(); 
			System.out.println("Could not add user  " +  e.getMessage());
			return null;
		}
	}
	
}
