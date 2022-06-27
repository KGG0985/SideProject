package kr.or.study.controller;

import java.util.List;
import java.util.Scanner;

import kr.or.study.service.MemberService;
import kr.or.study.service.MemberServiceImpl;
import kr.or.study.vo.MemberVO;

public class BoardInfoMain_testJY {
	
	private Scanner scan = new Scanner(System.in);
	
	private MemberService memService;
	
	public BoardInfoMain_testJY() {
		memService = MemberServiceImpl.getInstance();		
	}	
	
	
	public static String loginMemID = null;
	public static String loginMemPasssword = null; // 보안 문제
	
		
	// 로그인 메뉴 실행 후, 로그인 되면 displayMenu가 되는 것 !
	
	
	public void loginMenu(){
			
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
		do{
			loginMenu(); //메뉴 출력
			choice = scan.nextInt(); // 메뉴번호 입력받기
			switch(choice){
				case 1 :  // 로그인
					loginMember();
					break;
				case 2 :  // 회원 가입
					insertMember();
					break;
				case 3 :  // 종료
					System.out.println("종료합니다");
					break;				
				default :
					System.out.println("번호를 잘못 입력했습니다. 다시입력하세요");
			}
		} while(choice != 3 && loginMemID==null);
	}
	
	
	private void loginMember() {
		boolean isExist = false;
		String memId ="";
		String memPassword="";
		
		
		// 아이디 체크
		do {
			System.out.println("==로그인==");
			System.out.print("아이디 : ");
			memId = scan.next();
			
			isExist = checkMember(memId);
			
			if(!isExist) {
				System.out.println("존재하지 않는 아이디 입니다");
			}
			
			} while(!isExist);
		
		
		// 비밀번호 체크

		while(true) {
			
		
			System.out.print("비밀번호 : ");
			memPassword = scan.next();
			
			MemberVO mv = new MemberVO();
			
			mv.setMemId(memId);
			mv.setMemPassword(memPassword);
			
			int cnt = memService.login(mv);
			
			if(cnt>0) {
				System.out.println("로그인 성공");
				loginMemID = memId;
				loginMemPasssword = memPassword;
				
				start();
					
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
		if(isExist) {
			System.out.println("이미 존재하는 아이디 입니다. 다시 입력해주세요 ");
		}
				
		} while(isExist);
		
		
		System.out.print("비밀번호 : ");
		String memPassword = scan.next();
		System.out.print("이름 : ");
		String memName = scan.next();
		
		MemberVO mv = new MemberVO();

		mv.setMemId(memId);
		mv.setMemPassword(memPassword);
		mv.setMemName(memName);
		
		int cnt = memService.insertMember(mv);
		
		if(cnt>0) {
			System.out.println(mv.getMemId()+"회원 가입 성공");
			
		} else {
			System.out.println("회원 가입 실패");
		}
		
	}


	private boolean checkMember(String memId) {
		boolean isExist = memService.checkMember(memId);		
		return isExist;
	}
	
	

	public void displayMenu(){
		displayPostAll();
		
		System.out.println();
		System.out.println("----------------------");
		System.out.println("  === 작 업 선 택 ===");
		System.out.println("  1. 게시판 작성");
		System.out.println("  2. 게시판 삭제");
		System.out.println("  3. 게시판 수정");
		System.out.println("  4. 게시판 출력");
		System.out.println("  5. 게시판 검색");
		System.out.println("  6. 작업 끝.");
		System.out.println("  7. 마이 메뉴.");
		System.out.println("----------------------");
		System.out.print("원하는 작업 선택 >> ");
	}
	public void start(){
		
		
		int choice = 0;
		do{
			displayMenu(); //메뉴 출력
			choice = scan.nextInt(); // 메뉴번호 입력받기
			switch(choice){
				case 1 :  // 자료 입력
					insertPost();
					break;
				case 2 :  // 자료 삭제
					deletePost();
					break;
				case 3 :  // 자료 수정
					updatePost();
					break;
				case 4 :  // 전체 자료 출력
					displayPostAll();
					break;
				case 5 :  // 회원정보 검색
					searchPost();
					break;
				case 6 :  // 작업 끝
					System.out.println("작업을 마칩니다.");
					break;
				case 7 :  // 마이 메뉴
					mymenu();
					break;
				default :
					System.out.println("번호를 잘못 입력했습니다. 다시입력하세요");
			}
		}while(choice != 6);
	}

	private void mymenu() {
		
		
		System.out.println("  === 로 그 인 화 면 ===");
		System.out.println("  1. 회원 정보 보기");
		System.out.println("  2. 회원 정보 수정");
		System.out.println("  3. 회원 탈퇴");
		System.out.println("  4. 종료");
		System.out.println("----------------------");
		
		
		int choice = 0;		
		do{
		
			choice = scan.nextInt(); // 메뉴번호 입력받기
			switch(choice){
				case 1 :  // 나의 회원 정보보기
					serchMember();
					break;
				case 2 :  // 회원 정보 수정
					updateMember();
					break;
				case 3 :  // 회원 탈퇴
					delectMember();
					break;
				case 4 :  // 종료
					System.out.println("종료합니다");
					break;
				default :
					System.out.println("번호를 잘못 입력했습니다. 다시입력하세요");
			}
		}while(choice != 4);
		
	}
	

	private void delectMember() {
		
	System.out.println(loginMemID + "님 회원 탈퇴를 하시겠습니까?");	
	System.out.print("네 / 아니요");
	String msg = scan.next();
	
	if(msg.equals("네")){
		MemberVO mv = new MemberVO();
		mv.setMemId(loginMemID);	
		
		int cnt = memService.deleteMember(loginMemID);
		
		if(cnt > 0) {
			System.out.println(loginMemID + "회원 탈퇴 성공.");
			loginStart();
			
		}else {
			System.out.println(loginMemID + "회원 탈퇴 실패!!!");
		}
	}
			
	
	}

	private void updateMember() {
				
	}

	private void serchMember() {
		
	MemberVO mv = new MemberVO();
	mv.setMemId(loginMemID);
	
	List<MemberVO> memList = memService.searchMember(mv);
	
	
	for(MemberVO mv2 : memList) {
		System.out.println("아이디 : " + mv2.getMemId() + "이름 : " + mv2.getMemName() + " 가입일 : " + mv2.getMemJoinDate());
	}
	
	
	}	
	
	private void searchPost() {
	}

	private void displayPostAll() {	
	}

	private void updatePost() {
	}

	private void deletePost() {
	}

	private void insertPost() {
	}
	
		
	public static void main(String[] args) {
		BoardInfoMain_testJY bodObj = new BoardInfoMain_testJY();
		bodObj.loginStart();
	
	}
	
}
