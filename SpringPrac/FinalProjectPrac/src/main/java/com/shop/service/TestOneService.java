package com.shop.service;

import java.util.List;
import java.util.Map;

import com.shop.dto.BasicBbsDto;
import com.shop.dto.TestOneDto;



public interface TestOneService {
	public List<TestOneDto> list();
	public TestOneDto view(String id);
	public int write(Map<String, String> map);
	public int delete(String id);
	public int count();
	public int update(Map<String, String> umap);
	
}
