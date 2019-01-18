package com.nt.beans;

import javax.inject.Named;

@Named("blueDart")
public class BlueDart implements Courier {

	@Override
	public String deliver(int oid) {
		return  oid+" order id order is delivered(BlueDart) ";
	}

}
