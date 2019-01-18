package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.dao.BankDAO;
import com.nt.errors.InvalidAccountException;

@Service("bankService")
public class BankServiceImpl implements BankService {
	@Autowired
	private BankDAO dao;

	

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

	//@Transactional(propagation=Propagation.REQUIRED,transactionManager="transactionManager",rollbackFor=InvalidAccountException.class)
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=InvalidAccountException.class)
	@Override
	public String transferMoney(int srcAcno, int destAcno, float amt)throws InvalidAccountException {
		boolean result1=false,result2=false;
		/*try {
			Thread.sleep(30000);
		}
		catch(InterruptedException ie) {
			ie.printStackTrace();
		}*/
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
