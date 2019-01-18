package com.nt.service;

import org.springframework.stereotype.Component;

@Component("airthService")
public class AirthmeticService {
	
	public int sum(int x,int y) {
		return x+y;
	}
	public int sub(int x,int y) {
		return x-y;
	}
	public int mul(int x,int y) {
		return x*y;
	}
	
	public float div(int x,int y) {
		if(y==0)
			throw new IllegalArgumentException("Invalid  inputs");
		return x/y;
	}


}
