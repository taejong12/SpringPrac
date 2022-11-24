package com.shop.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.shop.constant.ItemSellStatus;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="item")
@Getter
@Setter
@ToString
public class Item {
	
	// pk(primary key) 역할
	@Id
	@Column(name="item_id")
	@GeneratedValue(strategy = GenerationType.AUTO) // 아이디값을 자동생성
	private Long id;	// 상품코드
	
	// not null 제약조건
	@Column(nullable=false, length=50)
	private String itemNm;	// 상품명
	
	@Column(name="price", nullable=false)
	private int price;	// 가격
	
	@Column(nullable=false)
	private int stockNumber;	// 재고수량
	
	@Lob
	@Column(nullable=false)
	private String itemDetail;	// 상품상세
	
	@Enumerated(EnumType.STRING) // EnumType을 문자열로 값만 넣는다
	private ItemSellStatus itemSellStatus;	//상품 판매 상태
	
	
	private LocalDateTime regTime;	// 등록
	
	
	private LocalDateTime updateTime;	// 수정
	
}
