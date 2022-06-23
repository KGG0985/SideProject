package kr.or.study.dao;

import java.util.List;

import kr.or.study.vo.MemberVO;

public interface MemberDAO {
	
	....
	
	public int login(MemberVO mv);
	
	
	public List<MemberVO> printMember();
		// 전체 회원 출력
	
	public int insertMember(MemberVO mv);
		// 회원 추가
	
	public int updateMember(MemberVO mv);
		// 회원정보 수정
	
	public int delectMember(String id);
		// 회원 삭제
	
	public List<MemberVO> searchMember(MemberVO bv);
		// 검색
	
	public boolean checkMember(String id);
		// 중복 체크
	
	
	
}


