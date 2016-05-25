package com.zc.shop.dao.impl;

import java.util.List;

import com.zc.shop.dao.ProductDao;
import com.zc.shop.entities.Product;

@SuppressWarnings("unchecked")
public class ProductDaoImpl extends BaseDaoImpl<Product> implements ProductDao{
	//分页查询
	public List<Product> queryByPages(String name, int page, int rows) {
		//查询product级联Category级联account，在使用account时出现懒加载异常,解决方案，在json里过滤掉account字段
		String hql = "FROM Product p LEFT OUTER JOIN FETCH p.category WHERE p.name LIKE :name";
		
		List<Product> list = getSession().createQuery(hql).setString("name", "%" + name + "%").setFirstResult((page - 1) * rows).setMaxResults(rows)
				.list();
		return list;
	}
	//查询与关键字匹配的总记录数
	public Long getTotal(String name){
		String hql = "select count(p) FROM Product p WHERE p.name LIKE :name";
		Long total = (Long) getSession().createQuery(hql).setString("name", "%" + name + "%").uniqueResult();
		return total;
	}
	public void deleteAll(String ids){
		//ids的形式为  "1, 2, 3"
		String hql = "delete from Product p WHERE p.id IN (" + ids + ")";
		getSession().createQuery(hql).executeUpdate();
	}
	public List<Product> queryCommend(Integer id){
		String hql = "FROM Product p join fetch p.category where p.commend = true AND p.category.id = :id ORDER BY p.date DESC";
		return getSession().createQuery(hql)
					.setInteger("id", id)
					.setFirstResult(0)
					.setMaxResults(4)
					.list();
	}
}
