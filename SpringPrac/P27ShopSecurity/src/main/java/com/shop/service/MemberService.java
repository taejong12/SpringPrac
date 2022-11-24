package com.shop.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.entity.Member;
import com.shop.repository.MemberRepository;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class MemberService implements UserDetailsService {
	

    private final MemberRepository memberRepository;

    public Member saveMember(Member member){
        validateDuplicateMember(member);
        return memberRepository.save(member);
    }

    private void validateDuplicateMember(Member member){
        Member findMember = memberRepository.findByEmail(member.getEmail());
        if(findMember != null){
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }

	//	assertEquals 단위테스트 
	//	질문이 많이 나오는 것
	//	TDD 개발하는 방법론 중 하나
	//	기획-설계-코딩-테스트
	//	모든 단계에서 테스트가 있다
	//	테스트 주도 개발
	//	테스트 과정을 통해서 프로젝트를 해나간다
    // 	테스트 과정에서 확인하기 위한 추정하는 클래스
    // 	포함하는 메서드
    
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Member member = memberRepository.findByEmail(email);

        if(member == null){
            throw new UsernameNotFoundException(email);
        }

        return User.builder()
                .username(member.getEmail())
                .password(member.getPassword())
                .roles(member.getRole().toString())
                .build();
    }
	
}




