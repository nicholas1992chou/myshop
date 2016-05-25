package com.zc.shop.service;

import java.util.List;

import com.zc.shop.entities.Account;

public interface AccountService extends BaseService<Account>{
	public List<Account> query(String aname, int page, int rows);
	//查询与关键字匹配的总记录数
	public Long getTotal(String aname);
	
	public void deleteAll(String ids);
	
	public Account login(Account account);

}
