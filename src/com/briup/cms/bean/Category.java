package com.briup.cms.bean;

/**
 * 栏目类
 * @author haloMelody
 * @date 2016.5.12
 * */

import java.util.HashSet;
import java.util.Set;

public class Category {
	private Long id;
	private String name;
	private Integer code;
	
	//设置一对多关系
	private Set<Article> articles = new HashSet<Article>();
	
	private Set<Product> products = new HashSet<Product>();

	
	
	public Category() {
	}
	

	public Category(String name, Integer code) {
		super();
		this.name = name;
		this.code = code;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Set<Article> getArticles() {
		return articles;
	}

	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}
	

	public Set<Product> getProducts() {
		return products;
	}


	public void setProducts(Set<Product> products) {
		this.products = products;
	}



}
