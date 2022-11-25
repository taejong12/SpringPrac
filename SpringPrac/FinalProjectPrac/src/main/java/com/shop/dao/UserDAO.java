package com.shop.dao;

import com.shop.dto.JoinDTO;

public interface UserDAO {
	void join(JoinDTO  join);
	int overlapCheck(String value, String valueType);
}


