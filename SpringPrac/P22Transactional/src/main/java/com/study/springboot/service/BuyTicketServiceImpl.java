package com.study.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
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
	// 트랜젝션을 도는데 조건을 걸어주는 것
	// 프로파게이션 이벤트전파
	// 걸려있는 트렌젝션 하나라도 걸리면 리콰이얼(기본값)
	// 트렌젝션을 각각 처리한다(리콰이어뉴)
	// REQUIRES 에러가 발생하면 디비에 안들어간다 과정 중에 하나라도 걸리면 다 롤백
	// REQUIRES_NEW 
	
	// 중복관계 트렉젝션
	// 안쪽과 바깥쪽 전체가 걸리는건 REQUIRES
	// 특정 부분만 걸리는건 REQUIRES_NEW
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	
	
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
		


