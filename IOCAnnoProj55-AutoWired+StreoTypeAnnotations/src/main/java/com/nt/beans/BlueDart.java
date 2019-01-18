package com.nt.beans;

import org.springframework.stereotype.Component;

@Component("blueDart")
public class BlueDart implements Courier {

	@Override
	public String deliver(int oid) {
		return  oid+" order id order is delivered(BlueDart) ";
	}

}
