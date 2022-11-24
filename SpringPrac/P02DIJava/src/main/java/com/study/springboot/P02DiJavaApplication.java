package com.study.springboot;



import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.study.springboot.bean.Config;
import com.study.springboot.bean.Member;
import com.study.springboot.bean.Printer;

// DI를 이해하기 위해서 진행
// 

//@SpringBootApplication
public class P02DiJavaApplication {

   public static void main(String[] args) {
      //SpringApplication.run(P02DiJavaApplication.class, args);
      
      //1.컨테이너 생성(IOC)
      ApplicationContext context= new AnnotationConfigApplicationContext(Config.class);
      
      //2.Bean 가져오기
      // 형변환 해줘야 한다
      Member member1 = (Member) context.getBean("member1");
      member1.print();
      
      // 뒤에 타입을 정해줬기 때문에 형변환을 하지 않는다
      Member member2 = context.getBean("hello",Member.class);
      member2.print();
      
      Member member3 = context.getBean("member1",Member.class);
      member3.print();
      
      Printer printer= context.getBean("printerB",Printer.class);
      member1.setPrinter(printer);
      member1.print();
      member2.print();
      
      // 3.동일 객체 확인(Singleton)
      if (member1 == member3) {
    	  System.out.println("동일한 객체입니다.");
      } else {
    	  System.out.println("서로 다른 객체입니다.");
      }
   }

}