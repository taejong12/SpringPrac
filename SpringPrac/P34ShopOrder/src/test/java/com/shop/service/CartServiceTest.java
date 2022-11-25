package com.shop.service;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import com.shop.constant.ItemSellStatus;
import com.shop.dto.CartItemDto;
import com.shop.entity.CartItem;
import com.shop.entity.Item;
import com.shop.entity.Member;
import com.shop.repository.CartItemRepository;
import com.shop.repository.ItemRepository;
import com.shop.repository.MemberRepository;

@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application-test.properties")
class CartServiceTest {

	@Autowired
	ItemRepository itemRepository;
	@Autowired
	MemberRepository memberRepository;
	@Autowired
	CartService cartService;
	@Autowired
	CartItemRepository cartItemRepository;
	
	public Item saveItem() {
		Item item = new Item();
		item.setItemNm("test item");
		item.setPrice(20000);
		item.setItemDetail("test item detail infomation");
		item.setItemSellStatus(ItemSellStatus.SELL);
		item.setStockNumber(50);
		return itemRepository.save(item);
	}
	
	public Member saveMember() {
		Member member = new Member();
		member.setEmail("test@test.com");
		return memberRepository.save(member);
	}
	
	@Test
	@DisplayName("장바구니 담기 테스트")
	public void addCart() {
		Item item = saveItem();
		Member member = saveMember();
		
		CartItemDto cartItemDto = new CartItemDto();
		cartItemDto.setCount(10);
		cartItemDto.setItemId(item.getId());
		
		long cartItemId = cartService.addCart(cartItemDto, member.getEmail());
		
		CartItem cartItem = cartItemRepository.findById(cartItemId)
				.orElseThrow(EntityNotFoundException::new);
		assertEquals(item.getId(), cartItem.getItem().getId());
		assertEquals(cartItemDto.getCount(), cartItem.getCount());
		
	}

}
