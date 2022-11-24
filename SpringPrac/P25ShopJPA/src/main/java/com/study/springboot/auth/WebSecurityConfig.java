package com.study.springboot.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig  {
   
	@Autowired
	public AuthenticationFailureHandler authenticationFailureHandler;
	
	@Autowired
	public AuthenticationSuccessHandler authenticationSuccessHandler;
	
   @Bean
   public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
      http.authorizeRequests()
         .antMatchers("/").permitAll()
         .antMatchers("/css/**","/js/**","/img/**").permitAll()
         .antMatchers("/guest/**").permitAll()
         .antMatchers("/member/**").hasAnyRole("USER","ADMIN")
         .antMatchers("/admin/**").hasRole("ADMIN")
         .anyRequest().authenticated();
      
      http.formLogin()
      	  .loginPage("/loginForm")
      	  .loginProcessingUrl("/j_spring_security_check")
      	  
      	  // 값이 넘어가고 처리 웹시큐리티도 자바소스 실패든 성공이든 단순히 페이지 이동이 아닌 추가하고 싶을 때는 핸들러 사용
      	  // .failureUrl("/loginForm?error") 단순 페이지 이동 
      	  
      	  .failureHandler(authenticationFailureHandler) // .failureHandler(클래스명(변수?같이 내가 만들고자 하는 이름))
      	  
      	  // .defaultSuccessUrl("/member/welcome")
      	  
      	  // .defaultSuccessUrl("/")
      	  // .successForwardUrl("/forward")
      	  .successHandler(authenticationSuccessHandler)
      	  .usernameParameter("j_username")
      	  .passwordParameter("j_password")
      	  .permitAll();
      
      http.logout()
      	  .logoutUrl("/logout")
      	  .logoutSuccessUrl("/loginForm")
      	  .permitAll();
      
      http.csrf().disable();
      return http.build();
   }
   
   @Bean
   public InMemoryUserDetailsManager userDetailService() {
      UserDetails user = User.withUsername("user")
                        .password(passwordEncoder().encode("1234"))
                        .roles("USER")
                        .build();
      
      UserDetails admin = User.withUsername("admin")
            .password(passwordEncoder().encode("1234"))
            .roles("ADMIN")
            .build();
      
      
      UserDetails[] userDetails = new UserDetails[2];
      userDetails[0] = user;
      userDetails[1] = admin;
      System.out.println("<<");
      System.out.println(passwordEncoder().encode("1234"));
      System.out.println(">>");
      return new InMemoryUserDetailsManager(userDetails);
   }
   
   @Bean
   public BCryptPasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
      //StandardPasswordEncoder()-SHA256
      //NoOpPasswordEncoder()-암호화하지 않은 데이터
   }
}