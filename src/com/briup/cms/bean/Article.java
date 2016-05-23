package com.briup.cms.bean;

/**
 * 文章类
 * @author haloMelody
 * @date 2016.5.12
 * */

import java.util.Date;

public class Article {

	private Long id;
	private String title;
	private String author;
	private String content;
	private Date publisurDate;
	private Integer clickTimes;
	
	private Category category;
	
	

	public Article() {
	}
	
	

	public Article(String title, String author, String content, Date publisurDate, Integer clickTimes) {
		super();
		this.title = title;
		this.author = author;
		this.content = content;
		this.publisurDate = publisurDate;
		this.clickTimes = clickTimes;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPublisurDate() {
		return publisurDate;
	}

	public void setPublisurDate(Date publisurDate) {
		this.publisurDate = publisurDate;
	}

	public Integer getClickTimes() {
		return clickTimes;
	}

	public void setClickTimes(Integer clickTimes) {
		this.clickTimes = clickTimes;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	/*@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", author=" + author + ", content=" + content
				+ ", publisurDate=" + publisurDate + ", clickTimes=" + clickTimes + ", category=" + category.getName() + "]";
	}*/

	
	
}
