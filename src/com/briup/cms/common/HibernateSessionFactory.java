package com.briup.cms.common;

/**
 * 公共类  获取session
 * @author haloMelody
 * @date 2016.5.12
 * */
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
	private static Configuration config;
	private static SessionFactory sessionFactory;
	private static String fileName;
	
	//创建线程  解决多个session相互独立问题
	private static ThreadLocal<Session> threadLocal;
	
	static{
		fileName = "cms.cfg.xml";
		config = new Configuration();
		config.configure(fileName);
		sessionFactory = config.buildSessionFactory();
		threadLocal = new ThreadLocal<Session>();
	}
	
	public static Session getSession(){
		Session session = threadLocal.get();
		if(session == null || !session.isOpen()){
			session = sessionFactory.openSession();
			threadLocal.set(session);
		}  
		return session;
	}

}
