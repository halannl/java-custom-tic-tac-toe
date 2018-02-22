package halan.lima.tictactoe;

import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;

/**
 * @author halan.lima <halannl85@gmail.com>
 */
public class GameBoard extends GridPane {

	int numOfSquares;
	int squaresToWin = 3;
	Square[][] squares;
	private List<SquareLine> squareLines;

	/**
	 * Initialize the board with its size
	 * @param boardSize
	 */
	public GameBoard(int boardSize) {
		this.numOfSquares = boardSize;
		squares = new Square[numOfSquares][numOfSquares];
		build(boardSize);
	}

	/**
	 * Build the board with respectives squares
	 * @param boardSize
	 */
	public void build(int boardSize) {
		for (int i = 0; i < numOfSquares; i++) {
			for (int j = 0; j < numOfSquares; j++) {
				Square btn = new Square(App.P1CHAR, App.P2CHAR, App.P3CHAR);
				add(btn, i, j);
				setFillHeight(btn, true);
				setFillWidth(btn, true);
				squares[i][j] = btn;
			}
		}
		initializeSquareLines();
	}

	/**
	 * Return true if the board is full
	 * @return
	 */
	public boolean isFull() {
		for (int i = 0; i < numOfSquares; i++) {
			for (int j = 0; j < numOfSquares; j++) {
				if (squares[i][j].getPlayerMark() == 0)
					return false;
			}
		}
		return true;
	}

	/**
	 * List all possible squares combination for winning
	 * @return
	 */
	public List<SquareLine> getSquareLines() {
		return squareLines;
	}

	/**
	 * Get all squares matrix
	 * @return
	 */
	public Square[][] getSquares() {
		return squares;
	}

	/**
	 * Initialize all square lines (combinations)
	 */
	private void initializeSquareLines() {
		List<SquareLine> lines = new ArrayList<>();

		// Build all possible lines of squares
		for(int i = 0 ; i < numOfSquares ; i++) {
			for(int j = 0 ; j < numOfSquares ; j++) {
				addLine(lines, i, j);
			}
			
		}
		squareLines = lines;
	}
	
	/**
	 * Iterate over the squares matrix to provide the square lines
	 * @param lines
	 * @param x
	 * @param y
	 */
	private void addLine(List<SquareLine> lines, int x, int y) {
		if(x + squaresToWin <= numOfSquares) {
			lines.add(new SquareLine(buildLineHorizontal(x,y)));
			if(y + squaresToWin <= numOfSquares) {
				lines.add(new SquareLine(buildLineDiagonal(x,y)));
			}
			if(y - (squaresToWin - 1) >= 0) {
				lines.add(new SquareLine(buildLineDiagonalInverse(x,y)));
			}
		}
		if(y + squaresToWin <= numOfSquares) {
			lines.add(new SquareLine(buildLineVertical(x,y)));
		}
	}
	
	private Square[] buildLineHorizontal(int x, int y) {
		Square[] squaresLineHorizontal = new Square[squaresToWin];
		int count = 0;
		for(int i = x ; i < squaresToWin + x ; i++) {
			squaresLineHorizontal[count] = squares[i][y];
			count++;
		}
		return squaresLineHorizontal;
	}
	
	private Square[] buildLineVertical(int x, int y) {
		Square[] squaresLineHorizontal = new Square[squaresToWin];
		int count = 0;
		for(int j = y ; j < squaresToWin + y ; j++) {
			squaresLineHorizontal[count] = squares[x][j];
			count++;
		}
		return squaresLineHorizontal;
	}
	
	private Square[] buildLineDiagonal(int x, int y) {
		Square[] squaresLineHorizontal = new Square[squaresToWin];
		int count = 0;
		int i = x;
		int j = y;
		while(i < squaresToWin + x && j < squaresToWin + y) {
			squaresLineHorizontal[count] = squares[i][j];
			count++;
			i++;
			j++;
		}
		return squaresLineHorizontal;
	}
	
	private Square[] buildLineDiagonalInverse(int x, int y) {
		Square[] squaresLineHorizontal = new Square[squaresToWin];
		int count = 0;
		int i = x;
		int j = y;
		while(i < squaresToWin + x && j >= y - (squaresToWin - 1)) {
			squaresLineHorizontal[count] = squares[i][j];
			count++;
			i++;
			j--;
		}
		return squaresLineHorizontal;
	}

}
