package com.briup.cms.web.action.manager;

/**
 * 后台处理 栏目 action
 * @author haloMelody
 * @date 2016.5.12
 * */
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.briup.cms.bean.Category;
import com.briup.cms.service.ICategoryService;
import com.briup.cms.service.impl.CategoryServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class CategoryAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	//将栏目信息放入栈
	private Long id;
	private String name;
	private Integer code;
	//获取栏目对象
	private Category category;
	//获取所有栏目集合
	private List<Category> categoryList;
	//声明service层方法
	private ICategoryService categoryService =new CategoryServiceImpl();
	
	//跳转到修改栏目页面 返回一个栏目对象
	@Action(value="toUpdateCategory",results={
			@Result(name="success",location="/WEB-INF/jsp/manager/updateCategory.jsp")})
	public String toUpdateCategory(){
		category = categoryService.findOne(id);
		return "success";
	}
	
	//执行修改栏目操作  并实现异步跳转（jsp页面代码实现）
	@Action(value="updateCategory")
	public void updateCategory(){
		categoryService.update(id, name, code);
	}
	
	//跳转到添加栏目页面
	@Action(value="toAddCategory",results={
			@Result(name="success",location="/WEB-INF/jsp/manager/addCategory.jsp")})
	public String toAddCategory(){
		return SUCCESS;
	}
	
	//执行添加栏目操作  并实现异步跳转（jsp页面代码实现）
	@Action(value="addCategory")
	public void addCategory(){
		Category category = new Category(name,code);
		categoryService.add(category);
	}
	
	//执行删除栏目操作  并实现异步跳转（jsp页面代码实现）
	@Action(value="deleteCategory")
	public void deleteCategory(){
		categoryService.delete(id);
	}
	
	//跳转到栏目管理页面
	@Action(value="toCategoryManager",results={
			@Result(name="success",location="/WEB-INF/jsp/manager/categoryManager.jsp")})
	public String toCategoryManager(){
		categoryList = categoryService.list();
		return SUCCESS;
	}
	
	

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
}
