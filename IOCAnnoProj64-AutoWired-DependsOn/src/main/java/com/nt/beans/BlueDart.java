package com.nt.beans;

import org.springframework.stereotype.Component;

@Component("blueDart")
public class BlueDart implements Courier {
	
	public BlueDart() {
		System.out.println("BlueDart::0-param constructor");
	}

	@Override
	public String deliver(int oid) {
		return  oid+" order id order is delivered(BlueDart) ";
	}

}
