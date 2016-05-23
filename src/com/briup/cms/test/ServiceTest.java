package com.briup.cms.test;


import java.util.List;

import com.briup.cms.bean.Article;
import com.briup.cms.bean.Category;
import com.briup.cms.bean.Manager;
import com.briup.cms.bean.Product;
import com.briup.cms.common.exception.ServiceException;
import com.briup.cms.service.IArticleService;
import com.briup.cms.service.ICategoryService;
import com.briup.cms.service.IManagerService;
import com.briup.cms.service.IProductService;
import com.briup.cms.service.impl.ArticleServiceImpl;
import com.briup.cms.service.impl.CategoryServiceImpl;
import com.briup.cms.service.impl.ManagerServiceImpl;
import com.briup.cms.service.impl.ProductServiceImpl;

public class ServiceTest {
	public static void main(String[] args) {
		
		//ICategoryService categoryService = new CategoryServiceImpl();
		IProductService productService = new ProductServiceImpl();
		//IArticleService articleService = new ArticleServiceImpl();
		//IManagerService managerService = new ManagerServiceImpl();
//		Category category = new Category();
//		category.setName("11新闻");
//		category.setCode(1004);
//		categoryService.add(category);
//		System.out.println("保存成功");
		
		/*Article article = new Article();
		article.setAuthor("爱因斯坦");
		article.setTitle("人类进化学说");
		article.setContent("从猴子变成人");
		article.setClickTimes(7);
		articleService.add(article);*/
		
		productService.update(productService.findOne(3L));
		
		
//		Product product = new Product("诺基亚", 699.0,"公司");
//		productService.add(product);
//		Manager manager = new Manager("haloMelody","123");
//		managerService.add(manager);
		
//		try {
//			managerService.login("haloMelody","123");
//		} catch (ServiceException e) {
//			e.printStackTrace();
//			System.out.println(e.getMessage());
//		}
		
		//articleService.settle(1L, 1L);
		
		
		//List<Category> list = categoryService.find();
		
		//categoryService.delete(4L);
		
		//System.out.println(categoryService.findOne(1L));
		
	}

}
