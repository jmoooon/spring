package org.comstudy21.myapp.board.test;

import java.util.List;
import java.util.Scanner;

import org.comstudy21.myapp.board.service.BoardService;
import org.comstudy21.myapp.board.vo.BoardVo;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		BoardService boardService = (BoardService) factory.getBean("boardService");
		
		BoardVo board = new BoardVo();
		
		/*
		System.out.println("작성자입력>>> ");
		board.setWriter(scan.nextLine());
		System.out.println("내용입력>>> ");
		board.setContent(scan.nextLine());
		System.out.println("제목입력>>> ");
		board.setTitle(scan.nextLine());
		*/
		/*
		System.out.print("작성자입력>>> ");
		board.setWriter(scan.next());
		System.out.print("내용입력>>> ");
		board.setContent(scan.next());
		System.out.print("제목입력>>> ");
		board.setTitle(scan.next());
		*/
		
		//boardService.insertBoard(board);
		
		//boardService.deleteAllBoard();
		
		List<BoardVo> boardList = boardService.getBoardList();
		
		for(BoardVo boardEA : boardList){
			System.out.println(boardEA);
		}
		
		board = new BoardVo();
		board.setSeq(3);
		
		System.out.println(boardService.getBoard(board));
	}

}
