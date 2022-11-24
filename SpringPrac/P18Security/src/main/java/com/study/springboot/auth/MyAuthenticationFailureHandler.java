package com.study.springboot.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

@Configuration
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		String id = request.getParameter("j_username"); // 로그인 에러 폼에서 로그인 입력값 출력
		String errormsg = "";
		
		// 해당하는 인증을 하는데 필요한 SecurityContextHolder(security context) 안쪽에는 인증처리하는 내용이 포함  
		// Authentication( Principal(아이디) Credentials(비밀번호) Authorities(권한목록) ) 3개가 있음
		// instanceof : exception에 어떤 객체들이 있는지 확인하기 위해서 사용함
		
		if(exception instanceof BadCredentialsException) {
			errormsg="아이디나 비밀번호가 맞지 않습니다. 다시 확인해주세요.";
		} else if (exception instanceof InternalAuthenticationServiceException) {
			errormsg="내부적인 시스템 문제로 인해 인증 요청을 처리할 수 없습니다.";
		} else if (exception instanceof DisabledException) {
			errormsg="계정이 비활성 되었습니다.";
		} else if (exception instanceof CredentialsExpiredException) {
			errormsg="비밀번호 유효기간이 만료되었습니다.";
		}
		
		request.setAttribute("username", id);
		request.setAttribute("error_message", errormsg);
		request.getRequestDispatcher("/loginForm?error").forward(request, response);
		
	}

}
