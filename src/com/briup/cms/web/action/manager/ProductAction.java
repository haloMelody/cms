package com.briup.cms.web.action.manager;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.briup.cms.bean.Category;
import com.briup.cms.bean.Product;
import com.briup.cms.service.ICategoryService;
import com.briup.cms.service.IProductService;
import com.briup.cms.service.impl.CategoryServiceImpl;
import com.briup.cms.service.impl.ProductServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 后台产品管理Action
 * */
public class ProductAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	//获取产品信息
	private Long id;
	private String name;
	private Double price;
	private String author;
	//获取归属李栏目id
	private Long category_id;
	//获取产品对象
	private Product product;
	//获取所有栏目集合
	private List<Category> categoryList;
	private List<Product> productList;
	//声明service层方法
	private ICategoryService categoryService = new CategoryServiceImpl();
	private IProductService productService = new ProductServiceImpl();
	
		//跳转到添加产品页面
		@Action(value="toAddProduct",results={
				@Result(name="success",location="/WEB-INF/jsp/manager/addProduct.jsp")})
		public String toAddProduct(){
			categoryList = categoryService.list();
			return SUCCESS;
		}
		
		//处理添加文章操作
		@Action(value="addProduct")
		public void addProduct(){
			//根据传回的栏目id 查找栏目对象
			Category category = categoryService.findOne(category_id);
			
			Product product = new Product(name, price,author);
			//设置归属栏目
			product.setCategory(category);
			
			productService.add(product);
		}
		
		//跳转到产品管理页面
		@Action(value="toProductManager",results={
				@Result(name="success",location="/WEB-INF/jsp/manager/productManager.jsp")})
		public String toProductManager(){
			productList = productService.list();
			return SUCCESS;
		}
		
		
		//跳转到修改产品页面
		@Action(value="toUpdateProduct",results={
				@Result(name="success",location="/WEB-INF/jsp/manager/updateProduct.jsp")})
		public String toUpdateProduct(){
			categoryList = categoryService.list();
			product = productService.findOne(id);
			return SUCCESS;
		}
		
		
		//处理修改产品信息操作
		@Action(value="updateProduct")
		public void updateProduct(){
			//根据传回的栏目id 查找栏目对象
			System.out.println(id);
			Category category = categoryService.findOne(category_id);
			
			Product product = productService.findOne(id);
			System.out.println("---"+product);
			//设置归属栏目
			product.setCategory(category);
			
			product.setName(name);
			product.setPrice(price);
			product.setAuthor(author);
			productService.update(product);
			System.out.println(product);
		}
		
		//处理删除产品操作
		@Action(value="deleteProduct")
		public void deleteProduct(){
			productService.delete(id);
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

		public Long getCategory_id() {
			return category_id;
		}

		public void setCategory_id(Long category_id) {
			this.category_id = category_id;
		}

		public List<Product> getProductList() {
			return productList;
		}

		public void setProductList(List<Product> productList) {
			this.productList = productList;
		}

		public Product getProduct() {
			return product;
		}

		public void setProduct(Product product) {
			this.product = product;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		
}
