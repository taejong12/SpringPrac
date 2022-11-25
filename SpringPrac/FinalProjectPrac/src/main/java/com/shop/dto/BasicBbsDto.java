package com.shop.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BasicBbsDto {
	private int id;
	private java.sql.Date update_time;
	private String created_by;
	private String item_detail;
	private String item_name;
	private String item_sell_status;
	private int price;
	private int stock;
}
