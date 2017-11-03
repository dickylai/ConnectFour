package com.connectfour;

public class Judge {

	public Player checkWin(Board board) {
		if (board.getLastLocation() == 0) return null;
		
		int count;

		// vertical case
		count = 0;
		for (int i = 0; i < board.getBoard().get(board.getLastLocation() - 1).size(); i++) {
			if (board.getBoard().get(board.getLastLocation() - 1).get(i).getPlayer() == board.getLastPlayer()) {
				count++;
				if (count == 4)
					return board.getLastPlayer();
			} else {
				count = 0;
			}
		}

		// horizontal case
		count = 0;
		int lastRow = board.getBoard().get(board.getLastLocation() - 1).size() - 1;
		for (int i = 0; i < board.getWidth(); i++) {
			if (board.getBoard().get(i).size() > lastRow) {
				if (board.getBoard().get(i).get(lastRow).getPlayer() == board.getLastPlayer()) {
					count++;
					if (count == 4)
						return board.getLastPlayer();
				} else {
					count = 0;
				}
			} else {
				count = 0;
			}
		}

		// diagonals /
		count = 0;
		int i = 0;
		int j = lastRow - (board.getLastLocation() - 1);
		while (i < board.getWidth()) {
			if (board.getBoard().get(i).size() > j && j >= 0) {
				if (board.getBoard().get(i).get(j).getPlayer() == board.getLastPlayer()) {
					count++;
					if (count == 4)
						return board.getLastPlayer();
				} else {
					count = 0;
				}
			} else {
				count = 0;
			}
			i++;
			j++;
		}

		// diagonals \
		count = 0;
		i = board.getWidth() - 1;
		j = lastRow - (board.getWidth() - board.getLastLocation());
		while (i >= 0) {
			if (board.getBoard().get(i).size() > j && j >= 0) {
				if (board.getBoard().get(i).get(j).getPlayer() == board.getLastPlayer()) {
					count++;
					if (count == 4)
						return board.getLastPlayer();
				} else {
					count = 0;
				}
			} else {
				count = 0;
			}
			i--;
			j++;
		}

		return null;
	}
}
