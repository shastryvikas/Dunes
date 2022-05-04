package com.example.demo.daos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Product;
import com.example.demo.model.Project;
import com.example.demo.model.Task;
import com.example.demo.model.User;

@Repository
public class TaskDAO extends DAO {

	public void createTask(Task task) {
		try {
			begin();
			int id = (int) save(task);
			System.out.println("Task created with ID: " + id);
			commit();
			
		} catch (Exception e) {
			rollback();
		}
	}
	
	public void update(Task task) {
		try {
			begin();
			save(task);
			commit();
			
		} catch (HibernateException e) {
			rollback();
			System.out.println("Could not get task " +  e.getMessage());
		}
	}
	
	public Task getTaskById(int x) {
		try {
			begin();
			Query q = getSession().createQuery("from Task where id = :un");
			q.setParameter("un", x);
			Task p = (Task)q.uniqueResult();
			if(p==null){
				System.out.println("No results found");
				return null;
			}
			commit();
			
			return p;
		} catch (HibernateException e) {
			rollback();
			System.out.println("Could not get Task " +  e.getMessage());
			return null;
		}
	}

	public List<Task> getTasksForProject(Project project) {

		try {
			begin();
			Query q = getSession().createQuery("from Task where project = :un");
			q.setParameter("un", project);
			List list = q.list();
			if (list.size() == 0) {
				System.out.println("No results found");
				return null;
			}
			List<Task> r = (List<Task>) q.list();
			commit();
			
			return r;
		} catch (HibernateException e) {
			rollback();
			System.out.println("Could not tasks " + e.getMessage());
			return null;
		}

	}
	
	public List<Task> getTasksForEngineer(User engineer) {

		try {
			begin();
			Query q = getSession().createQuery("from Task where engineer = :un");
			q.setParameter("un", engineer);
			List list = q.list();
			if (list.size() == 0) {
				System.out.println("No results found");
				return null;
			}
			List<Task> r = (List<Task>) q.list();
			commit();
			
			return r;
		} catch (HibernateException e) {
			rollback();
			System.out.println("Could not tasks " + e.getMessage());
			return null;
		}

	}

}
