package com.briup.cms.dao;

/**
 * 文章类的增删改查
 * @author haloMelody
 * @date 2016.5.12
 * */

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.briup.cms.bean.Article;
import com.briup.cms.common.HibernateSessionFactory;

public class ArticleDao {
	
	private String hql;
	
	public Session getSession(){
		return HibernateSessionFactory.getSession();
	}
	
	public void save(Article article){
		Session session = getSession();
		session.save(article);
	}
	
	@SuppressWarnings("unchecked")
	public List<Article> findAll(){
		hql = "from Article";
		Query query = getSession().createQuery(hql);
		List<Article> list = query.list();
		return list;
	}

	public void deleteById(long id){
		Article article = (Article) getSession().load(Article.class, id);
		getSession().delete(article);
	}
	
	public Article fingById(long id){
		return (Article) getSession().load(Article.class, id);
	}
	
	public void update(Article article){
		getSession().update(article);
	}
	
}
