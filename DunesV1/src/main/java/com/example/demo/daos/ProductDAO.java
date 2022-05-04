package com.example.demo.daos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Order;
import com.example.demo.model.Product;
import com.example.demo.model.Project;
import com.example.demo.model.User;

@Repository
public class ProductDAO extends DAO{
	
	public void createProduct(Product product) {
		try {
			begin();
			int id = (int) save(product);
			System.out.println("Product created with ID: " + id);
			commit();
			
		}catch(Exception e) {
			rollback();
		}
	}
	
	public Product getProductById(int x) {
		try {
			begin();
			Query q = getSession().createQuery("from Product where id = :un");
			q.setParameter("un", x);
			Product p = (Product)q.uniqueResult();
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
	
	public void update(Product product) {
		try {
			begin();
			save(product);
			commit();
			
		} catch (HibernateException e) {
			rollback();
			System.out.println("Could not get project " +  e.getMessage());
		}
	}
	
	public List<Product> getProductsForSupplier(User supplier) {

		try {
			begin();
			Query q = getSession().createQuery("from Product where supplier = :un");
			q.setParameter("un", supplier);
			List list = q.list();
			if (list.size() == 0) {
				System.out.println("No results found");
				return null;
			}
			List<Product> r = (List<Product>) q.list();
			commit();
			
			return r;
		} catch (HibernateException e) {
			rollback();
			System.out.println("Could not orders find " + e.getMessage());
			return null;
		}

	}

}
