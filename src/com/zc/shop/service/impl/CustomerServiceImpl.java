package com.zc.shop.service.impl;

import com.zc.shop.entities.Customer;
import com.zc.shop.service.CustomerService;

public class CustomerServiceImpl extends BaseServiceImpl<Customer> implements CustomerService{
	
	public Customer login(Customer customer) {
		Customer c = customerDao.login(customer);
		if(c != null && c.getPassword().equals(customer.getPassword()))
			return c;
		return null;
	}
	public boolean register(Customer customer){
		
		Object cus = (Customer) customerDao.register(customer);
		if(cus==null)
			return false;
		return true;
	}
}
