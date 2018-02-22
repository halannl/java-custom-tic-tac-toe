package halan.lima.tictactoe;

/**
 * @author halan.lima <halannl85@gmail.com>
 */
public class SquareLine {
	Square[] squares;

	public SquareLine(Square[] squares) {
		this.squares = squares;
	}

	/**
	 * Get the String with the sequence of marks of the squares for this line
	 * @return
	 */
	public String getPlayerMarks() {
		String line = "";
		for (int i = 0; i < squares.length; i++) {
			line += squares[i].getPlayerMark();
		}
		return line;
	}
	
	/**
	 * Get the array of the squares in this line
	 * @return
	 */
	public Square[] getSquareArray() {
		return this.squares;
	}

	/**
	 * Highlights the squares of the entire line
	 */
	public void highlight() {
		for (int i = 0; i < squares.length; i++) {
			squares[i].highlight();
		}
	}
}
