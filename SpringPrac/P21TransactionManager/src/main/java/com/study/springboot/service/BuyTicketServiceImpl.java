package com.study.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.study.springboot.dao.Transaction1Dao;
import com.study.springboot.dao.Transaction2Dao;

@Service
public class BuyTicketServiceImpl implements BuyTicketService {

	@Autowired
	Transaction1Dao trans1;
	
	@Autowired
	Transaction2Dao trans2;
	
//	@Autowired
//	PlatformTransactionManager transactionManager;
//	
//	@Autowired
//	TransactionDefinition transDef;
	
	@Autowired
	TransactionTemplate transactionTemplate;
	
	@Override
	public int buy(String consumerId, int amount, String error) {
		
		
		// TransactionStatus status = transactionManager.getTransaction(transDef);
		

		try {
			transactionTemplate.execute(new TransactionCallbackWithoutResult() {
				
				@Override
				protected void doInTransactionWithoutResult(TransactionStatus status) {
					
					trans1.pay(consumerId, amount);
					
					// 의도적 에러 발생
					if(error.equals("1")) {int n=10/0;}
					
					trans2.pay(consumerId, amount);
				}
			});
			
			
			// 일련의 과정을 status에 저장하고 있다가 최종적으로 커밋
			// transactionManager.commit(status);
			
			return 1;
			
		} catch(Exception e) {
			
			// 생성되서 진행되고 있는 해당 상태를 초기화
			// transactionManager.rollback(status);
			
			// 내부에서 동작 중에 에러가 발생하면 롤백
			System.out.println("transactionTemplate rollback");
			return 0;
		
		}
	}
}
		


