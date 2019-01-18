package com.nt.beans;

import java.util.Random;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("dtdc")
@Primary
public class DTDC implements Courier {

	@Override
	public String deliver(int oid) {
		return oid+" order id order is delivered(DTDC) ";
	}

}
