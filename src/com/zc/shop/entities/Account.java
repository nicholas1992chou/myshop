package com.zc.shop.entities;

public class Account {
	private Integer id;
	private String aname;
	private String password;

	public Account() {
		super();
	}

	public Account(String aname, String password) {
		this.aname = aname;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", aname=" + aname + ", password=" + password + "]";
	}
	
}
