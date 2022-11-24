package com.shop.dto;

import com.shop.constant.ItemSellStatus;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class ItemSearchDto {

    private String searchDateType;
    //all 상품 등록일 전체 1d 1w 1m 6m

    private ItemSellStatus searchSellStatus;

    private String searchBy;
    //itemNm createdBy

    private String searchQuery = "";

}
