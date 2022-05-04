package com.example.demo.daos;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class DAO {
	
	private static final ThreadLocal<Session> sessionThread = new ThreadLocal<Session>();
	
	@Autowired
	private  SessionFactory sessionFactory;
	
	public Session getSession(){
        Session session = (Session) DAO.sessionThread.get();
        
        if (session == null){
            session = sessionFactory.openSession();
            DAO.sessionThread.set(session);
        }
        return session;
    }
	
	protected void begin() {
		if(!getSession().getTransaction().isActive())
        getSession().beginTransaction();
    }

    protected void commit() {
        getSession().getTransaction().commit();
    }
    
    protected Object save(Object o) {
    	return getSession().save(o);
    }
    
    protected void rollback() {
        try {
            getSession().getTransaction().rollback();
        } catch (HibernateException e) {
            //log.log(Level.WARNING, "Cannot rollback", e);
        }
        try {
            getSession().close();
        } catch (HibernateException e) {
            //log.log(Level.WARNING, "Cannot close", e);
        }
        DAO.sessionThread.set(null);
    }
    
    public void close() {
        getSession().close();
        DAO.sessionThread.set(null);
    }

}
