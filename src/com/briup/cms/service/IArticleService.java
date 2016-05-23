package com.briup.cms.service;

/**
 * 文章类的业务处理接口
 * @author haloMelody
 * @date 2016.5.12
 * */

import java.util.List;

import com.briup.cms.bean.Article;

public interface IArticleService {
	void add(Article article);
	List<Article> list();
	void delete(Long id);
	void update(Article article);
	Article findOne(Long id);
}
