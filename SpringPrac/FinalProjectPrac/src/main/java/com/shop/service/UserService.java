package com.shop.service;

import com.shop.dto.JoinDTO;

public interface UserService {
	void join(JoinDTO join);
 
	int overlapCheck(String value, String valueType);
}
