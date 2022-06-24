package kr.or.study.controller;

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
	
	public static MemberVO mv; // 멤버VO를 static으로 선언해서 id값을 유지하도록!
	
	
	// 로그인 메뉴 실행 후, 로그인 되면 displayMenu가 되는 것 !
	
	
	public void loginMenu(){
		displayPostAll();
		
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
		}while(choice != 3);
	}
	
	
	private void loginMember() {
		// TODO Auto-generated method stub
		
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
				default :
					System.out.println("번호를 잘못 입력했습니다. 다시입력하세요");
			}
		}while(choice != 6);
	}

	private void searchPost() {
		// TODO Auto-generated method stub
		
	}

	private void displayPostAll() {
		// TODO Auto-generated method stub
		
	}

	private void updatePost() {
		// TODO Auto-generated method stub
		
	}

	private void deletePost() {
		// TODO Auto-generated method stub
		
	}

	private void insertPost() {
		// TODO Auto-generated method stub
		
	}
	
		
	public static void main(String[] args) {
		BoardInfoMain_testJY bodObj = new BoardInfoMain_testJY();
		bodObj.loginStart();
		bodObj.start();
	}
	
}
