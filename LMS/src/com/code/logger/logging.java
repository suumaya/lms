package com.code.logger;

import java.util.Properties;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class logging extends Logger {
	
	static {
		
		ClassLoader cl =  logging.class.getClassLoader();
		Properties pr = new Properties();
		try {
			pr.clear();
			pr.load(cl.getResourceAsStream("com/code/resources/log4j.properties"));
			PropertyConfigurator.configure(pr);
		}
		
		catch(Exception e){
			System.out.print("There was an error for loading the logger");
		}
		
	}

	public logging(String output) {
		super(output);
	}
	
	public static void infoTracing(Class<?> cl, String msg) {
		Logger logger = Logger.getLogger(cl);
		logger.info(msg);
	}
	
	public static void logTracing(Class<?> cl, String msg) {
		Logger logger = Logger.getLogger(cl);
		logger.info(msg);
	}
	
	public static void debugTracing(Class<?> cl, String msg) {
		Logger logger = Logger.getLogger(cl);
		logger.info(msg);
	}
	
	public static void errorTracing(Class<?> cl, String msg) {
		Logger logger = Logger.getLogger(cl);
		logger.info(msg);
	}
	
	public static void fetalTracing(Class<?> cl, String msg) {
		Logger logger = Logger.getLogger(cl);
		logger.info(msg);
	}
	
	
	public static void errorExceptionTracing(Class<?> cl, Throwable ex, String msg) {
		Logger logger = Logger.getLogger(cl);
		logger.error(msg, ex);
	}
	public static void fetalExceptionTracing(Class<?> cl, Throwable ex, String msg) {
		Logger logger = Logger.getLogger(cl);
		logger.fatal(msg, ex);
	}

	public static void debugExceptionTracing(Class<?> cl, Throwable ex, String msg) {
		Logger logger = Logger.getLogger(cl);
		logger.debug(msg, ex);
	}
	
}
