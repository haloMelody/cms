package com.briup.cms.web.action;

/**
 * 前台页面处理action
 * @author haloMelody
 * @date 2016.5.12
 * */
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.briup.cms.bean.Article;
import com.briup.cms.bean.Category;
import com.briup.cms.service.IArticleService;
import com.briup.cms.service.ICategoryService;
import com.briup.cms.service.impl.ArticleServiceImpl;
import com.briup.cms.service.impl.CategoryServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	//接收文章id
	private Long id;
	
	//接收所有栏目
	private List<Category> categoryList;
	//获取一个对象
	private Article article;
	private Category category;
	//声明service层方法处理逻辑业务
	private ICategoryService CategoryService = new CategoryServiceImpl();
	private IArticleService articleService = new ArticleServiceImpl();
	

	//跳转至前台首页
	@Action(value="toIndex",results={
			@Result(name="success",location="/WEB-INF/jsp/index.jsp")})
	public String toIndex(){
		categoryList = CategoryService.list();
		return SUCCESS;
	}
	
	//跳转至栏目页面 并返回栏目对象及所有栏目集合
	@Action(value="toList",results={
			@Result(name="success",location="/WEB-INF/jsp/list.jsp")})
	public String toList(){
		categoryList = CategoryService.list();
		category = CategoryService.findOne(id);
		return SUCCESS;
	}
	
	//跳转至文章内容页面 并返回文章对象及所有栏目集合
	@Action(value="toContent",results={
			@Result(name="success",location="/WEB-INF/jsp/content.jsp")})
	public String toContent(){
		categoryList = CategoryService.list();
		article = articleService.findOne(id);
		return SUCCESS;
	}

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	
}
