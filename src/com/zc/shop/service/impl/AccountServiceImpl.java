package com.zc.shop.service.impl;

import java.util.List;

import com.zc.shop.entities.Account;
import com.zc.shop.service.AccountService;

public class AccountServiceImpl extends BaseServiceImpl<Account> implements AccountService{
	
	public List<Account> query(String aname, int page, int rows) {
		List<Account> list = accountDao.query(aname, page, rows);
		return list;
	}
	//查询与关键字匹配的总记录数
	public Long getTotal(String aname){
		
		Long total = (Long) accountDao.getTotal(aname);
		return total;
	}
	public void deleteAll(String ids){
		accountDao.deleteAll(ids);
	}
	public Account login(Account account){
	
		Account a = (Account) accountDao.login(account);
		if(a != null && a.getPassword().equals(account.getPassword())){
			return a;
		}else{
			return null;
		}
		
	}

}
