package com.zc.shop.service.impl;

import java.util.List;

import com.zc.shop.entities.Category;
import com.zc.shop.service.CategoryService;


public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService{
	
	
	//分页查询
	public List<Category> queryJoinAccount(String cname, int page, int rows) {
		return categoryDao.queryJoinAccount(cname, page, rows);
	}
	//查询与关键字匹配的总记录数
	public Long getTotal(String cname){
		return categoryDao.getTotal(cname);
	}
	public void deleteAll(String ids){
		//ids的形式为  "1, 2, 3"
		categoryDao.deleteAll(ids);
	}
	public List<Category> queryHot(){
		return categoryDao.queryHot();
	}

}
