package com.study.springboot.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// 컨트롤은 컨트롤 어노테이션 컨트롤러 객체로 인지
@Controller
public class DIController {
	
	// 객체 어노테이션
	@Autowired
	Member member1;
	// new가 아닌 DI로 한다 DI로 하면 의존성이 낮아진다
	@Autowired
	@Qualifier("PrinterB")
	Printer printer;
	@Autowired
	Member member2;
	
	// 빈객체로 등록했고
	// 해당하는 주소창에서 url 값을 기준으로 해서 빈객체에 맵핑을 시켜준다
	// 컨트롤러 안에 있는 메서드랑 매칭을 시켜준다
	// 뒤에 들어오는거 맵핑 시켜주는게 리퀘스트 맵핑
	
	//	뷰단 연동을 위해 연결이 된다
	//	화면이동 하듯이 처리된다
	//	결과값을 스트링으로 받고 싶으면
	//	작성해야 하는 내용이 있다
	//	@ResponseBody가 들어가야 한다
	//	해당하는 내용물이 왔을 때 결과값이 주소이동이 아닌 api처럼 파라미터 값을 넘겨주면 그의 따른 결과값만 리턴해준다
	// 기능적으로 떨어져 있고 결과값만 리턴 페이지 이동이 일어나지 않는다
	// ajax 저쪽에 데이터를 넘겨주고 데이터를 받는다
	// 넘어오는 값을 결과값으로만 받을 때 @ResponseBody를 붙여준다
	
	// 어노테이션으로 다 처리했다
	
	// 첫번째 실행 스프링부트어플리케이션 준비만 하는 상태
	// 그 다음은 컨트롤러 실행
	
	@RequestMapping("/")
	public @ResponseBody String root() {
		member1.print();
		member1.setPrinter(printer);
		member1.print();
		
		if (member1 == member2) {
			System.out.println("동일한 객체입니다.");
	    } else {
	    	System.out.println("서로 다른 객체입니다.");
	    }
		
		return "Annotation 사용";
	}
	
	
}
