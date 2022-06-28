package kr.or.study.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.study.util.MybatisUtil;
import kr.or.study.vo.CommentVO;

public class CommentDAOImpl implements CommentDAO{
	private SqlSession sqlSession;
	private String namespace = "kr.or.study.vo.CommentVO";
	
	public CommentDAOImpl(){
		sqlSession = MybatisUtil.getInstance();
	}
	
	@Override
	public List<CommentVO> getCommentAll(CommentVO cv) {
//		return sqlSession.selectList(namespace +".getCommentAll", cv);
		List<CommentVO> comList = sqlSession.selectList(namespace +".getCommentAll", cv);
		return comList;
	}

	@Override
	public int writeComment(CommentVO cv) {
		int cnt = sqlSession.insert(namespace +".writeComment", cv);
		
		if (cnt > 0) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
			return cnt;
		}

	@Override
	public int updateComment(CommentVO cv) {
		int cnt = sqlSession.update(namespace +".updateComment", cv);
		if (cnt > 0) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		return cnt;
	}

	@Override
	public int deleteComment(String comNo) {
		int cnt = sqlSession.delete(namespace + ".deleteComment",comNo);
		return cnt;
	}

	@Override
	public boolean checkComment(String comNo) {
		boolean isExist = false;
		
		int cnt = (int) sqlSession.selectOne(namespace +".checkComment",comNo);
		
		if (cnt > 0) {
			isExist = true;
		}
		return isExist;
	}
}
