package com.study.springboot.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

// 컴포넌트가 컨트롤러보다 컨트롤러도 컴포넌트의 한 종류다
// @서비스
// @레포지터리
// 왜 쓰는가 다 컴포넌트의 종류인데
// 어노테이션은 주석
// 어떻게 사용할 컴포넌트인지 구분하기 위해 따로 쓴다
// 서비스를 쓸거면 서비스를 붙인다 서비스 로직을 짤거다
// 레포지터리는 뭐냐
// 디비랑 연결되는 파트 서비스하는 영역
// 처리를 할 때
// 어느쪽 위치에 있는걸 쓰느냐 어필하기 위해

// 디비랑 연동 제이디비시
// 연결자는 제이디비시템플릿
// 


@Repository
public class MyUserDAO {
	
	@Autowired 
	private JdbcTemplate jdbcTemplate;
	
	public List<MyUserDTO> list() {
		String query = "select * from accounts";
		
		// 결과물에서 파라미터는 mappedClass
		// 컬럼과 DTO 이름이 맞아야 한다
		// 
		List<MyUserDTO> list = jdbcTemplate.query(
				query, new BeanPropertyRowMapper<MyUserDTO>(MyUserDTO.class));
		
		
		// 결과값 확인용
		for(MyUserDTO my : list) {
			System.out.println(my);
		}
		
		// 결과값 리턴
		return list;
	}
	
}
