package kr.or.study.service;

import java.util.List;

import kr.or.study.dao.CommentDAO;
import kr.or.study.dao.CommentDAOImpl;
import kr.or.study.vo.CommentVO;

public class CommentServiceImpl implements CommentService{
	private CommentDAO comDao;
	
	public CommentServiceImpl() {
		comDao = new CommentDAOImpl();
	}
	
	@Override
	public List<CommentVO> getCommentAll(CommentVO cv) {
		return comDao.getCommentAll(cv);
	}

	@Override
	public int writeComment(CommentVO cv) {
		
		return comDao.writeComment(cv);
	}

}