package com.zc.shop.dao;

import java.util.List;

import com.zc.shop.entities.Account;

public interface AccountDao extends BaseDao<Account>{
	//分页查询
	public List<Account> query(String aname, int page, int rows); 
	//查询与关键字匹配的总记录数
	public Long getTotal(String aname);
	//批量删除
	public void deleteAll(String ids);
	//登陆验证
	public Account login(Account account);
}
