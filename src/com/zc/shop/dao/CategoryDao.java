package com.zc.shop.dao;

import java.util.List;

import com.zc.shop.entities.Category;

public interface CategoryDao extends BaseDao<Category> {
	//分页查询
	public List<Category> queryJoinAccount(String cname, int page, int rows) ;
	//查询与关键字匹配的总记录数
	public Long getTotal(String cname);
	//批量删除
	public void deleteAll(String ids);
	//获取热点
	public List<Category> queryHot();
}
