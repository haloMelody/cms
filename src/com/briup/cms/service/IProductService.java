package com.briup.cms.service;

/**
 * 文章类的业务处理接口
 * @author haloMelody
 * @date 2016.5.12
 * */

import java.util.List;

import com.briup.cms.bean.Product;

public interface IProductService {
	void add(Product product);
	List<Product> list();
	void delete(Long id);
	void update(Product product);
	Product findOne(Long id);
}
