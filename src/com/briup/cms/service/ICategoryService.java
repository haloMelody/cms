package com.briup.cms.service;

/**
 * 栏目类的业务处理接口
 * @author haloMelody
 * @date 2016.5.12
 * */

import java.util.List;

import com.briup.cms.bean.Category;

public interface ICategoryService {
	
	void add(Category category);
	List<Category> list();
	void delete(long id);
	Category findOne(long id);
	void update(Long id,String name,Integer code);

}
