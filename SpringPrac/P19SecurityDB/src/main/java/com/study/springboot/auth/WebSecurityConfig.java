package com.study.springboot.auth;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
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
	
	@Autowired
	public DataSource dataSource;
	
//	직접적으로 유저를 설정
//	이번에는 유저를 만들고 설정할 때 직접 넣는 것이 아닌 디비에서 읽어온다
//	유저디테일매니저로 불러온다
//	제이디비시로 연동해서 불러온다
//	이때 오는 데이터소스가 중요하다
//	디비에 접근하려면 정보가 필요하다 이 역할이 데이터소스가 담당한다
//	데이터소스 값을 가져다가 쓴다
//	때에 따라 조작을 해야할 때도 있다 데이터 소스를 직접 만듬
//	들어가는건 데이터소스가 맞는데 정보가 다를 수도 있다
//	유저네임커리를 사용해서 셋한다
//	유저네임으로 조회를 하겠다
//	유저네임이 없으면 유저 네임이라는 별칭을 줘야 한다 as userName
//	쿼리문을 통해서 조건절
	
	
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
   public UserDetailsManager users(DataSource dataSource) {
	   JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
	   users.setUsersByUsernameQuery("select name as userName, password, enabled" 
			   			+ " from user_list where name = ?");
	   users.setAuthoritiesByUsernameQuery("select name as userName, authority " 
			   			+ " from user_list where name = ?");
	   return users;
   }
   
   
//   @Bean
//   public InMemoryUserDetailsManager userDetailService() {
//      UserDetails user = User.withUsername("user")
//                        .password(passwordEncoder().encode("1234"))
//                        .roles("USER")
//                        .build();
//      
//      UserDetails admin = User.withUsername("admin")
//            .password(passwordEncoder().encode("1234"))
//            .roles("ADMIN")
//            .build();
//      
//      
//      UserDetails[] userDetails = new UserDetails[2];
//      userDetails[0] = user;
//      userDetails[1] = admin;
//      System.out.println("<<");
//      System.out.println(passwordEncoder().encode("1234"));
//      System.out.println(">>");
//      return new InMemoryUserDetailsManager(userDetails);
//   }
   
   @Bean
   public BCryptPasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
      //StandardPasswordEncoder()-SHA256
      //NoOpPasswordEncoder()-암호화하지 않은 데이터
   }
}