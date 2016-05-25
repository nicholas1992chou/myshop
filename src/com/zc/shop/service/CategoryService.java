package com.zc.shop.service;

import java.util.List;

import com.zc.shop.entities.Category;

public interface CategoryService extends BaseService<Category> {
	//分页查询
	public List<Category> queryJoinAccount(String cname, int page, int rows);
	//查询与关键字匹配的总记录数
	public Long getTotal(String cname);
	public void deleteAll(String ids);
	public List<Category> queryHot();
}
