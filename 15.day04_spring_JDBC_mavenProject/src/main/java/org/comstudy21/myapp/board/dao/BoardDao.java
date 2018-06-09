package org.comstudy21.myapp.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.comstudy21.myapp.board.service.BoardService;
import org.comstudy21.myapp.board.vo.BoardVo;
import org.comstudy21.myapp.util.JdbcUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao implements Dao {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	/* (non-Javadoc)
	 * @see org.comstudy21.myapp.board.dao.BoardService#insertBoard(org.comstudy21.myapp.board.vo.BoardVo)
	 */
	@Override
	public void insertBoard(BoardVo vo) {
		// TODO Auto-generated method stub
		conn = JdbcUtil.getConnection();
		
		try {
			stmt = conn.prepareStatement(BOARD_INSERT);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getWriter());
			stmt.setString(3, vo.getContent());
			int cnt = stmt.executeUpdate();
			if(cnt != 1){
				System.out.println("입력 처리 실패");
				conn.rollback();
			}
			else{
				conn.commit();
				System.out.println("입력 처리 성공");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		finally{
			JdbcUtil.close(null, stmt, conn);
		}	
	}

	/* (non-Javadoc)
	 * @see org.comstudy21.myapp.board.dao.BoardService#updateBoard(org.comstudy21.myapp.board.vo.BoardVo)
	 */
	@Override
	public void updateBoard(BoardVo vo) {
		// TODO Auto-generated method stub
		
		conn = JdbcUtil.getConnection();
		try {
			stmt = conn.prepareStatement(BOARD_UPDATE);
			
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getContent());
			stmt.setInt(3, vo.getSeq());
			
			int cnt = stmt.executeUpdate();
			
			if(cnt != 1){
				System.out.println("수정 처리 실패");
				conn.rollback();
			}
			else{
				conn.commit();
				System.out.println("수정 처리 성공");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		finally{
			JdbcUtil.close(null, stmt, conn);
		}
		

	}

	/* (non-Javadoc)
	 * @see org.comstudy21.myapp.board.dao.BoardService#deleteBoard(org.comstudy21.myapp.board.vo.BoardVo)
	 */
	@Override
	public void deleteBoard(BoardVo vo) {
		// TODO Auto-generated method stub
		conn = JdbcUtil.getConnection();
		try {
			stmt = conn.prepareStatement(BOARD_DELETE);
			
			stmt.setInt(1, vo.getSeq());
			
			int cnt = stmt.executeUpdate();
			
			if(cnt != 1){
				System.out.println("삭제 처리 실패");
				conn.rollback();
			}
			else{
				conn.commit();
				System.out.println("삭제 처리 성공");
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		finally{
			JdbcUtil.close(null, stmt, conn);
		}
		
	}

	/* (non-Javadoc)
	 * @see org.comstudy21.myapp.board.dao.BoardService#getBoard(org.comstudy21.myapp.board.vo.BoardVo)
	 */
	@Override
	public BoardVo getBoard(BoardVo vo) {
		// TODO Auto-generated method stub
		
		conn = JdbcUtil.getConnection();
		
		BoardVo board = null;
		try {
			stmt = conn.prepareStatement(BOARD_GET);
			
			stmt.setInt(1, vo.getSeq());
			rs = stmt.executeQuery();
			
			if(rs == null){
				System.out.println("자료 가져오기 실패");
				return null;
			}
			else{
				if(rs.next()){
					board = new BoardVo();
					board.setSeq(rs.getInt("seq"));
					board.setTitle(rs.getString(2));
					board.setWriter(rs.getString(3));
					board.setContent(rs.getString(4));
					board.setRegDate(rs.getDate(5));
					board.setCnt(rs.getInt(6));
				}
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			JdbcUtil.close(rs, stmt, conn);
		}
		
		
		return board;
	}

	/* (non-Javadoc)
	 * @see org.comstudy21.myapp.board.dao.BoardService#getBoardList(org.comstudy21.myapp.board.vo.BoardVo)
	 */
	@Override
	public List<BoardVo> getBoardList() {
		// TODO Auto-generated method stub
		
		conn = JdbcUtil.getConnection();
		
		BoardVo board = null;
		List<BoardVo> boardList = new ArrayList();
		
		try {
			stmt = conn.prepareStatement(BOARD_LIST);
			
			rs = stmt.executeQuery();
			
			if(rs == null){
				System.out.println("자료 가져오기 실패");
				return null;
			}
			else{
				while(rs.next()){
					board = new BoardVo();
					board.setSeq(rs.getInt("seq"));
					board.setTitle(rs.getString(2));
					board.setWriter(rs.getString(3));
					board.setContent(rs.getString(4));
					board.setRegDate(rs.getDate(5));
					board.setCnt(rs.getInt(6));
					boardList.add(board);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			JdbcUtil.close(rs, stmt, conn);
		}
			
		return boardList;
	}

	
	/* (non-Javadoc)
	 * @see org.comstudy21.myapp.board.dao.BoardService#deleteAllBoard()
	 */
	@Override
	public void deleteAllBoard() {
		conn = JdbcUtil.getConnection();
		try {
			stmt = conn.prepareStatement(BOARD_DELETE_ALL);
			int cnt = stmt.executeUpdate();
			conn.commit();
			
			System.out.println(cnt + " 삭제함");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		finally{
			
			JdbcUtil.close(null, stmt, conn);
		}
		
	}
}
