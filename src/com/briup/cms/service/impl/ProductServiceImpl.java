package com.briup.cms.service.impl;

/**
 * 产品类的业务处理实现
 * @author haloMelody
 * @date 2016.5.12
 * */
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.briup.cms.bean.Product;
import com.briup.cms.common.HibernateSessionFactory;
import com.briup.cms.dao.ProductDao;
import com.briup.cms.service.IProductService;

public class ProductServiceImpl implements IProductService {
	
	private ProductDao productDao = new ProductDao();

	@Override
	public void add(Product product) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.beginTransaction();
		
		productDao.save(product);
		
		tran.commit();
		session.close();

	}

	@Override
	public List<Product> list() {
		List<Product> list = productDao.findAll();
		return list;
	}

	@Override
	public void delete(Long id) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.beginTransaction();
		
		productDao.deleteById(id);
		
		tran.commit();
		session.close();

	}

	@Override
	public void update(Product product) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.beginTransaction();
		
		productDao.update(product);
		
		tran.commit();
		session.close();

	}

	@Override
	public Product findOne(Long id) {
		Product product =  productDao.fingById(id);
		return product;
	}

}
