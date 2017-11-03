package com.connectfour;

public class Game {

	public static void main(String[] args) {
		Board board = new Board(7, 7, new Player("Player1", "O"), new Player("Player2", "X"));
		BoardViewer viewer = new BoardViewer();
		Judge judge = new Judge();
		viewer.printBoard(board);
		
		while (judge.checkWin(board) == null) {
			viewer.getInput(board);
			viewer.printBoard(board);
		}
		
		System.out.println(judge.checkWin(board).getName() + " wins!");
	}
}
