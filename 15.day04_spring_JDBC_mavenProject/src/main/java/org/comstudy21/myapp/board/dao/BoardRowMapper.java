package org.comstudy21.myapp.board.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.comstudy21.myapp.board.vo.BoardVo;
import org.springframework.jdbc.core.RowMapper;

public class BoardRowMapper implements RowMapper<BoardVo> {
	@Override
	public BoardVo mapRow(ResultSet rs, int rowNum) throws SQLException{
		BoardVo board = new BoardVo();
		
		board.setSeq(rs.getInt("seq"));
		board.setTitle(rs.getString(2));
		board.setWriter(rs.getString(3));
		board.setContent(rs.getString(4));
		board.setRegDate(rs.getDate(5));
		board.setCnt(rs.getInt(6));
		
		return board;
	}
}
