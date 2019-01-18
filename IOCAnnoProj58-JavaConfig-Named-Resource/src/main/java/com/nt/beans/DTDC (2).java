package com.nt.beans;

import javax.inject.Named;

import org.springframework.context.annotation.Primary;

@Named("dtdc")
public class DTDC implements Courier {

	@Override
	public String deliver(int oid) {
		return oid+" order id order is delivered(DTDC) ";
	}

}
