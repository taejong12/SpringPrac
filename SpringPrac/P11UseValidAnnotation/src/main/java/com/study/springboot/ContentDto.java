package com.study.springboot;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
public class ContentDto {

	private int id;
	
	@NotNull(message="writer is null.")
	@NotEmpty(message="writer is empty.")
	@Size(min=2,max=10,message="writer length is minimum 2")
	//	@Size(min=2,max=10,message="writer 두자이상 열자이하")
	
	private String writer;
	
	@NotNull(message="content is null.")
	@NotEmpty(message="content is empty.")
	
	private String content;
	
}
