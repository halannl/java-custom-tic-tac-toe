package halan.lima.tictactoe;

/**
 * @author halan.lima <halannl85@gmail.com>
 */
public class SquareLine {
	Square[] squares;

	public SquareLine(Square[] squares) {
		this.squares = squares;
	}

	public String getPlayerMarks() {
		String line = "";
		for (int i = 0; i < squares.length; i++) {
			line += squares[i].getPlayerMark();
		}
		return line;
	}
	
	public Square[] getSquareArray() {
		return this.squares;
	}

	public void highlight() {
		for (int i = 0; i < squares.length; i++) {
			squares[i].highlight();
		}
	}
}
