package com.study.springboot.bean;

import org.springframework.stereotype.Component;

// 프린터 B도 객체로 만들어줘야 한다
@Component("PrinterB")
public class PrinterB implements Printer {

	@Override
	public void print(String message) {
		System.out.println("Printer B :" + message);
		
	}
	
}
