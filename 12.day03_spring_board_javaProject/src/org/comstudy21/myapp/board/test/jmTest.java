package org.comstudy21.myapp.board.test;

import org.comstudy21.myapp.board.dao.BoardDao;
import org.comstudy21.myapp.board.vo.BoardVo;
import org.comstudy21.myapp.util.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class jmTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		/*
		@SuppressWarnings("resource")
		ApplicationContext factory = new AnnotationConfigApplicationContext(Config.class);
		*/
		
		BoardVo board = (BoardVo) factory.getBean("boardVo");
		
		BoardDao boardDao = (BoardDao) factory.getBean("boardDao");
		/*
		board.setTitle("시작");
		board.setContent("시작입니다.");
		board.setWriter("가즈아");
		boardDao.insertBoard(board);
		*/
		board.setSeq(3);
		boardDao.deleteAllBoard();
		
	}

}
