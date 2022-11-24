package com.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class P03DiAnnotation1Application {

	public static void main(String[] args) {
		SpringApplication.run(P03DiAnnotation1Application.class, args);
	}
	
}

// @SpringBootApplication(여러가지 기능을 동시에 하고 있다) // 이게 붙으면 메인이 된다
// @Configuration(빈 객체를 생성할 때 설정할 때 박아주는게 Configuration이다(각종 설정)) // 이 3가지 설정이 초반에 다 진행된다 
// + @EnableAutoConfiguration(최초의 컨테이너가 생성될 때 설정되는 것을 자동으로 설정해줌(application context 관련 자동 설정) 필요하면 어노테이션 달고 밑에 추가 작성함)
// @ComponentScan( @Component @Configuration이 붙은 클래스 스캔 빈 등록(네거시에서 썼던 스캔을 어노테이션으로 처리))


