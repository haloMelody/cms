package com.briup.cms.web.action.manager;

import java.util.Date;
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

/**
 * 后台文章管理Action
 * */
public class ArticleAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	//获取文章信息
	private Long id;
	private String title;
	private String author;
	private String content;
	//用来接收归属栏目的id（添加文章时使用）
	private Long category_id;
	//获取所以栏目 以及所有文章
	private List<Category> categoryList;
	private List<Article> articleList;
	//获取文章对象
	private Article article;
	//声明service层方法
	private IArticleService articleService =new ArticleServiceImpl();
	private ICategoryService categoryService =new CategoryServiceImpl();

	//跳转到添加文章页面
	@Action(value="toAddArticle",results={
			@Result(name="success",location="/WEB-INF/jsp/manager/addArticle.jsp")})
	public String toAddCategory(){
		categoryList = categoryService.list();
		return SUCCESS;
	}
	
	//处理添加文章操作
	@Action(value="addArticle")
	public void addArticle(){
		//根据传回的栏目id 查找栏目对象
		Category category = categoryService.findOne(category_id);
		
		Article article = new Article();
		//设置归属栏目
		article.setCategory(category);
		
		article.setAuthor(author);
		article.setClickTimes(0);
		article.setContent(content);
		article.setPublisurDate(new Date());
		article.setTitle(title);
		articleService.add(article);
	}
	
	//跳转打文章管理页面
	@Action(value="toArticleManager",results={
			@Result(name="success",location="/WEB-INF/jsp/manager/articleManager.jsp")})
	public String toArticleManager(){
		articleList = articleService.list();
		return SUCCESS;
	}
	
	//跳转到修改文章页面
	@Action(value="toUpdateArticle",results={
			@Result(name="success",location="/WEB-INF/jsp/manager/updateArticle.jsp")})
	public String toUpdateArticle(){
		categoryList = categoryService.list();
		article = articleService.findOne(id);
		return SUCCESS;
	}
	
	//跳转到阅读文章页面
	@Action(value="toReadArticle",results={
			@Result(name="success",location="/WEB-INF/jsp/manager/readArticle.jsp")})
	public String toReadArticle(){
		article = articleService.findOne(id);
		return SUCCESS;
	}
	
	//处理修改文章操作
	@Action(value="updateArticle")
	public void updateArticle(){
		//根据传回的栏目id 查找栏目对象
		Category category = categoryService.findOne(category_id);
		
		Article article = articleService.findOne(id);
		//设置归属栏目
		article.setCategory(category);
		
		article.setAuthor(author);
		article.setContent(content);
		article.setTitle(title);
		articleService.update(article);
	}
	
	//处理删除文章操作
	@Action(value="deleteArticle")
	public void deleteArticle(){
		articleService.delete(id);
	}
	
	public List<Category> getCategoryList() {
		return categoryList;
	}


	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}

	public List<Article> getArticleList() {
		return articleList;
	}

	public void setArticleList(List<Article> articleList) {
		this.articleList = articleList;
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

	

	
}
