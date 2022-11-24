package com.study.springboot;

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
	@RequestMapping("/done")
	
	// @ModelAttribute 
	public String insert(@ModelAttribute("dto") ContentDto contentDto,
						BindingResult result) {
		String page = "donePage";
		System.out.println(contentDto);
		
		ContentValidator validator = new ContentValidator();
		validator.validate(contentDto, result);
		if(result.hasErrors()) {
			page="insertForm";
		}
		
		return page;
	}
}
