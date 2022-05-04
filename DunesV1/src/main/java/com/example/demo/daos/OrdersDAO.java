package com.example.demo.daos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Order;
import com.example.demo.model.Product;
import com.example.demo.model.Project;
import com.example.demo.model.Task;
import com.example.demo.model.User;

@Repository
public class OrdersDAO extends DAO{
	
	public void createOrder(Order order) {
		try {
			begin();
			int id = (int) save(order);
			System.out.println("Order created with ID: " + id);
			commit();
			
		}catch(Exception e) {
			rollback();
		}
	}
	
	public Order getOrderById(int x) {
		try {
			begin();
			Query q = getSession().createQuery("from Order where id = :un");
			q.setParameter("un", x);
			Order p = (Order)q.uniqueResult();
			if(p==null){
				System.out.println("No results found");
				return null;
			}
			commit();
			
			return p;
		} catch (HibernateException e) {
			rollback();
			System.out.println("Could not get project " +  e.getMessage());
			return null;
		}
	}
	
	public void update(Order order) {
		try {
			begin();
			save(order);
			commit();
			
		} catch (HibernateException e) {
			rollback();
			System.out.println("Could not get project " +  e.getMessage());
		}
	}
	
	public List<Order> getOrdersForProject(Project project) {

		try {
			begin();
			Query q = getSession().createQuery("from Order where project = :un");
			q.setParameter("un", project);
			List list = q.list();
			if (list.size() == 0) {
				System.out.println("No results found");
				return null;
			}
			List<Order> r = (List<Order>) q.list();
			commit();
			
			return r;
		} catch (HibernateException e) {
			rollback();
			System.out.println("Could not orders find " + e.getMessage());
			return null;
		}

	}
	
	public List<Order> getOrdersForSupplier(User supplier) {

		try {
			begin();
			Query q = getSession().createQuery("from Order where supplier = :un");
			q.setParameter("un", supplier);
			List list = q.list();
			if (list.size() == 0) {
				System.out.println("No results found");
				return null;
			}
			List<Order> r = (List<Order>) q.list();
			commit();
			
			return r;
		} catch (HibernateException e) {
			rollback();
			System.out.println("Could not orders find " + e.getMessage());
			return null;
		}

	}
	
	
	
}
