package com.zc.shop.action;

import java.io.ByteArrayInputStream;
import java.util.Date;
import java.util.List;

import com.zc.shop.entities.Account;
import com.zc.shop.entities.Category;

public class CategoryAction extends BaseAction<Category>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public String save(){
		model.setAccount((Account) session.get("account"));
		categoryService.save(model);
		inputStream = new ByteArrayInputStream("true".getBytes());
		return "stream";
	}
	
	public String update(){
		model.setAccount((Account) session.get("account"));
		categoryService.update(model);
		inputStream = new ByteArrayInputStream("true".getBytes());
		return "stream";
	}
	public void delete(){
		categoryService.delete(model);
	}
	
	public String query(){
		jsonList = categoryService.query();
		
		return "jsonList";
	}
	public String queryJoinAccount() {
		System.out.println(model.getCname());
		List<Category> categoryList = categoryService.queryJoinAccount(model.getCname(), page, rows);
		
		total = categoryService.getTotal(model.getCname());
		// 将分页数据封装到map里，以json形式传输。
		//使用datagrid分页时，json数据键规定为total与rows。否则出现异常
		pageMap.put("total", total);
		pageMap.put("rows", categoryList);

		return "jsonMap";
	}
	public String deleteAll(){
		System.out.println(new Date() + "...deleteAll...category......."+ ids);
		categoryService.deleteAll(ids);
		inputStream = new ByteArrayInputStream("true".getBytes());
		return "stream";
	}
}
