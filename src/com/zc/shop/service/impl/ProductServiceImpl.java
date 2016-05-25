package com.zc.shop.service.impl;

import java.util.List;

import com.zc.shop.entities.Product;
import com.zc.shop.service.ProductService;


public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService{
	
	//分页查询
	public List<Product> queryByPages(String name, int page, int rows) {
		//查询product级联Category级联account，在使用account时出现懒加载异常,解决方案，在json里过滤掉account字段
		return productDao.queryByPages(name, page, rows);
	}
	//查询与关键字匹配的总记录数
	public Long getTotal(String name){
		return productDao.getTotal(name);
	}
	public void deleteAll(String ids){
		productDao.deleteAll(ids);
	}
	public List<Product> queryCommend(Integer id){
		return productDao.queryCommend(id);
	}
	
}
