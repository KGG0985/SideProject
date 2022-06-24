package kr.or.study.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.study.vo.BoardVO;

public class BoardDAOImpl implements BoardDAO {
	
	private static BoardDAO boardDao;
	private SqlSession sqlSession;


	@Override
	public List<BoardVO> getAllBoardList() {
		
		List<BoardVO> boardList = sqlSession.selectList("board.getBoardAll");
		
		return boardList;
	}
	

}
