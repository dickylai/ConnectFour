package com.connectfour;

import java.util.Scanner;

public class BoardViewer {

	Scanner scanner = new Scanner(System.in);

	public void printBoard(Board board) {
		for (int i = board.getHeight(); i > 0; i--) {
			for (int j = 0; j < board.getWidth(); j++) {
				if (board.getBoard().get(j).size() < i) {
					System.out.print(". ");
				} else {
					System.out.print(board.getBoard().get(j).get(i - 1).getPlayer().getAlias() + " ");
				}
			}
			System.out.println();
		}
	}

	public void getInput(Board board) {
		do {
			System.out.print(board.getCurrentPlayer().getName() + " place your disc: ");
		} while (!board.placeDisc(scanner.nextInt()));
	}
}
