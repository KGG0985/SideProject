package kr.or.study.dao;

import java.util.List;

import kr.or.study.vo.BoardVO;


public interface BoardDAO {

	public int insertBoard(BoardVO bv);
	
	public int updateBoard(BoardVO bv);
	
	public int deleteBoard(int boardNo);

	public List<BoardVO> getAllBoardList();
	
	public boolean checkBoard(int boardNo);

	public List<BoardVO> searchBoard(BoardVO bv);

}