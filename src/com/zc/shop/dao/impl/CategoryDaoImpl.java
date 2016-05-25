package com.zc.shop.dao.impl;

import java.util.List;

import com.zc.shop.dao.CategoryDao;
import com.zc.shop.entities.Category;

@SuppressWarnings("unchecked")
public class CategoryDaoImpl extends BaseDaoImpl<Category> implements CategoryDao{
	//分页查询
	public List<Category> queryJoinAccount(String cname, int page, int rows) {
		String hql = "FROM Category c LEFT OUTER JOIN FETCH c.account WHERE c.cname LIKE :cname";
		
		List<Category> list = getSession().createQuery(hql).setString("cname", "%" + cname + "%").setFirstResult((page - 1) * rows).setMaxResults(rows)
				.list();
		return list;
	}
	//查询与关键字匹配的总记录数
	public Long getTotal(String cname){
		String hql = "select count(c) FROM Category c WHERE c.cname LIKE :cname";
		Long total = (Long) getSession().createQuery(hql).setString("cname", "%" + cname + "%").uniqueResult();
		return total;
	}
	public void deleteAll(String ids){
		//ids的形式为  "1, 2, 3"
		String hql = "delete from Category c WHERE c.id IN (" + ids + ")";
		getSession().createQuery(hql).executeUpdate();
	}
	public List<Category> queryHot(){
		String hql = "FROM Category c WHERE c.hot = :hot";
		return getSession().createQuery(hql)
			.setBoolean("hot", true)
			.setFirstResult(0)
			.setMaxResults(4)
			.list();
	}
}
