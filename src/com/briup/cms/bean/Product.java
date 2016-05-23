package com.briup.cms.bean;

/**
 * 产品类
 * @author haloMelody
 * @date 2016.5.20
 * */
public class Product {

	//产品信息
	private Long id;
	private String name;
	private Double price;
	private String author;
	//多对一关系 
	private Category category;
	public Long getId() {
		return id;
	}
	
	public Product() {
	}

	public Product(String name, Double price, String author) {
		super();
		this.name = name;
		this.price = price;
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}


	
	
}
