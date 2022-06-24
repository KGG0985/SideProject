package kr.or.study.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.study.util.MybatisUtil;
import kr.or.study.vo.MemberVO;

public class MemberDAOIm implements MemberDAO {
	
	
	private static MemberDAO memDao;
	
	private SqlSession sqlSession;
	
	private MemberDAOIm() {
		sqlSession = MybatisUtil.getInstance(); 		
	}
	
	public static MemberDAO getInstance() {
		if (memDao == null) {
			memDao = new MemberDAOIm();
		}
		return memDao;
	}

	
	@Override
	public int login(MemberVO mv) {
		int cnt = sqlSession.insert("member.login", mv);

		if (cnt > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}

		return cnt;
	}
	
	
	@Override
	public List<MemberVO> printMember() {
		List<MemberVO> memList = sqlSession.selectList("member.printMember");
		return memList;
	}

	@Override
	public int insertMember(MemberVO mv) {
		int cnt = sqlSession.insert("member.insertMember", mv);

		if (cnt > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}

		return cnt;
	}

	@Override
	public int updateMember(MemberVO mv) {
		// TODO Auto-generated method stub
		int cnt = sqlSession.update("member.updateMember", mv);

		if (cnt > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}

		return cnt;
	}

	@Override
	public int delectMember(String id) {
		int cnt = sqlSession.delete("member.deleteMember", id);

		if (cnt > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}

		return cnt;
	}

	@Override
	public List<MemberVO> searchMember(MemberVO mv) {
		List<MemberVO> memList = sqlSession.selectList("member.updateMember", mv);


		return memList;
		
	}
		
		

	@Override
	public boolean checkMember(String id) {
		boolean isExist = false;
		
		int cnt = (int) sqlSession.selectOne("member.checkMember", id);

		if(cnt > 0) {
			isExist = true;
		}
		
		
		return isExist;
	}

	
	
	

}
