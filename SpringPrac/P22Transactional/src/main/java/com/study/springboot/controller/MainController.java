package com.study.springboot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.springboot.service.BuyAndLogService;
import com.study.springboot.service.BuyTicketService;


@Controller
public class MainController {
			
	//	@Autowired
	//	BuyTicketService buyTicket;
	
	@Autowired
	BuyAndLogService buyTicketLog;
	
	@RequestMapping("/")
	public @ResponseBody String root() { // api 형태와 가깝다
		return "Transaction";
	}
	
	// @ResponseBody @Controller 같이 쓴게 @RestController 다
	// 전부 다 걸리니까 특정 부분에만 적용하고 싶으면 @ResponseBody 사용
	
	@RequestMapping("/buy_ticket")
	public String buy_ticket() {
		return "buy_ticket";
	}
	
	@RequestMapping("/buy_ticket_card")
	public String buy_ticket_card(@RequestParam("consumerId") String consumerId,
								@RequestParam("amount") String amount,
								@RequestParam("error") String error,
								Model model) {
		int res = buyTicketLog.buy(consumerId, Integer.parseInt(amount), error);
		model.addAttribute("consumerId", consumerId);
		model.addAttribute("amount",amount);
		System.out.println(res);
		if(res == 1) {
			return "buy_ticket_end";			
		} else {
			return "buy_ticket_error";
		}
	}

	
}
