package com.nt.bo;

import java.util.Date;

public abstract class BaseBO {
	private int id;
	private String name;
	private Date doj;
	
	public BaseBO() {
		System.out.println("BaseBO:0-param constructor");
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	
}
