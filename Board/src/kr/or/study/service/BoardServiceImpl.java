package kr.or.study.service;

import java.util.List;

import kr.or.study.dao.BoardDAO;
import kr.or.study.dao.BoardDAOImpl;
import kr.or.study.vo.BoardVO;

public class BoardServiceImpl implements BoardService {
	
	private static BoardServiceImpl boardService;
	private BoardDAO boardDao;

	public BoardServiceImpl() {
		boardDao = new BoardDAOImpl();
	}

	public static BoardService getInstance() {
		if(boardService == null) {
			boardService = new BoardServiceImpl();
		}
		
		return boardService;
	}
	@Override
	public int insertBoard(BoardVO bv) {
		
		int cnt = boardDao.insertBoard(bv);
		
		return cnt;
	}


	@Override
	public int updateBoard(BoardVO bv) {
		
		int cnt = boardDao.updateBoard(bv);
		
		return cnt;
	}

	@Override
	public int deleteBoard(int boardNo) {
		
		int cnt = boardDao.deleteBoard(boardNo);
		
		return cnt;
	}


	@Override
	public boolean checkBoard(int boardNo) {

		boolean chk = boardDao.checkBoard(boardNo);
		
		return chk;
	}


	@Override
	public List<BoardVO> searchBoard(BoardVO bv) {

		List<BoardVO> boardList = boardDao.searchBoard(bv);
		
		return boardList;
	}
	
	@Override
	public List<BoardVO> getAllBoardList() {
		
		List<BoardVO> boardList = boardDao.getAllBoardList();	
		
		
		return boardList;
	}

	@Override
	public List<BoardVO> boardRead(BoardVO bv) {
		List<BoardVO> boardList = boardDao.boardRead(bv);	
		
		
		return boardList;
	}

	@Override
	public String boardHit(BoardVO bv) {
		// TODO Auto-generated method stub
		return null;
	}


}
