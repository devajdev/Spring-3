package com.nt.service;

import java.util.Arrays;

public class ShoppingStore {
   public  float  shopping(String[] items) {
	   System.out.println(Arrays.toString(items));
	   float billAmt=0.0f;
	   billAmt=items.length*1000;
	   return billAmt;
   }
}
