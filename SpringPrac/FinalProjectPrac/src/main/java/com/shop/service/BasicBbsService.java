package com.shop.service;

import java.util.List;
import java.util.Map;

import com.shop.dto.BasicBbsDto;



public interface BasicBbsService {
	public List<BasicBbsDto> list();
	public BasicBbsDto view(String id);
	public int write(Map<String, String> map);
	public int delete(String id);
	public int count();
	
}
