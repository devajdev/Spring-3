package com.nt.service;

import com.nt.dao.BankDAO;

public class BankServiceImpl implements BankService {
	private BankDAO dao;

	public BankServiceImpl(BankDAO dao) {

		this.dao = dao;
	}

	@Override
	public String withdrawMoney(int acno, int amount) {
		int count=0;
		//use DAO
		count=dao.withdraw(acno, amount);
		if(count==0)
			return "Problem in withdrawing money";
		else
			return amount+" is withdrawn from account number"+acno;
	}

	@Override
	public String depositeMoney(int acno, int amount) {
		int count=0;
		//use DAO
		count=dao.deposite(acno, amount);
		if(count==0)
			return "Problem in depositing money";
		else
			return amount+" is deposited from account number "+acno;
	}

}
