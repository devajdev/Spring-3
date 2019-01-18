package com.nt.service;

import com.nt.errors.InvalidAccountException;

public interface BankService {
	public  boolean withdrawMoney(int acno,float amt);
	public  boolean depositeMoney(int acno,float amt);
	public String transferMoney(int srcAcno,int destAcno,float amt)throws InvalidAccountException;
	//public String transferMoney(int srcAcno,int destAcno,float amt);

}
