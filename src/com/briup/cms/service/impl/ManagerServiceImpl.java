package com.briup.cms.service.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.briup.cms.bean.Manager;
import com.briup.cms.common.HibernateSessionFactory;
import com.briup.cms.common.exception.ServiceException;
import com.briup.cms.dao.ManagerDao;
import com.briup.cms.service.IManagerService;

public class ManagerServiceImpl implements IManagerService{
	
	private ManagerDao managerDao = new ManagerDao();

	@Override
	public Manager login(String name,String password) throws ServiceException{
		Manager manager = null;
		Manager dbmanager = managerDao.fingByName(name);
		if(dbmanager != null){
			if(dbmanager.getPassword().equals(password)){
				manager=dbmanager;
			}
			else{
				throw new ServiceException("密码输入错误！");
			}
		}
		else{
			throw new ServiceException("管理员用户名不存在");
		}
		return manager;
	}

	@Override
	public void add(Manager manager) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.beginTransaction();
		
		managerDao.save(manager);
		
		tran.commit();
		session.close();
		
	}

}
