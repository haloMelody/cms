package com.briup.cms.dao;

/**
 * 产品类的增删改查
 * @author haloMelody
 * @date 2016.5.12
 * */
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.briup.cms.bean.Product;
import com.briup.cms.common.HibernateSessionFactory;

public class ProductDao {
	
private String hql;
	
	public Session getSession(){
		return HibernateSessionFactory.getSession();
	}
	
	public void save(Product product){
		Session session = getSession();
		session.save(product);
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> findAll(){
		hql = "from Product";
		Query query = getSession().createQuery(hql);
		List<Product> list = query.list();
		return list;
	}

	public void deleteById(long id){
		Product product = (Product) getSession().load(Product.class, id);
		getSession().delete(product);
	}
	
	public Product fingById(long id){
		return (Product) getSession().load(Product.class, id);
	}
	
	public void update(Product product){
		getSession().update(product);
	}
	

}
