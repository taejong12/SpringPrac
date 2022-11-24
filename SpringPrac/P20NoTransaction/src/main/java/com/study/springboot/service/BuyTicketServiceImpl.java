package com.study.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.dao.Transaction1Dao;
import com.study.springboot.dao.Transaction2Dao;

@Service
public class BuyTicketServiceImpl implements BuyTicketService {

	@Autowired
	Transaction1Dao trans1;
	
	@Autowired
	Transaction2Dao trans2;
	
	@Override
	public int buy(String consumerId, int amount, String error) {
		

		try {
			System.out.println(error);
			trans1.pay(consumerId, amount);
			
			if(error.equals("1")) {int n=10/0;}
			
			trans2.pay(consumerId, amount);
			System.out.println(error);
			return 1;
			
		} catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
		
		
		
	}

}
