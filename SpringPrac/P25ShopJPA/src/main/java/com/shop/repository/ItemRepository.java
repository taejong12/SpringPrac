package com.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import com.shop.entity.Item;


public interface ItemRepository extends JpaRepository<Item, Long>,
			QuerydslPredicateExecutor<Item> {
	// find + (entity 이름) + By + 변수명
	List<Item> findByItemNm(String itemNm);
	
	// And, Or, =(is, equal), Between
	List<Item> findByItemNmOrItemDetail(String itemNm, String itemDetail); // 상품명 or 상품상세
	
	// LessThan LessThanEqual GreaterThan GreaterThanEqual
	List<Item> findByPriceLessThan(Integer price); // (Integer price) 보다 작은
	
	List<Item> findByPriceLessThanOrderByPriceDesc(Integer price); // order by price desc; 가격 역정렬
	
	// 메소드명이 아닌 직접적인 쿼리로 적는다
	// JPQL java persistance query language
	// from 뒤에 테이블명이 아닌 엔티티가 온다 별칭을 반드시 적어줘야 한다
	// 어노테이션으로 파람을 불러줘야 %:itemDetail% 이렇게 쓸 수 있다
	@Query("select i from Item i where i.itemDetail like " + "%:itemDetail% order by i.price desc")
	List<Item> findByItemDetail(@Param("itemDetail") String itemDetail);
	
	@Query(value="select * from Item i where i.item_detail like " +
			"%:itemDetail% order by i.price desc", nativeQuery = true)
	List<Item> findByItemDetailByNative(@Param("itemDetail") String itemDetail);
	
	
	
}
