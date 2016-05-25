package com.zc.shop.action;

import java.io.ByteArrayInputStream;

import com.zc.shop.entities.Customer;

public class CustomerAction extends BaseAction<Customer>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String prePage = null;
	public String login(){
		
		model = customerService.login(model);
		if(model == null){
			//login failed ,go back to login page
			return "login";
		}else{
			//login success and prePage in the session is not null
			prePage = (String) session.get("prePage");
			if(prePage != null){
				//put the user in to session
				session.put("user", model);
				//remove the key "prePage" in the session
				session.remove("prePage");
				return "prePage";
			}
			else{
				//put the user in to session
				session.put("user", model);
				return "home";
			}
		}
		
	}
	
	public String getPrePage() {
		return prePage;
	}
	public void setPrePage(String prePage) {
		this.prePage = prePage;
	}
	public String register(){
		if(customerService.register(model))
		inputStream = new ByteArrayInputStream("the name is already in use".getBytes());
		else 
			inputStream = new ByteArrayInputStream("true".getBytes());
		return "stream";
	}
	public String loginByAjax(){
		model = customerService.login(model);
		if(model==null)
			inputStream = new ByteArrayInputStream("false".getBytes());
		else
		inputStream = new ByteArrayInputStream(model.getName().getBytes());
		//put the user in to session
		session.put("user", model);
		return "stream";
	}
	public String check(){
		Object obj = session.get("user");
		if(obj == null){
			inputStream = new ByteArrayInputStream("false".getBytes());
		}else{
			inputStream = new ByteArrayInputStream("ok".getBytes());
		}
		return "stream";
	}
	public void exit(){
		session.remove("user");
	}
}
