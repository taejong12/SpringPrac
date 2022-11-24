package com.study.springboot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ModelController {
	
	@RequestMapping("/")
	public @ResponseBody String root() {
		// model and view
		return "Model and view";
	}
	
	@RequestMapping("/test1")
	public String test(Model model) {
		// Model 객체를 이용 view에 data 전달
		// 데이터만 설정 가능
		model.addAttribute("name","홍길동");
		return "test1";
		
	}
	// 모델 객체로 받아서
	// 뷰로 전달
	// model Map
	// 모델이랑 모델맵은 데이터만 들어간다
	// 모델앤뷰는 모델에 데이터 뷰에는 화면 뷰값까지 넣을 수 있다
	// 뷰와 모델을 동시에 적용 가능
	// 데이터값과 화면값 둘다
	// 해당하는 객체를 만들어서 직접 넣기도 하고 오브젝트로 넣기도 한다
	// 해당하는 데이터값을 뷰값을 통해 전달
	
	
	
	@RequestMapping("/mv")
	public ModelAndView test2() {
		// 데이터와 뷰를 동시에 설정이 가능
		ModelAndView mv = new ModelAndView();
		
		List<String> list = new ArrayList<>();
		
		list.add("나");
		list.add("너");
		list.add("우리");
		
		mv.addObject("lists", list);
		mv.addObject("ObjectTest", "테스트입니다.");
		mv.addObject("name", "홍길동");
		mv.setViewName("myView");
		return mv;
	}
	
}
