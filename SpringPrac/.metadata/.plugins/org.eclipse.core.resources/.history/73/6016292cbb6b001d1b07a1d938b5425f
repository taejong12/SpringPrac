package com.shop.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.service.BasicBbsService;



@Controller
public class BoardController {
		
	@Autowired
	BasicBbsService service;
	

	@RequestMapping("/list")
	public String userlist(Model model) {
		model.addAttribute("list" , service.list());
		
		int total=service.count();
		System.out.println("total count:" + total);
		
		return "/testBoard/list";
	}
	
	
	@RequestMapping("/write")
	public String writeForm() {
		return "/testBoard/writeForm";
	}
	
	@RequestMapping("/writing")
	public String write(HttpServletRequest req, Model model) {
		String created_by=req.getParameter("created_by");
		String item_name=req.getParameter("item_name");
		String item_detail=req.getParameter("item_detail");
		String price=req.getParameter("price");
		String stock=req.getParameter("stock");
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("created_by", created_by);
		map.put("item_name", item_name);
		map.put("item_detail", item_detail);
		map.put("price", price);
		map.put("stock", stock);
		
		int res = service.write(map);
		System.out.println("created_by:" + res);
		return "redirect:list"; //redirect를 사용하면 주소 맵핑 방향으로 간다 
	}
	
	@RequestMapping("/view")
	public String detailView(HttpServletRequest req, Model model) {
		String uId = req.getParameter("id");
		model.addAttribute("dto",service.view(uId));
		return "/testBoard/view"; // view 파일 jsp 쪽으로 간다
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest req, Model model) {
		int res = service.delete(req.getParameter("id"));
		System.out.println("delete:" + res);
		return "redirect:list";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
