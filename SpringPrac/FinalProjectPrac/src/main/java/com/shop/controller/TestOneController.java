package com.shop.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.service.BasicBbsService;
import com.shop.service.TestOneService;



@Controller
public class TestOneController {
		
	@Autowired
	TestOneService service;
	
	@RequestMapping("/listOne")
	public String userlist(Model model) {
		model.addAttribute("list" , service.list());
		System.out.println(service.list());
		int total=service.count();
		System.out.println("total count:" + total);
		return "/testBoardOne/list";
	}
	
	
	@RequestMapping("/writeOne")
	public String writeForm() {
		return "/testBoardOne/writeForm";
	}
	
	@RequestMapping("/writingOne")
	public String write(HttpServletRequest req, Model model) {
		String writer=req.getParameter("writer");
		String iname=req.getParameter("iname");
		String idetail=req.getParameter("idetail");
		String istatus=req.getParameter("istatus");
		String price=req.getParameter("price");
		String stock=req.getParameter("stock");
		String time=req.getParameter("time");

		
		Map<String, String> map = new HashMap<String, String>();
		map.put("writer", writer);
		map.put("iname", iname);
		map.put("idetail", idetail);
		map.put("istatus", istatus);
		map.put("price", price);
		map.put("stock", stock);
		map.put("time", time);
		
		int res = service.write(map);
		System.out.println("created_by:" + res);
		return "redirect:listOne"; //redirect를 사용하면 주소 맵핑 방향으로 간다 
	}
	
	@RequestMapping("/viewOne")
	public String detailView(HttpServletRequest req, Model model) {
		String uId = req.getParameter("id");
		model.addAttribute("dto",service.view(uId));
		return "/testBoardOne/view"; // view 파일 jsp 쪽으로 간다
	}
	
	@RequestMapping("/deleteOne")
	public String delete(HttpServletRequest req, Model model) {
		int res = service.delete(req.getParameter("id"));
		System.out.println("delete:" + res);
		return "redirect:listOne";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
