package com.study.springboot;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ValController {

	//	루트하면 실행
	@RequestMapping("/")
	public String root() {
		return "insertForm";
	}
	
	//	인서트 폼에서 특정값을 돈에 전달
	
	//	컨텐트디티오에서 받아서 콘텐트발리데이터에 넣고 리절트로 결과값을 받아서 에러가 있으면 인서트 폼으로 이동 없으면 페이지 이동
	
	// 대상자를 어노테이션으로 표시 // 자동으로 체크되서 result에 저장됨
	@RequestMapping("/done")
	public String insert(@ModelAttribute("dto") @Valid ContentDto contentDto,
						BindingResult result) {
		String page = "donePage";
		
		
		if(result.hasErrors()) {
			System.out.println("getAllErrors: "+ result.getAllErrors());
			if(result.getFieldError("writer")!=null) {
				System.out.println("error1:"+result.getFieldError("writer").getDefaultMessage());
			}
			
			if(result.getFieldError("content")!=null) {
				System.out.println("error2:"+result.getFieldError("content").getDefaultMessage());
			}

			page="insertForm";
		}
		
		return page;
	}
	
}
