package com.zc.shop.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import com.zc.shop.dao.AccountDao;
import com.zc.shop.dao.CustomerDao;
import com.zc.shop.dao.ForderDao;
import com.zc.shop.dao.SorderDao;
import com.zc.shop.dao.impl.BaseDaoImpl;
import com.zc.shop.dao.impl.CategoryDaoImpl;
import com.zc.shop.dao.impl.ProductDaoImpl;
import com.zc.shop.service.BaseService;


public class BaseServiceImpl<T> implements BaseService<T>{
	
	protected BaseDaoImpl<T> baseDao;
	
	public void setBaseDao(BaseDaoImpl<T> baseDao) {
		this.baseDao = baseDao;
	}

	protected ProductDaoImpl productDao;
	protected CategoryDaoImpl categoryDao;
	protected CustomerDao customerDao;
	protected AccountDao accountDao;
	protected ForderDao forderDao;
	protected SorderDao sorderDao; 
	
	private Class<T> clazz;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public BaseServiceImpl(){
		super();
		//获取泛型的class。
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class)type.getActualTypeArguments()[0];
	}
	public void init(){
		//通过反射给baseDao设值。
		String className = clazz.getSimpleName();
		String classDao= className.substring(0, 1).toLowerCase()+className.substring(1)+"Dao";
		try {
			Field classField = this.getClass().getSuperclass().getDeclaredField(classDao);
			Field baseField = this.getClass().getSuperclass().getDeclaredField("baseDao");
			try {
				baseField.set(this, classField.get(this));
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void save(T t) {
		baseDao.save(t);
	}

	public void update(T t) {
		//update all fields
		baseDao.update(t);
	}

	public void delete(T t) {
		
		baseDao.delete(t);
//		String hql = "DELETE FROM " + clazz.getSimpleName() + " WHERE id = :id";
//		getSession().createQuery(hql).setInteger("id", id).executeUpdate();
	}
	public T get(Integer id){
		
		return (T)baseDao.get(clazz,id);
	}
	public List<T> query(){
		
		return baseDao.query(clazz);
	}
	public ProductDaoImpl getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDaoImpl productDao) {
		this.productDao = productDao;
	}

	public CategoryDaoImpl getCategoryDao() {
		return categoryDao;
	}

	public void setCategoryDao(CategoryDaoImpl categoryDao) {
		this.categoryDao = categoryDao;
	}

	public CustomerDao getCustomerDao() {
		return customerDao;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public AccountDao getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	public ForderDao getForderDao() {
		return forderDao;
	}

	public void setForderDao(ForderDao forderDao) {
		this.forderDao = forderDao;
	}

	public SorderDao getSorderDao() {
		return sorderDao;
	}

	public void setSorderDao(SorderDao sorderDao) {
		this.sorderDao = sorderDao;
	}
}
