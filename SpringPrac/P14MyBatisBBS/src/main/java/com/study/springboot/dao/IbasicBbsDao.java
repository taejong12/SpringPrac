package com.study.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.study.springboot.dto.BasicBbsDto;


@Mapper
public interface IbasicBbsDao {
	public List<BasicBbsDto> listDao(); // 게시물 전체보기
	public BasicBbsDto viewDao(String id); // 게시물 보기
	public int writeDao(String writer, String title, String content); // 게시물작성
	// public int deleteDao(String id); // 게시물 삭제
	public int deleteDao(@Param("_id") String id); // 게시물 삭제
}


