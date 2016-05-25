package com.zc.shop.dao.impl;

import com.zc.shop.dao.CustomerDao;
import com.zc.shop.entities.Customer;

public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao{
	public Customer login(Customer customer) {
		String hql = "FROM Customer c where c.name = :name";
		Customer c = (Customer) getSession().createQuery(hql).setString("name", customer.getName()).uniqueResult();
		return c;
	}
	public Object register(Customer customer){
		String hql = "FROM Customer c where c.name = :name";
		Object cus = (Customer) getSession().createQuery(hql).setString("name", customer.getName()).uniqueResult();
		return cus;
	}
}
