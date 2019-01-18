package com.nt.beans;

import org.springframework.beans.factory.annotation.Required;

public class CourseMaterial {
	private String name;
	private int pagesCount;
	
	@Required
	public void setName(String name) {
		this.name = name;
	}
	public void setPagesCount(int pagesCount) {
		this.pagesCount = pagesCount;
	}
	@Override
	public String toString() {
		return "CourseMaterial [name=" + name + ", pagesCount=" + pagesCount + "]";
	}
	
	

}
