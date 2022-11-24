package com.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import com.shop.dto.MemberFormDto;
import com.shop.entity.Member;

@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application-test.properties")
public class MemberServiceTest {
	
	@Autowired
	MemberService memberService;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public Member createMember() {
		MemberFormDto memDto = new MemberFormDto();
		memDto.setEmail("test@gmail.com");
		memDto.setName("김미정");
		memDto.setAddress("");
	}
}
