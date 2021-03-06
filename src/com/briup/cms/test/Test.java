package com.briup.cms.test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Test {
	public static void main(String[] args) {
		//1.创建配置对象
		Configuration config = new Configuration();
		//2.读取配置文件
		config.configure("cms.cfg.xml");
		//3.创建连接工厂
		SessionFactory factory = config.buildSessionFactory();
		//4.创建会话
		Session session = factory.openSession();
		//5.开启事务
		Transaction tran = session.beginTransaction();
		
		tran.commit();
		System.out.println("----");
	}
}
