package com.briup.cms.service.impl;

/**
 * 文章类的业务处理实现
 * @author haloMelody
 * @date 2016.5.12
 * */

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.briup.cms.bean.Article;
import com.briup.cms.common.HibernateSessionFactory;
import com.briup.cms.dao.ArticleDao;
import com.briup.cms.service.IArticleService;

public class ArticleServiceImpl implements IArticleService{
	
	private ArticleDao articleDao = new ArticleDao();

	@Override
	public void add(Article article) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.beginTransaction();
		
		articleDao.save(article);
		
		tran.commit();
		session.close();
	}

	@Override
	public List<Article> list() {
		List<Article> list = articleDao.findAll();
		return list;
	}

	@Override
	public void delete(Long id) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.beginTransaction();
		
		articleDao.deleteById(id);
		
		tran.commit();
		session.close();
		
	}

	@Override
	public void update(Article article) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.beginTransaction();
		
		articleDao.update(article);
		
		tran.commit();
		session.close();
	}

	@Override
	public Article findOne(Long id) {
		Article article =  articleDao.fingById(id);
		return article;
	}

}
