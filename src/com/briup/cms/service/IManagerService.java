package com.briup.cms.service;

import com.briup.cms.bean.Manager;
import com.briup.cms.common.exception.ServiceException;

public interface IManagerService {
	
	Manager login(String name,String password) throws ServiceException;
	
	void add(Manager manager);

}
