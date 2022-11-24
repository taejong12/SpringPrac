package com.study.springboot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.springboot.dao.IbasicBbsDao;

@Controller
public class MainController {

	@Autowired
	IbasicBbsDao dao;
	
	@RequestMapping("/")
	public String root() {
		
		// 들어오면 다른페이지(redirect:list(list로 간다))로 보내버리겠다
		return "redirect:list";
	}
	
	@RequestMapping("/list")
	public String userlist(Model model) {
		model.addAttribute("list" , dao.listDao());
		return "list";
	}
	
	@RequestMapping("/write")
	public String writeForm() {
		return "writeForm";
	}
	
	@RequestMapping("/writing")
	public String write(HttpServletRequest req, Model model) {
		dao.writeDao(req.getParameter("writer"),
				req.getParameter("title"),
				req.getParameter("content"));
		return "redirect:list"; //redirect를 사용하면 주소 맵핑 방향으로 간다 
	}
	
	@RequestMapping("/view")
	public String detailView(HttpServletRequest req, Model model) {
		String uId = req.getParameter("id");
		model.addAttribute("dto",dao.viewDao(uId));
		return "view"; // view 파일 jsp 쪽으로 간다
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest req, Model model) {
		dao.deleteDao(req.getParameter("id"));
		return "redirect:list";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
