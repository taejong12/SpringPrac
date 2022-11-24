package com.study.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JspController {
	
	// ("/") 모든 경로
	@RequestMapping("/")
	public @ResponseBody String root () {
		return "JSP"; // @ResponseBody 결과값으로 넘어감
	}
	
	// get, post mapping도 있다 
	@RequestMapping("/test1") // localhost:8081/test1
	public String test1() {
		return "test";	// /WEB-INF/views/test.jsp
	}
	
	@RequestMapping("/test2") // localhost:8081/test2
	public String test2() {
		return "sub/test";		// /WEB-INF/views/sub/test.jsp
	}
	
}
