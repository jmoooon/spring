package org.comstudy21.myweb.dao;

import java.util.List;

import org.comstudy21.myweb.dto.SaramDTO;
import org.mybatis.spring.SqlSessionTemplate;

public class SaramDAO {
	private SqlSessionTemplate myBatis;
	
	public void setMyBatis(SqlSessionTemplate myBatis){
		this.myBatis = myBatis;
	}
	
	public SaramDTO getById(String id){
		try {
			// do work
			SaramDTO saram = myBatis.selectOne("org.mybatis.example.SaramMapper.selectSaram", "HONG");
			System.out.println(saram);
			return saram;
		} finally {
		  //
		}
	}

	public List<SaramDTO> selectAll() {
		// TODO Auto-generated method stub
		List<SaramDTO> list = myBatis.selectList("org.mybatis.example.SaramMapper.selectAll");
		
		return list;
	}
}
