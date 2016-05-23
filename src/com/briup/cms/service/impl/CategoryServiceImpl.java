package com.briup.cms.service.impl;

/**
 * 栏目类的业务处理实现
 * @author haloMelody
 * @date 2016.5.12
 * */

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.briup.cms.bean.Category;
import com.briup.cms.common.HibernateSessionFactory;
import com.briup.cms.dao.CategoryDao;
import com.briup.cms.service.ICategoryService;

public class CategoryServiceImpl implements ICategoryService {

	private CategoryDao categoryDao = new CategoryDao();
	@Override
	public void add(Category category) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.beginTransaction();
		
		categoryDao.save(category);
		
		tran.commit();
		session.close();
	}
	@Override
	public List<Category> list() {
		List<Category> list = categoryDao.findAll();
		return list;
	}
	@Override
	public void delete(long id) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.beginTransaction();
		
		categoryDao.deleteById(id);
		
		tran.commit();
		session.close();
	}
	@Override
	public Category findOne(long id) {
		return categoryDao.fingById(id);
	}
	@Override
	public void update(Long id, String name, Integer code) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.beginTransaction();
		
		categoryDao.updateById(id, name, code);
		
		tran.commit();
		session.close();
		
	}
	

}
