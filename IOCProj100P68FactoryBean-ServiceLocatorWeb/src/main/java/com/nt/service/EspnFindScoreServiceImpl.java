package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.extComp.ICCScoreComp;

@Service("espnService")
public class EspnFindScoreServiceImpl implements EspnFindScoreService {
    @Autowired
	private ICCScoreComp extComp;

	

	public String findScore(int mid) throws IllegalArgumentException {
		String score=null;
		//use the injected extenal comp ref
		score=extComp.getScore(mid);
		return score;
	}

}
