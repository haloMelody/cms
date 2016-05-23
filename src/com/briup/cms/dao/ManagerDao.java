package com.briup.cms.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import com.briup.cms.bean.Manager;
import com.briup.cms.common.HibernateSessionFactory;

public class ManagerDao {
	
	private String hql;
	
	public Session getSession(){
		return HibernateSessionFactory.getSession();
	}
	
	public Manager fingByName(String name){
		hql = "from Manager where name = ?";
		Query query = getSession().createQuery(hql);
		query.setString(0,name);
		Manager manager = (Manager) query.uniqueResult();
		return manager;
	}
	
	public void save(Manager manager){
		Session session = getSession();
		session.save(manager);
	}

}
