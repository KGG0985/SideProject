package kr.or.study.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.study.util.MybatisUtil;
import kr.or.study.vo.BoardVO;

public class BoardDAOImpl implements BoardDAO {
	
	private static BoardDAO boardDao;
	private SqlSession sqlSession;
	
	public BoardDAOImpl() {
		sqlSession = MybatisUtil.getInstance();
	}

	@Override
	public int insertBoard(BoardVO bv) {
		
		int cnt = sqlSession.insert("board.insertBoard",bv);
		
		if(cnt > 0) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		
		return cnt;
	}


	@Override
	public int updateBoard(BoardVO bv) {
		
		int cnt = sqlSession.update("board.updateBoard",bv);
		
		if(cnt > 0) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		return cnt;
	}


	@Override
	public int deleteBoard(int boardNo) {
		
		int cnt = sqlSession.delete("board.deleteBoard",boardNo);
		
		if(cnt > 0) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		
		return cnt;
	}

	@Override
	public List<BoardVO> getAllBoardList() {
		
		List<BoardVO> boardList = sqlSession.selectList("board.getBoardAll");
		
		return boardList;
	}

	@Override
	public boolean checkBoard(int boardNo) {
		
		boolean chk = false;
		
		int cnt = (int) sqlSession.selectOne("board.checkBoard",boardNo);
		
		if(cnt > 0) {
			chk = true;
		}
		
		return chk;
	}

	@Override
	public List<BoardVO> searchBoard(BoardVO bv) {
		
		List<BoardVO> boardList = sqlSession.selectList("board.searchBoard",bv);
		
		return boardList;
	}
	

}
