package com.zc.shop.dao;

import com.zc.shop.entities.Customer;

public interface CustomerDao extends BaseDao<Customer> {
	//user log in
	public Customer login(Customer customer);
	//user sign up
	public Object register(Customer customer);
}
