package kr.or.study.dao;
import java.util.List;

import kr.or.study.vo.CommentVO;

public interface CommentDAO {
	
	public List<CommentVO> getCommentAll(CommentVO cv);
	
	public int writeComment(CommentVO cv);
	
	public int updateComment(CommentVO cv);
	
	public int deleteComment(String comNo);
	
	public boolean checkComment(String comNo);
}
