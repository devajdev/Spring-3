package com.nt.beans;

import java.util.Random;

public class BlueDart implements Courier {

	@Override
	public String deliver(int oid) {
		return  oid+" order id order is delivered(BlueDart) ";
	}

}
