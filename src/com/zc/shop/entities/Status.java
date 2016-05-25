package com.zc.shop.entities;

public class Status {
	private Integer id;
	private String status;
	
	public Status() {
		super();
	}
	public Status(Integer id){
		this.id  = id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
