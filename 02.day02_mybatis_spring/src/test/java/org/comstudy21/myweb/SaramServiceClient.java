package org.comstudy21.myweb;


import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.comstudy21.myweb.dto.SaramDTO;

public class SaramServiceClient {
		public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String resource = "org/mybatis/example/mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession session = sqlSessionFactory.openSession();
		try {
			// do work
			
			SaramDTO saram = (SaramDTO) session.selectOne("org.mybatis.example.SaramMapper.selectSaram", "HONG");
			
			System.out.println(saram);
		  
		} finally {
		  //session.close();
		}
	}

}
