package com.nt.beans;

import javax.inject.Named;

import org.springframework.context.annotation.Primary;

@Named("blueDart")
//@Primary
public class BlueDart implements Courier {

	@Override
	public String deliver(int oid) {
		return  oid+" order id order is delivered(BlueDart) ";
	}

}
