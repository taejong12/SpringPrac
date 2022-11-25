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
		System.out.println(service.list());
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
		String update_time=req.getParameter("update_time");
		String created_by=req.getParameter("created_by");
		String item_detail=req.getParameter("item_detail");
		String item_name=req.getParameter("item_name");
		String item_sell_status=req.getParameter("item_sell_status");
		String price=req.getParameter("price");
		String stock=req.getParameter("stock");
//		System.out.println(update_time);
//		System.out.println(created_by);
//		System.out.println(item_detail);
//		System.out.println(item_name);
//		System.out.println(item_sell_status);
//		System.out.println(price);
//		System.out.println(stock);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("UPDATE_TIME", update_time);
		map.put("CREATED_BY", created_by);
		map.put("ITEM_DETAIL", item_detail);
		map.put("ITEM_NAME", item_name);
		map.put("ITEM_SELL_STATUS", item_sell_status);
		map.put("PRICE", price);
		map.put("STOCK", stock);
		
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
