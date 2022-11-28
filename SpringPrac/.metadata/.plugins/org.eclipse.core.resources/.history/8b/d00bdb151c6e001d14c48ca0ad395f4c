package com.shop.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dao.TestOneDao;
import com.shop.dto.TestOneDto;

@Service
public class TestOneServiceImpl implements TestOneService{

	@Autowired
	TestOneDao dao;
	
	
	@Override
	public List<TestOneDto> list() {
		return dao.listDao();
	}

	@Override
	public TestOneDto view(String id) {
		
		return dao.viewDao(id);
	}

	@Override
	public int write(Map<String, String> map) {
		
		return dao.writeDao(map);
	}

	@Override
	public int delete(String id) {
	
		return dao.deleteDao(id);
	}

	@Override
	public int count() {

		return dao.postCount();
	}
	

}
