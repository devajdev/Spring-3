package com.nt.beans;

import java.util.Random;

import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("dtdc")
@Primary
@DependsOn("fpkt")
public class DTDC implements Courier {
	
	public DTDC() {
		System.out.println("DTDC:0-param constructor");
	}

	@Override
	public String deliver(int oid) {
		return oid+" order id order is delivered(DTDC) ";
	}

}
