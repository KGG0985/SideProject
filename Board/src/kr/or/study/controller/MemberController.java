package kr.or.study.controller;

import java.util.List;
import java.util.Scanner;

import kr.or.study.service.MemberService;
import kr.or.study.service.MemberServiceImpl;
import kr.or.study.vo.MemberVO;

public class MemberController {

	private Scanner scan = new Scanner(System.in);

	private MemberService memService;

	public MemberController() {
		memService = MemberServiceImpl.getInstance();
	}

	public static String loginMemID = null;
//	public static String loginMemPasssword = null; // 보안 문제

	// 로그인 메뉴 실행 후, 로그인 되면 displayMenu가 되는 것 !

	public void loginMenu() {

		System.out.println();
		System.out.println("----------------------");
		System.out.println("  === 로 그 인 화 면 ===");
		System.out.println("  1. 로그인 하기");
		System.out.println("  2. 회원 가입");
		System.out.println("  3. 종료");
		System.out.println("----------------------");
		System.out.print("원하는 작업 선택 >> ");
	}

	public void loginStart() {
		int choice = 0;
		do {
			loginMenu(); // 메뉴 출력
			choice = scan.nextInt(); // 메뉴번호 입력받기
			switch (choice) {
			case 1: // 로그인
				loginMember();
				break;
			case 2: // 회원 가입
				insertMember();
				break;
			case 3: // 종료
				System.out.println("종료합니다");
				break;
			default:
				System.out.println("번호를 잘못 입력했습니다. 다시입력하세요");
			}
		} while (choice != 3 && loginMemID == null);
	}

	private void loginMember() {
		boolean isExist = false;		
		String memId = "";
		String memPassword = "";

		// 아이디 체크
		do {
			System.out.println("==로그인==");
			System.out.print("아이디 : ");
			memId = scan.next();

			isExist = checkMember(memId);

			if (!isExist) {
				System.out.println("존재하지 않는 아이디 입니다");
			}
			
			else if(memService.checkQuitMember(memId) != null) {
				System.out.println("탈퇴한 회원의 아이디 입니다");
			}

		} while (!isExist);

		// 비밀번호 체크

		while (true) {

			System.out.print("비밀번호 : ");
			memPassword = scan.next();

			MemberVO mv = new MemberVO();

			mv.setMemId(memId);
			mv.setMemPassword(memPassword);

			int cnt = memService.login(mv);

			if (cnt > 0) {
				System.out.println("로그인 성공");
				loginMemID = memId;
//				loginMemPasssword = memPassword;

				new BoardInfoMain().start();

				break;
			} else {
				System.out.println("비밀번호를 확인하세요");
			}

		}

	}

	private void insertMember() {

		boolean isExist = false;
		String memId = "";

		do {
			System.out.println("==회원 가입==");
			System.out.print("아이디 : ");
			memId = scan.next();

			isExist = checkMember(memId);
			if (isExist) {
				System.out.println("이미 존재하는 아이디 입니다. 다시 입력해주세요 ");
			}

		} while (isExist);

		System.out.print("비밀번호 : ");
		String memPassword = scan.next();
		System.out.print("이름 : ");
		String memName = scan.next();

		MemberVO mv = new MemberVO();

		mv.setMemId(memId);
		mv.setMemPassword(memPassword);
		mv.setMemName(memName);

		int cnt = memService.insertMember(mv);

		if (cnt > 0) {
			System.out.println(mv.getMemId() + "회원 가입 성공");

		} else {
			System.out.println("회원 가입 실패");
		}

	}

	private boolean checkMember(String memId) {
		boolean isExist = memService.checkMember(memId);
		return isExist;
	}

	public void mymenu() {

		System.out.println("  === 나 의 정 보  ===");
		System.out.println("  1. 회원 정보 보기");
		System.out.println("  2. 비밀 번호 수정");
		System.out.println("  3. 회원 탈퇴");
		System.out.println("  4. 나의 정보 나가기");
		System.out.println("----------------------");

	}

	public void mymenuStart() {

		int choice = 0;
		do {
			mymenu();

			choice = scan.nextInt(); // 메뉴번호 입력받기
			switch (choice) {
			case 1: // 나의 회원 정보보기
				serchMember();
				break;
			case 2: // 회원 정보 수정
				updateMember();
				break;
			case 3: // 회원 탈퇴
				delectMember();
				break;
			case 4: // 종료
				System.out.println("종료합니다");
				break;
			default:
				System.out.println("번호를 잘못 입력했습니다. 다시입력하세요");
			}
		} while (choice != 4);

	}

	private void delectMember() {

		System.out.println(loginMemID + "님 회원 탈퇴를 하시겠습니까?");

		System.out.print("비밀번호를 다시 한번 입력하세요 : ");
		MemberVO mv = new MemberVO();
		String memPassword = scan.next();

		mv.setMemId(loginMemID);
		mv.setMemPassword(memPassword);

		int cnt = memService.login(mv); // 아이디와 비밀번호 일치 재확인

		if (cnt > 0) {
			System.out.println("회원 정보 일치 ");
			System.out.println(loginMemID + "님 회원 탈퇴를 정말 하시겠습니까?");
			System.out.print("네 / 아니요");
			String msg = scan.next();

			if (msg.equals("네")) {
				cnt = memService.deleteMember(loginMemID);
				// delete할 수 없음 !! 자식 테이블이 있기 때문에 ..
				// member테이블에 회원탈퇴일 생성 필요 ?
				// 회원탈퇴일이 null이 아니면 로그인도 안되게 . .. ?

				if (cnt > 0) {
					System.out.println(loginMemID + "회원 탈퇴 성공.");
					loginMemID = null;
					loginStart();

				} else {
					System.out.println(loginMemID + "회원 탈퇴 실패!!!");

				}
			}

		} else {
			System.out.println("회원 정보 불일치");
			mymenuStart();

		}

	}

	private void updateMember() {

		System.out.println("비밀번호 수정");
		System.out.print("비밀번호를 다시 한번 입력하세요 : ");

		MemberVO mv = new MemberVO();
		String memPassword = scan.next();

		mv.setMemId(loginMemID);
		mv.setMemPassword(memPassword);

		int cnt = memService.login(mv); // 아이디와 비밀번호 일치 재확인

		if (cnt > 0) {
			System.out.print("수정할 비밀번호를 입력하세요 ");
			String newPassword = scan.next();
			mv.setMemPassword(newPassword);
			cnt = memService.updateMember(mv);
			if (cnt > 0) {
				System.out.println("회원 정보 수정 완료");

			} else {
				System.out.println("회원정보 불일치");
			}

		} else {
			System.out.println("회원 정보 불일치");

		}

		mymenuStart();

	}

	private void serchMember() {

		MemberVO mv = new MemberVO();
		mv.setMemId(loginMemID);

		List<MemberVO> memList = memService.searchMember(mv);

		for (MemberVO mv2 : memList) {
			System.out
					.println("아이디 : " + mv2.getMemId() + "이름 : " + mv2.getMemName() + " 가입일 : " + mv2.getMemJoinDate());
		}

	}

	public static void main(String[] args) {
		MemberController bodObj = new MemberController();
		bodObj.loginStart();

	}

}
