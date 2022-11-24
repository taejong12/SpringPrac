package com.shop.service;




import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.entity.Member;
import com.shop.repository.MemberRepository;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class MemberService {
	private final MemberRepository memberRepository;
	
	public Member saveMember(Member member) {
		validationDuplicateMember(member);
		return memberRepository.save(member);
	}

	private void validationDuplicateMember(Member member) {
		Member findMember = memberRepository.findByEmail(member.getEmail());
		if(findMember != null) {
			throw new IllegalStateException("이미 가입된 회원입니다.");
		} 
		
	}
	
	
	
}
