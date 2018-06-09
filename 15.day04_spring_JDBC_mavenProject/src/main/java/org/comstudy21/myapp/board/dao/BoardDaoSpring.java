package org.comstudy21.myapp.board.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.comstudy21.myapp.board.vo.BoardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.comstudy21.myapp.board.dao.BoardRowMapper;


@Repository
public class BoardDaoSpring implements Dao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void insertBoard(BoardVo vo) {
		// TODO Auto-generated method stub
		//jdbcTemplate.update(BOARD_INSERT, new Object[]{vo.getTitle(), vo.getWriter(), vo.getContent()});
		jdbcTemplate.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
	}

	@Override
	public void updateBoard(BoardVo vo) {
		// TODO Auto-generated method stub
		jdbcTemplate.update(BOARD_UPDATE, new Object[]{vo.getTitle(), vo.getContent(), vo.getSeq()});
	}

	@Override
	public void deleteBoard(BoardVo vo) {
		// TODO Auto-generated method stub
		jdbcTemplate.update(BOARD_DELETE, new Object[]{vo.getSeq()});
	}

	@Override
	public void deleteAllBoard() {
		// TODO Auto-generated method stub
		jdbcTemplate.update(BOARD_DELETE_ALL);
	}

	@Override
	public BoardVo getBoard(BoardVo vo) {
		// TODO Auto-generated method stub
		
		//return (BoardVo) jdbcTemplate.queryForObject(BOARD_GET, new Object[] {vo.getSeq()}, new BeanPropertyRowMapper<>(BoardVo.class));
		
		Object[] args = {vo.getSeq()};
		return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
		
	}

	@Override
	public List<BoardVo> getBoardList() {
		// TODO Auto-generated method stub
		
		//return (List<BoardVo>) jdbcTemplate.query(BOARD_LIST, new Object[]{}, new BeanPropertyRowMapper<BoardVo>(BoardVo.class));
		//return (List<BoardVo>) jdbcTemplate.query(BOARD_LIST, new BeanPropertyRowMapper<BoardVo>(BoardVo.class));

		return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
	}
}

/*
 * 클래스 따로 만들어서 뺐음.
class BoardRowMapper implements RowMapper<BoardVo>{
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
*/
