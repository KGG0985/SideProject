package jyhomeworkMybatis;

import java.util.List;

public interface BoardDAO {

	public List<BoardVO> printBoard();
		// 전체 목록 출력
	
	public int writeBoard(BoardVO bv);
		// 새글 작성
	
	public int updateBoard(BoardVO bv);
		// 수정
	public int deleteBoard(String no);
		//삭제
	public List<BoardVO> searchBoard(BoardVO bv);
		//검색
	public boolean checkNO(String no);
		// 중복 체크
	
}	