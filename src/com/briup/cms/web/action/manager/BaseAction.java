package com.briup.cms.web.action.manager;

import java.util.List;

/**
 * 后台基础处理 跳转后台首页 action
 * @author haloMelody
 * @date 2016.5.12
 * */
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.briup.cms.bean.Category;
import com.briup.cms.bean.Manager;
import com.briup.cms.common.exception.ServiceException;
import com.briup.cms.service.ICategoryService;
import com.briup.cms.service.IManagerService;
import com.briup.cms.service.impl.CategoryServiceImpl;
import com.briup.cms.service.impl.ManagerServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
		//接收异常信息
		private String msg;
		//接收登陆信息
		private String name;
		private String password;
		//获取一个对象
		private Manager manager;
		//接收所有栏目
		private List<Category> categoryList;
		//声明service层方法处理逻辑业务
		private IManagerService managerService = new ManagerServiceImpl();
		private ICategoryService CategoryService = new CategoryServiceImpl();

		//跳转到后台首页
		@Action(value="toIndex",results={
				@Result(name="success",location="/WEB-INF/jsp/manager/home.jsp")})
		public String toIndex(){
			return SUCCESS;
		}
	
		//跳转到登陆页面
		@Action(value="toLogin",results={
				@Result(name="success",location="/WEB-INF/jsp/manager/login.jsp")})
		public String toLogin(){
			categoryList = CategoryService.list();
			return SUCCESS;
		}
	
		//跳转到登陆页面
			@Action(value="login",results={
					@Result(name="success",location="/WEB-INF/jsp/manager/home.jsp"),
					@Result(name="error",location="/WEB-INF/jsp/manager/login.jsp")})
			public String login(){
				categoryList = CategoryService.list();
				String url = "success";
				try {
					manager = managerService.login(name, password);
				} catch (ServiceException e) {
					url="error";
					e.printStackTrace();
					setMsg(e.getMessage());
				}
				return url;
			}

			public String getMsg() {
				return msg;
			}

			public void setMsg(String msg) {
				this.msg = msg;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			public String getPassword() {
				return password;
			}

			public void setPassword(String password) {
				this.password = password;
			}

			public Manager getManager() {
				return manager;
			}

			public void setManager(Manager manager) {
				this.manager = manager;
			}

			public List<Category> getCategoryList() {
				return categoryList;
			}

			public void setCategoryList(List<Category> categoryList) {
				this.categoryList = categoryList;
			}
			
}
