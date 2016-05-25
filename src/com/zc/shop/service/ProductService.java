package com.zc.shop.service;

import java.util.List;

import com.zc.shop.entities.Product;

public interface ProductService extends BaseService<Product> {
	//分页查询
	public List<Product> queryByPages(String name, int page, int rows) ;
	//查询与关键字匹配的总记录数
	public Long getTotal(String name);
	
	public void deleteAll(String ids);
	
	public List<Product> queryCommend(Integer id);
}
