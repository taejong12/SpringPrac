package com.study.springboot.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Transaction2Dao {
	public void pay(String consumerId, int amount);
	
}
