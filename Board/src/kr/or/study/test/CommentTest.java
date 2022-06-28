package kr.or.study.test;

import java.util.List;
import java.util.Scanner;

import kr.or.study.service.CommentService;
import kr.or.study.service.CommentServiceImpl;
import kr.or.study.vo.CommentVO;

public class CommentTest {
	CommentService comService;
	
	private Scanner scan = new Scanner(System.in);
	CommentVO cv = new CommentVO();
	public CommentTest() {
		comService = new CommentServiceImpl();
	
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
		
		CommentVO cv = new CommentVO();
		cv.setBoardCno("1");
		
		List<CommentVO> comList = comService.getCommentAll(cv);
		for (CommentVO bv1 : comList) {
			System.out.println();
			System.out.println("[" + bv1.getComNo()+"번 댓글]");
			System.out.println(" 작성자 : " + bv1.getMemCid() + " | 작성일자 : " + bv1.getComDate());
			System.out.println(" " + bv1.getComContent());
			System.out.println("=================================================");
		}
		System.out.println("출력작업 끝");
	}



	private void updatePost() {
		
		String comNo = "";
		boolean isExist = false;  //  중복 체크용
		
		do {
			System.out.println();
			System.out.println("수정할 회원 정보를 입력하세요.");
			System.out.print("글번호 >> ");
			
			comNo = scan.next();
			
			isExist = checkComment(comNo);
			
			if(!isExist) {
				System.out.println("회원ID가 " + comNo + "인 회원은 "
						+ "존재하지 않습니다.");
				System.out.println("다시 입력해 주세요.");
			}
			
		}while(!isExist);
		
		
		System.out.print("회원 전화번호 >> ");
		String comContent = scan.next();
		
		scan.nextLine(); // 입력버퍼 비우기
		
		cv.setComNo(comNo);
		cv.setComContent(comContent);

		
		int cnt = comService.updateComment(cv);
		
		if(cnt > 0) {
			System.out.println("회원정보 수정 완료.");
		}else {
			System.out.println("회원정보 수정 실패!!!");
		}
	}



	private void deletePost() {
		System.out.println();
		System.out.println("삭제할 회원 정보를 입력하세요.");
		System.out.print("회원 ID >> ");
		
		String comNo = scan.next();
		
		int cnt = comService.deleteComment(comNo);
		
		if(cnt > 0) {
			System.out.println("회원정보 삭제 성공.");
		}else {
			System.out.println("회원정보 삭제 실패!!!");
		}
	}



	private void insertPost() {
		System.out.print("회원 이름 >> ");
		String comContent = scan.next();
		
		
		CommentVO co = new CommentVO();
		
		co.setComContent(comContent);
		co.setBoardCno("1");
		co.setMemCid("asd777");
		
		int cnt = comService.writeComment(co);
		
		if(cnt > 0) {
			System.out.println( "회원정보 등록 성공");
		}else {
			System.out.println( "회원정보 등록 실패!!!");
		}
	}

	private boolean checkComment(String comNo) {
		
		boolean isExist = comService.checkComment(comNo);
		
		return isExist;
	}

	public static void main(String[] args) {
		CommentTest comObj = new CommentTest();
		comObj.start();
	}




}
