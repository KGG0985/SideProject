package kr.or.study.service;

import java.util.List;

import kr.or.study.vo.CommentVO;

public interface CommentService {

	public List<CommentVO> getCommentAll(CommentVO cv);
	
	public int writeComment(CommentVO cv);
	
	public int updateComment(CommentVO cv);
	
	public int deleteComment(String comNo);
	
	public boolean checkComment(String comNo);
}
