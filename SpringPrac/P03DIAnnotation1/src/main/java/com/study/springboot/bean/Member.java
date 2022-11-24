package com.study.springboot.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// 빈 객체를 만들어서 config가 필요없어짐

@Component
public class Member {
	
	@Value("홍길동")
	private String name;
	
	@Value("도사")
	private String nickname;
	
	// 프린터는 일반 값을 넣을 수 있는 대상이 아니다 객체이기 때문에
	// 객체의 경우 @Autiwired를 적어야 한다 객체를 연결
	// 비슷하거나 같은 이름의 객체가 있다 그래서 좀 더 명확하게 할 필요성이 있다 유사한 이름이 여러개 있을 때 뭘 자동으로 연결해야하는지 알 수 없으니까 
	// 이 때는 @Qualifier를 붙여서 구체적으로 명확하게 해준다
	// 프린터는 오터에 연결해주고 밑에 구체적으로 연결해준다
	@Autowired
	@Qualifier("PrinterA")
	private Printer printer;
	
	public Member() {}
	
	public Member(String name, String nickname, Printer printer) {
		this.name=name;
		this.nickname=nickname;
		this.printer=printer;
	}
	
	public void setName(String name) {
		this.name=name;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setPrinter(Printer printer) {
		this.printer = printer;
	}
	
	public void print() {
		printer.print("Hello" + name + " : " + nickname);
	}
}
