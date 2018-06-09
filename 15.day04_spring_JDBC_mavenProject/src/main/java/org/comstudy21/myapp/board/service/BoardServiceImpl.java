package org.comstudy21.myapp.board.service;

import java.util.List;

import org.comstudy21.myapp.board.dao.BoardDao;
import org.comstudy21.myapp.board.dao.BoardDaoSpring;
import org.comstudy21.myapp.board.vo.BoardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	@Autowired  //같은 타입의  bean 이 있으면 자동으로 설정해 준다 setter, getter.
	//private BoardDao boardDao;
	private BoardDaoSpring boardDao;
	
	@Override
	public void insertBoard(BoardVo vo) {
		// TODO Auto-generated method stub
		boardDao.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVo vo) {
		// TODO Auto-generated method stub
		boardDao.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVo vo) {
		// TODO Auto-generated method stub
		boardDao.deleteBoard(vo);
	}

	@Override
	public BoardVo getBoard(BoardVo vo) {
		// TODO Auto-generated method stub
		
		return boardDao.getBoard(vo);
	}

	@Override
	public List<BoardVo> getBoardList() {
		// TODO Auto-generated method stub
		
		return boardDao.getBoardList();
	}

	@Override
	public void deleteAllBoard() {
		// TODO Auto-generated method stub
		boardDao.deleteAllBoard();
	}

}
