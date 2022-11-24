package com.study.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.springboot.jdbc.MyUserDAO;

@Controller
public class MainController {

	// 빈 객체를 만들어놔야 연결 가능
	@Autowired
	private MyUserDAO userDao;

	@RequestMapping("/")
	public @ResponseBody String root() {
		return "Jdbc 연결";
	}
	
	// @GetMapping("/user")
	@RequestMapping(value="/user", method=RequestMethod.GET)
	public String userlistPage(Model model) {
		model.addAttribute("users", userDao.list());
		return "userlist";
	}
	
	
}
