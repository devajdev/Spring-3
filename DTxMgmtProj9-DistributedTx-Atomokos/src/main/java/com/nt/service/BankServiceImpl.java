package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.dao.DepositeDAO;
import com.nt.dao.WithdrawDAO;

@Service("bankService")
public class BankServiceImpl implements BankService {
  @Autowired
	private WithdrawDAO wDAO;
  @Autowired
  private DepositeDAO dDAO;
  
    @Transactional(propagation=Propagation.REQUIRED)
	@Override
	public boolean transferMoney(int srcAcno, int destAcno, float amount) {
		int cnt1=0,cnt2=0;
		cnt1=wDAO.withdraw(srcAcno, amount);
		cnt2=dDAO.deposite(destAcno, amount);
		if(cnt1==0 || cnt2==0)
			throw new RuntimeException("Money not transfered");
		else
		return true;
	}

}
