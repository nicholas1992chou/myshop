package com.zc.shop.service;

import com.zc.shop.entities.Customer;

public interface CustomerService extends BaseService<Customer> {
	public Customer login(Customer customer);
	public boolean register(Customer customer);
}
