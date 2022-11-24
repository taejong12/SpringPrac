package com.study.springboot.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.study.springboot.dto.BasicBbsDto;

@Repository
public class BasicBbsDao implements IbasicBbsDao {

	@Autowired
	// 반드시 필요한것
	JdbcTemplate jtemplate;
	
	@Override
	public List<BasicBbsDto> listDao() {
		System.out.println("listDao()");
		String query = "select * from basic_bbs order by id desc";
		
		List<BasicBbsDto> dtos = jtemplate.query(query, new BeanPropertyRowMapper<BasicBbsDto>(BasicBbsDto.class));
		
		return dtos;
	}

	@Override
	public BasicBbsDto viewDao(String id) {
		System.out.println("viewDao()");
		String query="select * from basic_bbs where id="+id;
		
		// 한개만 받아올 때 queryForObject를 쓴다
		BasicBbsDto dto = jtemplate.queryForObject(query, new BeanPropertyRowMapper<BasicBbsDto>(BasicBbsDto.class));
		return dto;	
	}

	@Override
	public int writeDao(String writer, String title, String content) {
		System.out.println("writeDao()");
		String query = "insert into basic_bbs (id,writer,title,content)" + " values (BASIC_BBS_SEQ.nextval, ?,?,?)";
		
		return jtemplate.update(query, writer, title, content);
	}

	@Override
	public int deleteDao(String id) {
		System.out.println("deleteDao()");
		String query = "delete from basic_bbs where id=?";
		return jtemplate.update(query, Integer.parseInt(id));
	}

}
