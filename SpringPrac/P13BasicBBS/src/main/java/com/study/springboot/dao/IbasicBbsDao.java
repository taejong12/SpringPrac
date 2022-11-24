package com.study.springboot.dao;

import java.util.List;

import com.study.springboot.dto.BasicBbsDto;

public interface IbasicBbsDao {
	public List<BasicBbsDto> listDao(); // 게시물 전체보기
	public BasicBbsDto viewDao(String id); // 게시물 보기
	public int writeDao(String writer, String title, String content); // 게시물작성
	public int deleteDao(String id); // 게시물 삭제
}
