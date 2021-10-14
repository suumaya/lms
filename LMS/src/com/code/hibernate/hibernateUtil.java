package com.code.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class hibernateUtil {
	
	private static SessionFactory sessionFactory = sessionFactory();
	public static SessionFactory sessionFactory(){
		try{
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}
		catch(ExceptionInInitializerError e){
			e.printStackTrace();
		}
		
		return sessionFactory;
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}

