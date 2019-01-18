package com.nt.service;

import java.sql.SQLException;

import com.nt.dao.BankDAO;
import com.nt.errors.InvalidAccountException;

public class BankServiceImpl implements BankService {
	private BankDAO dao;

	public BankServiceImpl(BankDAO dao) {
		this.dao = dao;
	}

	@Override
	public boolean withdrawMoney(int acno, float amt) {
		int count=0;
		//use DAO
		count=dao.withdraw(acno, amt);
		if(count==0)
		   return false;
		else
			return true;
	}

	@Override
	public boolean depositeMoney(int acno, float amt) {
		int count=0;
		//use DAO
		count=dao.deposite(acno, amt);
		if(count==0)
		   return false;
		else
			return true;
	}

	@Override
	public String transferMoney(int srcAcno, int destAcno, float amt)throws InvalidAccountException {
		boolean result1=false,result2=false;
		try {
			Thread.sleep(30000);
		}
		catch(InterruptedException ie) {
			ie.printStackTrace();
		}
		//use withdrawMoney and depositeMoney methods
		result1=withdrawMoney(srcAcno, amt);
		result2=depositeMoney(destAcno, amt);
		if(result1 && result2) 
			return "MoneyTransfered from "+srcAcno+" to "+ destAcno;
		else
			throw new InvalidAccountException("Money not transfered");
			
	}

	/*@Override
	public String transferMoney(int srcAcno, int destAcno, float amt)  {
		boolean result1=false,result2=false;
		try {
			Thread.sleep(30000);
		}
		catch(InterruptedException ie) {
			ie.printStackTrace();
		}
		//use withdrawMoney and depositeMoney methods
		result1=withdrawMoney(srcAcno, amt);
		result2=depositeMoney(destAcno, amt);
		if(result1 && result2) 
			return "MoneyTransfered from "+srcAcno+" to "+ destAcno;
		else
			throw new IllegalArgumentException("Money not transfered");
			
	}*/
}
