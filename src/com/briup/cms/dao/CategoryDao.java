package com.briup.cms.dao;

/**
 * 栏目类的增删改查
 * @author haloMelody
 * @date 2016.5.12
 * */

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.briup.cms.bean.Category;
import com.briup.cms.common.HibernateSessionFactory;

public class CategoryDao {
	
	private String hql;
	
	public Session getSession(){
		return HibernateSessionFactory.getSession();
	}
	
	public void save(Category category){
		Session session = getSession();
		session.save(category);
	}
	
	@SuppressWarnings("unchecked")
	public List<Category> findAll(){
		hql = "from Category";
		Query query = getSession().createQuery(hql);
		List<Category> list = query.list();
		return list;
	}
	

	public void deleteById(long id){
		Category category = (Category) getSession().load(Category.class, id);
		getSession().delete(category);
	}
	
	public Category fingById(long id){
		return (Category) getSession().load(Category.class, id);
	}
	
	public void updateById(Long id,String name,Integer code){
		Session session = getSession();
		Category category = (Category)session.load(Category.class, id);
		category.setName(name);
		category.setCode(code);
		session.update(category);
	}
	
}
