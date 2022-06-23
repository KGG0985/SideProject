package kr.or.study.controller;

import java.util.Scanner;

import kr.or.study.service.BoardServiceImpl;
import kr.or.study.service.IBoardService;

public class BoardInfoMain {
	
	private IBoardService boardService;
	
	private Scanner scan = new Scanner(System.in); 
	
	public BoardInfoMain () {
		boardService = BoardServiceImpl.getInstance();
	}
	
	public void displayMenu() {
		System.out.println("  1. 전체목록");

	}
	
	public void start() {
		int choice = 0;
		do {
			displayMenu();
			choice = scan.nextInt();
			switch(choice) {
				case 1 :
					displayBoardAll();
					break;
			}
		}while(choice!=1);
	}

	private void displayBoardAll() {
		System.out.println();
	}
	
	public static void main(String[] args) {
		BoardInfoMain boardObj = new BoardInfoMain();
		boardObj.start();
	}
}
