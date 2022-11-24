package com.study.springboot;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


public class LombokController {


	@RequestMapping("/")
	public String root() {
		return "form";
	}
	
	@RequestMapping("/test1")
	public String test1(PersonDTO person, Model model) {
		model.addAttribute("person", person);
		return "test1";
	}
}
	
서블릿 안에서 파라미터 값으로 검증하는 방법
클라이언트에서 처리할 수 없을 때

해당하는 검증자체
유효성 검증
어디서 하느냐
스프링부트에서
여러가지 방식
통일성 문제
발리데이터




	
