package com.shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	 public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		return http.build();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	      return new BCryptPasswordEncoder();
	      
	      //StandardPasswordEncoder()-SHA256
	      //NoOpPasswordEncoder()-암호화하지 않은 데이터
	  }
}
