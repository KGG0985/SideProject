package kr.or.study.service;

import java.util.List;

import kr.or.study.dao.MemberDAO;
import kr.or.study.dao.MemberDAOIm;
import kr.or.study.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
		
	private MemberDAO memDao;
	private static MemberService memSercive;
	private MemberServiceImpl() {
		memDao = MemberDAOIm.getInstance();
	}
	
	public static MemberService getInstance() {
		if (memSercive == null) {
			memSercive = new MemberServiceImpl();
		}
		return memSercive;
		
	}
		

	@Override
	public int login(MemberVO mv) {
		int cnt = memDao.login(mv);
		return cnt;
	}

	@Override
	public List<MemberVO> printMember() {
		List<MemberVO> memList  = memDao.printMember();
		return memList;
	}

	@Override
	public int insertMember(MemberVO mv) {
		int cnt = memDao.insertMember(mv);
		return cnt;
	}

	@Override
	public int updateMember(MemberVO mv) {
		int cnt = memDao.updateMember(mv);
		return cnt;
	}

	@Override
	public int deleteMember(String id) {
		int cnt = memDao.delectMember(id);
		return cnt;
	}

	@Override
	public List<MemberVO> searchMember(MemberVO bv) {
		List<MemberVO> memList  = memDao.searchMember(bv);
		return memList;
	}

	@Override
	public boolean checkMember(String id) {
		boolean isExist = memDao.checkMember(id);
		return isExist;
	}
	
}
