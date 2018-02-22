package halan.lima.tictactoe;

import java.util.List;

public class ComputerPlayer {

	public Square mark(List<SquareLine> squareLines, Square[][] squares) {
		for (SquareLine sl : squareLines) {
			String lineMarks = sl.getPlayerMarks();
			if (lineMarks.toLowerCase().chars().filter(e -> e == '3').count() == 2 && lineMarks.contains("0")) {
				return sl.getSquareArray()[lineMarks.indexOf("0")];
			}
		}
		for (SquareLine sl : squareLines) {
			String lineMarks = sl.getPlayerMarks();
			if ((lineMarks.toLowerCase().chars().filter(e -> e == '1').count() == 2
					|| lineMarks.toLowerCase().chars().filter(e -> e == '2').count() == 2) && lineMarks.contains("0")) {
				return sl.getSquareArray()[lineMarks.indexOf("0")];
			}
		}

		for (SquareLine sl : squareLines) {
			String lineMarks = sl.getPlayerMarks();
			if (lineMarks.toLowerCase().chars().filter(e -> e == '3').count() == 1 && lineMarks.toLowerCase().chars().filter(e -> e == '0').count() == 2) {
				if(lineMarks.indexOf("3") == 2) {
					return sl.getSquareArray()[1];
				}
				return sl.getSquareArray()[lineMarks.indexOf("0")];
			}
		}

		int midSquare = squares.length / 2;
		if (squares[midSquare][midSquare].getPlayerMark() == 0) {
			return squares[midSquare][midSquare];
		} else if(squares[midSquare-1][midSquare-1].getPlayerMark() == 0) {
			return squares[midSquare-1][midSquare-1];
		} else if(squares[midSquare][midSquare-1].getPlayerMark() == 0) {
			return squares[midSquare][midSquare-1];
		} else if(squares[midSquare-1][midSquare].getPlayerMark() == 0) {
			return squares[midSquare-1][midSquare];
		}

		for (SquareLine sl : squareLines) {
			String lineMarks = sl.getPlayerMarks();
			if (lineMarks.contains("0")) {
				return sl.getSquareArray()[lineMarks.indexOf("0")];
			}
		}

		// ERROR, will never reach
		return null;
	}

}
