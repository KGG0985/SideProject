package kr.or.study.service;

import java.util.List;

import kr.or.study.vo.BoardVO;

public interface BoardService {
	
	public List<BoardVO> getAllBoardList();

	public int insertBoard(BoardVO bv);

	public int updateBoard(BoardVO bv);

	public int deleteBoard(int boardNo);
		
	public boolean checkBoard(int boardNo);

	public List<BoardVO> searchBoard(BoardVO bv);
		
}
