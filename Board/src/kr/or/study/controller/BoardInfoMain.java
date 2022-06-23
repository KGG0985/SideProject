package kr.or.study.controller;

import java.util.Scanner;

public class BoardInfoMain {
	private Scanner scan = new Scanner(System.in);
	
	public BoardInfoMain() {
		
		
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
		BoardInfoMain bodObj = new BoardInfoMain();
		bodObj.start();
	}
	
}
