package com.study.springboot;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class FormController {
	
	@RequestMapping("/")
	public String root() {
		return "form";
	}
	
	
	@RequestMapping("/test1")
	public String test1(HttpServletRequest httpServletRequest, Model model) {
		String age = httpServletRequest.getParameter("age");
		String name = httpServletRequest.getParameter("name");
		
		model.addAttribute("age", age);
		model.addAttribute("name", name);
		
		return "test1";
	}
	
	@RequestMapping("/test2")
	public String test1(@RequestParam("age") String age,
						@RequestParam("name") String name, Model model) {
		
		model.addAttribute("age", age);
		model.addAttribute("name", name);
		
		return "test1";
	}
	
	@RequestMapping("/test3")
	public String test1(PersonDTO person, Model model) {
		model.addAttribute("person",person);
		return "test3";
	}
	
	@RequestMapping("/test4/{personname}/{personage}")
	public String getPathInfo(@PathVariable String personname,
							  @PathVariable String personage, Model model) {
		
		model.addAttribute("age", personage);
		model.addAttribute("name", personname);
		return "test1";
	}
	
//	@RequestMapping("")
//	@RequestMapping("")
//	@RequestMapping("")
//	@RequestMapping("")
//	@RequestMapping("")
//	@RequestMapping("")
//	@RequestMapping("")
//	
	
}
