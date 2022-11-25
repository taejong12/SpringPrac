package com.shop.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TestOneDto {
	private int id;
	private String writer;
	private String iname;
	private String idetail;
	private String istatus;
	private int price;
	private int stock;
	private java.sql.Date time;
}
