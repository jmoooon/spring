package org.comstudy21.myapp.board.dao;

import java.util.List;

import org.comstudy21.myapp.board.vo.BoardVo;

public interface Dao {
	// SQL 명령어들
	public static String BOARD_INSERT = "INSERT INTO BOARD (SEQ, TITLE, WRITER, CONTENT)" 
			                          + "VALUES ((SELECT NVL(MAX(SEQ), 0)+1 from board), ?, ?, ?)";
	public static String BOARD_UPDATE = "UPDATE BOARD SET TITLE = ?, CONENT = ? WHERE SEQ = ?";
	public static String BOARD_DELETE = "DELETE FROM BOARD WHERE SEQ = ?";
	public static String BOARD_DELETE_ALL = "DELETE FROM BOARD";
	public static String BOARD_GET = "SELECT SEQ, TITLE, WRITER, CONTENT, REGDATE, CNT FROM BOARD WHERE SEQ = ?";
	public static String BOARD_LIST = "SELECT * FROM BOARD ORDER BY SEQ DESC";
	
	
	public void insertBoard(BoardVo vo);
	public void updateBoard(BoardVo vo);
	public void deleteBoard(BoardVo vo);
	public void deleteAllBoard();
	public BoardVo getBoard(BoardVo vo);
	public List<BoardVo> getBoardList();
}
