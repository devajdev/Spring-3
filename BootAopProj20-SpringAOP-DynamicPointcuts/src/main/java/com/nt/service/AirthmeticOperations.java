package com.nt.service;

import org.springframework.stereotype.Service;

@Service("airthService")
public class AirthmeticOperations {
	
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
		return (float)x/y;
	}
	
	


}
