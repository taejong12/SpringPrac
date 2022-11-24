package com.study.springboot;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ContentValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return ContentDto.class.isAssignableFrom(arg0);
	}

	// 인터페이스를 받아서 컨텐츠 디티오를 넣어서 형변환시켜서 쓴다
	@Override
	public void validate(Object target, Errors errors) {
		ContentDto dto = (ContentDto) target;
		
		// 검증해야 할거 검증함
		String writerP = dto.getWriter();
		if(writerP == null || writerP.trim().isEmpty()) {
			System.out.println("Writer is null or Empty");
			errors.rejectValue("writer", "trouble");
		}
		
		String contentP = dto.getContent();
		if(contentP == null || contentP.trim().isEmpty()) {
			System.out.println("content is null or Empty");
			errors.rejectValue("content", "trouble");
			
		}
	}
	
}
