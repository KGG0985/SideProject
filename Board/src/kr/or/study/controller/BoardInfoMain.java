package kr.or.study.controller;

import java.util.List;
import java.util.Scanner;

import kr.or.study.service.BoardServiceImpl;
import kr.or.study.vo.BoardVO;
import kr.or.study.service.BoardService;


public class BoardInfoMain {
	
	private BoardService boardService;
	
	private Scanner scan = new Scanner(System.in);
	
	public BoardInfoMain() {
		boardService = BoardServiceImpl.getInstance();
	}
	
	
	
	public void displayMenu(){
		
		
		System.out.println();
		System.out.println("----------------------");
		System.out.println("  === 메 뉴 선 택 ===");
		System.out.println("  1. 게시글 작성");
		System.out.println("  2. 게시글 삭제");
		System.out.println("  3. 게시글 수정");
		System.out.println("  4. 게시글 조회");
		System.out.println("  5. 게시글 검색");
		System.out.println("  6. 로그인 화면");
		System.out.println("  7. 종료");
		System.out.println("----------------------");
		System.out.print("원하는 작업 선택 >> ");
	}
	public void start(){
		int choice = 0;
		do{
			displayMenu(); 
			choice = scan.nextInt(); 
			switch(choice){
				case 1 :  
					insertBoard();
					break;
				case 2 :  
					deleteBoard();
					break;
				case 3 :  
					updateBoard();
					break;
				case 4 :  
					displayBoardAll();
					break;
				case 5 :  
					searchBoard();
					break;
				case 6 :  
					new MemberController().mymenu();
					break;
				case 7 :  
					System.out.println("작업을 마칩니다.");
					break;
				default :
					System.out.println("번호를 잘못 입력했습니다. 다시입력하세요");
			}
		}while(choice != 7);
	}

	private void searchBoard() {
		scan.nextLine(); 
		System.out.println();
		System.out.println("검색할 정보를 입력하세요.");
		
		System.out.print("게시판 번호 >> ");
		int boardNo = scan.nextInt();
		
		System.out.print("제목 >> ");
		String boardTitle = scan.nextLine().trim();
		
		System.out.print("작성자 >> ");
		String memidWriter = scan.nextLine().trim();
				
		System.out.print("내용 >> ");
		String boardContent = scan.nextLine().trim();
		
		BoardVO bv = new BoardVO();
		
		bv.setBoardNo(boardNo);
		bv.setBoardTitle(boardTitle);
		bv.setMemidWriter(memidWriter);
		bv.setBoardContent(boardContent);
		
		
		List<BoardVO> boardList = boardService.searchBoard(bv);
		
		System.out.println("-----------------------------------------------------");
		System.out.println(" 번호\t제목\t작성자\t날짜\t\t\t내용");
		System.out.println("-----------------------------------------------------");
		
		if(boardList.size() == 0) {
			System.out.println("검색된 게시글이 없습니다.");
		}else {
			for(BoardVO bv2 : boardList) {
				System.out.println(bv2.getBoardNo() + "\t" + bv2.getBoardTitle() + "\t"
						+ bv2.getMemidWriter() + "\t" + bv2.getBoardDate() + "\t" + bv2.getBoardContent());	
			}
		}
		
		System.out.println("-----------------------------------------------------");
		System.out.println("검색 작업 끝...");
		
	}

	private void displayBoardAll() {
		System.out.println("-----------------------------------------");
		System.out.println(" 번호\t제 목\t작성자\t날짜\t내 용");
		System.out.println("-----------------------------------------");
		
		List<BoardVO> boardList = boardService.getAllBoardList();
		if(boardList.size() == 0) {
			System.out.println("게시글이 없습니다.");
		}else {
			for(BoardVO bv : boardList) {
				System.out.println(bv.getBoardNo() + "\t" + bv.getBoardTitle() + "\t"
						+ bv.getMemidWriter() + "\t" + bv.getBoardDate() + "\t" + bv.getBoardContent());
				
			}
		}
		
		System.out.println("-----------------------------------------");
		System.out.println("조회 작업 끝...");
	}

	private void updateBoard() {
		int boardNo = 0;

		System.out.print("번호 >> ");
		
		boardNo = scan.nextInt();
	
		System.out.print("제목 >> ");
		String boardTitle = scan.next();
		
		System.out.print("작성자 >> ");
		String memidWriter = scan.next();
		
		scan.nextLine(); 
		
		System.out.print("내용 >> ");
		String boardContent = scan.nextLine();
		
		BoardVO bv = new BoardVO();
		
		bv.setBoardNo(boardNo);
		bv.setBoardTitle(boardTitle);
		bv.setMemidWriter(memidWriter);
		bv.setBoardContent(boardContent);
		
		int cnt = boardService.updateBoard(bv);
		
		if(cnt > 0) {
			System.out.println(boardNo + "게시글 수정 성공");
		}else {
			System.out.println(boardNo + "게시글 수정 실패!!!");
		}
		
	}

	private boolean checkBoard(int boardNo) {
		
		boolean chk = boardService.checkBoard(boardNo);
		
		return chk;
	}



	private void deleteBoard() {
		System.out.println();
		System.out.println("삭제할 게시글 번호를 입력하세요.");
		System.out.print("번호 >> ");
		
		int boardNo = scan.nextInt();
		
		int cnt = boardService.deleteBoard(boardNo);
		
		if(cnt > 0) {
			System.out.println(boardNo + "게시글 삭제 성공.");
		}else {
			System.out.println(boardNo + "게시글 삭제 실패!!!");
		}
		
	}

	private void insertBoard() {
		System.out.print("제목 >> ");
		String boardTitle = scan.next();
				
		scan.nextLine(); 
		
		System.out.print("내용 >> ");
		String boardContent = scan.nextLine();
			
		BoardVO bv = new BoardVO();
		bv.setBoardTitle(boardTitle);
		bv.setMemidWriter(MemberController.loginMemID);
		bv.setBoardContent(boardContent);

		
		int cnt = boardService.insertBoard(bv);
		
		if(cnt > 0) {
			System.out.println(bv.getBoardNo() + "게시글 등록 성공");
		}else {
			System.out.println(bv.getBoardNo() + "게시글 등록 실패!!!");
		}		
	}
	
	public static void main(String[] args) {
		BoardInfoMain bodObj = new BoardInfoMain();
		bodObj.start();
	}
	
	
}
