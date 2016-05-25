package com.zc.shop.entities;

public class Category {
	private Integer id;
	private String cname;
	private boolean hot;
	private Account account;
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Category(){
		super();
	}
	public Category(String cname, boolean hot){
		this.cname = cname;
		this.hot = hot;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public boolean isHot() {
		return hot;
	}

	public void setHot(boolean hot) {
		this.hot = hot;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", cname=" + cname + ", hot=" + hot + ", account=" + account + "]";
	}

	
	
}
