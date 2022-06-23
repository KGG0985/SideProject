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
		List<CommentVO> comList = sqlSession.selectList(namespace +".getCommentAll");
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

}
