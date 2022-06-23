package kr.or.study.service;

import java.util.List;

import kr.or.study.dao.BoardDAO;
import kr.or.study.vo.BoardVO;

public class BoardServiceImpl implements IBoardService {
	
	private BoardDAO boardDao;

	
	@Override
	public List<BoardVO> getAllBoardList() {
		
		List<BoardVO> boardList = boardDao.getAllBoardList();	

		
		return boardList;
	}


	public static IBoardService getInstance() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
