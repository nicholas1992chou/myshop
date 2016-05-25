package com.zc.shop.dao.impl;

import java.util.List;

import com.zc.shop.dao.AccountDao;
import com.zc.shop.entities.Account;

public class AccountDaoImpl extends BaseDaoImpl<Account> implements AccountDao{
	public List<Account> query(String aname, int page, int rows) {
		String hql = "FROM Account a WHERE a.aname LIKE :aname";
		
		@SuppressWarnings("unchecked")
		List<Account> list = getSession().createQuery(hql).setString("aname", "%" + aname + "%").setFirstResult((page - 1) * rows).setMaxResults(rows)
				.list();
		return list;
	}
	//查询与关键字匹配的总记录数
	public Long getTotal(String aname){
		String hql = "select count(a) FROM Account a WHERE a.aname LIKE :aname";
		Long total = (Long) getSession().createQuery(hql).setString("aname", "%" + aname + "%").uniqueResult();
		return total;
	}
	public void deleteAll(String ids){
		//ids的形式为  "1, 2, 3"
		String hql = "delete from Account a WHERE a.id IN (" + ids + ")";
		getSession().createQuery(hql).executeUpdate();
	}
	public Account login(Account account){
		String hql = "FROM Account a where a.aname = :aname";
		Account a = (Account) getSession().createQuery(hql).setString("aname", account.getAname()).uniqueResult();
		return a;
		
	}

}
