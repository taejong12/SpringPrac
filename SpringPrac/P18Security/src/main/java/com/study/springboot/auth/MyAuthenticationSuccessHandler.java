package com.study.springboot.auth;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.study.springboot.service.AuthenticationUtils;

@Configuration
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Autowired
	AuthenticationUtils autils;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		String target = "/guest/welcome";
		
		List<String> authList = autils.getAuthorities();
		String role = authList.get(0);
		
		if(role.equals("ROLE_ADMIN")) {
			target="/admin/welcome";
		} else if(role.equals("ROLE_USER")) {
			target="/member/welcome";
		}
		
		response.sendRedirect(target);
		
	}

}
