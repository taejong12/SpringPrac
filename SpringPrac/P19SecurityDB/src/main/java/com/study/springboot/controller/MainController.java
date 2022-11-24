package com.study.springboot.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String root() { 
		return "/security/loginForm";
	}
	
	@RequestMapping("/guest/welcome")
	public String welcome1() {
		System.out.println("guest");
		return "/guest/welcomeGuest";
	}
	
	@RequestMapping("/member/welcome")
	public String welcome2() {
		System.out.println("member");
		return "/member/welcomeMember";
	}
	
	@RequestMapping("/admin/welcome")
	public String welcome3() {
		System.out.println("admin");
		return "/admin/welcomeAdmin";
	}
	
	@RequestMapping("/loginError")
	public String loginError() {
		System.out.println("logout");
		return "/security/loginError";
	}
	
	@RequestMapping("/loginForm")
	   public String loginForm() {
	      System.out.println("login");
	      return "/security/loginForm";
	}
	
	
}
