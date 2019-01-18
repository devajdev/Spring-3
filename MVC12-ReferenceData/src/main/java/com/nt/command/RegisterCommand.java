package com.nt.command;

import java.util.Arrays;

public class RegisterCommand {
	private String name;
	private String[] courses;
	private String[] hobies;
	private String country;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getCourses() {
		return courses;
	}
	public void setCourses(String[] courses) {
		this.courses = courses;
	}
	public String[] getHobies() {
		return hobies;
	}
	public void setHobies(String[] hobies) {
		this.hobies = hobies;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "RegisterCommand [name=" + name + ", courses=" + Arrays.toString(courses) + ", hobies="
				+ Arrays.toString(hobies) + ", country=" + country + "]";
	}
	
	

}
