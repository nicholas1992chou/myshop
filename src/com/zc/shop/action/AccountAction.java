package com.zc.shop.action;

import java.io.ByteArrayInputStream;
import com.zc.shop.entities.Account;

public class AccountAction extends BaseAction<Account>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String save(){
		accountService.save(model);
		return "stream";
	}
	
	public String update(){
		accountService.update(model);
		return SUCCESS;
	}
	public String delete(){
		accountService.delete(model);
		return SUCCESS;
	}
	
	public String query(){
		System.out.println("account_query");
		jsonList = accountService.query();
		return "jsonList";
	}
	public String queryByPages(){
		System.out.println("queryByPages---" + model);
		pageMap.put("total", accountService.getTotal(model.getAname()));
		pageMap.put("rows", accountService.query(model.getAname(), page, rows));
		
		return "jsonMap";
	}
	public String execute(){
		return SUCCESS;
	}
	
	public String deleteAll(){
		accountService.deleteAll(ids);
		inputStream = new ByteArrayInputStream("true".getBytes());
		return "stream";
	}
	public String login(){
		model = accountService.login(model);
		if(model != null){
			session.put("account", model);
			return "success";
		}else
		return "input";
	}
}
