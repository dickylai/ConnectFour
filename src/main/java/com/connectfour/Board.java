package com.connectfour;

import java.util.ArrayList;
import java.util.List;

public class Board {

	private int width;
	private int height;
	private int lastLocation;
	private int playerCounter;
	private Player players[];
	private List<List<Disc>> board;

	public Board(Player player1, Player player2) {
		this(7, 7, player1, player2);
	}
	
	public Board(int width, int height, Player player1, Player player2) {
		this.width = width;
		this.height = height;
		this.lastLocation = 0;
		playerCounter = 0;
		players = new Player[2];
		players[0] = player1;
		players[1] = player2;
		board = new ArrayList<>();
		
		for (int i = 0; i < width; i++) {
			List<Disc> col = new ArrayList<Disc>();
			board.add(col);
		}
	}
	
	public boolean placeDisc(int location) {
		location--;
		if (location >= width || location < 0) return false;
		if (board.get(location).size() < height) {
			board.get(location).add(new Disc(players[playerCounter]));
			playerCounter = (playerCounter+1)%2;
			lastLocation = location + 1;
			return true;
		} else {
			return false;
		}
	}
	
	public List<List<Disc>> getBoard() {
		return board;
	}
	
	public int getLastLocation() {
		return lastLocation;
	}
	
	public Player getLastPlayer() {
		return players[(playerCounter+1)%2];
	}
	
	public Player getCurrentPlayer() {
		return players[playerCounter];
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
}
