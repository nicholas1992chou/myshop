package com.zc.shop.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.zc.shop.dao.BaseDao;

@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> implements BaseDao<T>{
	
	protected SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public void save(T t) {
		getSession().save(t);
	}

	public void update(T t) {
		//update all fields
		getSession().update(t);
	}

	public void delete(T t) {
		
		getSession().delete(t);
//		String hql = "DELETE FROM " + clazz.getSimpleName() + " WHERE id = :id";
//		getSession().createQuery(hql).setInteger("id", id).executeUpdate();
	}
	public T get(Class<T> clazz, Integer id){
		
		return (T)getSession().get(clazz, id);
	}
	public List<T> query(Class<T> clazz){
		
		return getSession().createQuery("FROM " + clazz.getSimpleName()).list();
	}
	
}
