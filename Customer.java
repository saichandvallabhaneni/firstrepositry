package com.training;

public class Customer {
	
	private long cid;
	private String name;
	public Customer(long cid, String name) {
		super();
		this.cid = cid;
		this.name = name;
	}
	public Customer() {
		super();
	}
	public long getCid() {
		return cid;
	}
	public void setCid(long cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", name=" + name + "]";
	}
	
	

}
