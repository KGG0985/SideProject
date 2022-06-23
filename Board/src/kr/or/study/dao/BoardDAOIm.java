package jyhomeworkMybatis;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.util.JDBCUtil3;
import kr.or.ddit.util.MybatisUtil;

public class BoardDAOIm implements BoardDAO {

	private static BoardDAO bodDao; // class의 참조변수를 private static 으로 멤버 변수로 선언.

	private SqlSession sqlSession;

	private BoardDAOIm() { 
		sqlSession = MybatisUtil.getInstance();
	}

	public static BoardDAO getInstance() {
		if (bodDao == null) {
			bodDao = new BoardDAOIm();
		}
		return bodDao;
	}

	@Override
	public int writeBoard(BoardVO bv) {
		int cnt = sqlSession.insert("board.writeBoard", bv);

		if (cnt > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}

		return cnt;
	}

	@Override
	public int updateBoard(BoardVO bv) {

		int cnt = sqlSession.update("board.updateBoard", bv);

		if (cnt > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}

		return cnt;
	}

	@Override
	public int deleteBoard(String no) {
		int cnt = sqlSession.delete("board.deleteBoard", no);

		if (cnt > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}

		return cnt;
	}

	@Override
	public boolean checkNO(String no) {
		boolean isExist = false;
		
		int cnt = (int) sqlSession.selectOne("board.checkNO", no);

		if(cnt > 0) {
			isExist = true;
		}
		
		
		return isExist;
	}

	@Override
	public List<BoardVO> printBoard() {
		List<BoardVO> bodList = sqlSession.selectList("board.printBoard");

		return bodList;
	}

	@Override
	public List<BoardVO> searchBoard(BoardVO bv) {
		List<BoardVO> bodList = sqlSession.selectList("board.searchBoard", bv);


		return bodList;
	}
}
