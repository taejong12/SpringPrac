package com.shop.dto;

import java.time.LocalDateTime;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ItemDto {

	//	dto는 dto, entity는 entity
	private Long id;	// 상품코드
	private String itemNm;	// 상품명
	private int price;	// 가격
	private String itemDetail;	// 상품상세
	private String sellStatCd;
	private LocalDateTime regTime;	// 등록
	private LocalDateTime updateTime;	// 수정
}
