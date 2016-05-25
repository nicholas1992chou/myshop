package com.zc.shop.dao;

import java.util.List;

public interface BaseDao<T> {

	public void save(T t);

	public void update(T t); 

	public void delete(T t); 
	
	public T get(Class<T> clazz, Integer id);
	
	public List<T> query(Class<T> clazz);
	
}
