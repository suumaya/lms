package code.com.dataAccessObj;

import org.hibernate.SessionFactory;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;  
import org.hibernate.cfg.Configuration;  
import org.hibernate.service.ServiceRegistry;  


public class HibernateUtil {
	
	 private static SessionFactory sessionFactory;  
	 
	 @SuppressWarnings("deprecation")
	    private static SessionFactory buildSessionFactory(){  
	        try{  
	            // Create the SessionFactory from hibernate.cfg.xml  
	        	Configuration configuration = new Configuration();  
	            configuration.configure("hibernate.cfg.xml");  
	            System.out.println("Hibernate Annotation Configuration loaded");  
	            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();  
	            System.out.println("Hibernate Annotation serviceRegistry created");  
	            sessionFactory = configuration.buildSessionFactory(serviceRegistry);  
	            return sessionFactory; 
	        }  
	        catch (Throwable ex){  
	            // Make sure you log the exception, as it might be swallowed  
	            System.err.println("Initial SessionFactory creation failed." + ex);  
	            throw new ExceptionInInitializerError(ex);  
	        }  
	    }  
	    public static SessionFactory getSessionFactory() {  
	    	if(sessionFactory == null) {
	    		sessionFactory = buildSessionFactory();
	    	}
	        return sessionFactory;  
	    }  
	    public static void shutdown(){  
	        // Close caches and connection pools  
	        sessionFactory.close();  
	    }  
	}  

