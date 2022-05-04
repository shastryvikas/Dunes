package com.example.demo.daos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Project;
import com.example.demo.model.User;

@Repository
public class ProjectDAO extends DAO{
	
	public void createProject(Project project) {
		try {
			begin();
			int id = (int) save(project);
			System.out.println("Project created with ID: " + id);
			commit();
			
		}catch(Exception e) {
			rollback();
		}
	}
	
	public Project getProjectById(int x) {
		try {
			begin();
			Query q = getSession().createQuery("from Project where id = :un");
			q.setParameter("un", x);
			Project p = (Project)q.uniqueResult();
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
	
	public List<Project> getProjectsManagedBy(User manager){
		
		try {
			begin();
			Query q = getSession().createQuery("from Project where projectManager = :un");
			q.setParameter("un", manager);
			List list =q.list();
			if(list.size()==0){
				System.out.println("No results found");
				return null;
			}
			List<Project> r = (List<Project>)q.list();
			commit();
			
			return r;
		} catch (HibernateException e) {
			rollback();
			System.out.println("Could not get user by username and password " +  e.getMessage());
			return null;
		}
		
	}
	
}
