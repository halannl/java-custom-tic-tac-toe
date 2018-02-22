package halan.lima.tictactoe;

import java.util.List;
import java.util.Random;

/**
 * @author halan.lima <halannl85@gmail.com>
 */
public class Game {
	private static Game instance = null;

	enum State {
		READY, START, OVER
	}

	public Game.State gameState = State.READY;

	private int currentPlayer;
	private GameBoard board;
	private GameStatus status;
	private GameControls controls;
	private ComputerPlayer computer;

	protected Game() {

	}

	public static Game getInstance() {
		if (instance == null) {
			instance = new Game();
		}
		return instance;
	}

	public void initialize(GameBoard board, GameStatus status, GameControls controls, ComputerPlayer computer) {
		this.board = board;
		this.status = status;
		this.controls = controls;
		this.computer = computer;
		ready();
	}

	private void setState(Game.State state) {
		switch (state) {
		case START:
			status.setGameStatus("The player " + currentPlayer + " has to play!");
			controls.setState(GameControls.State.PLAYING);
			if(currentPlayer == 3) {
				controls.setState(GameControls.State.WAIT);
				selectSquare(computer.mark(board.getSquareLines(), board.getSquares()));
			}
			break;
		case OVER:
			status.setGameStatus("Game over!");
			controls.setState(GameControls.State.PLAYING);
			break;
		case READY:
			status.setGameStatus("Press start to play!");
			controls.setState(GameControls.State.WAIT);
			break;
		default:
			break;
		}
	}

	private void ready() {
		setState(State.READY);
		gameState = State.READY;
		controls.setState(GameControls.State.WAIT);
		Random r = new Random();
		currentPlayer = r.ints(1, 1, 4).findFirst().getAsInt();
	}

	public void start() {
		if (gameState != State.START) {
			gameState = State.START;
			setState(State.START);
		} else {
			status.setWarning("Already started!");
		}
	}

	public void end(int winner) {
		setState(State.OVER);
		gameState = State.OVER;
		if (winner == 0) {
			status.setWarning("It's a draw!");
		} else {
			status.setWarning("The player " + winner + " wins!");
			gameState = State.READY;
		}
	}

	public void selectSquare(Square square) {
		if (gameState == State.START) {
			if (square.getPlayerMark() == 0) {
				square.markByPlayer(currentPlayer);
				int winner = findWinner();
				if (winner != 0) {
					end(winner);
				} else if (isOver()) {
					end(0);
				} else {
					next();
				}
			} else {
				status.setWarning("The square is already full!");
			}
		} else {
			if (gameState == State.OVER) {
				status.setWarning("Please reset and start a new game.");
			} else {
				status.setWarning("The game is not started!");
			}
		}
	}

	public int findWinner() {
		List<SquareLine> lines = board.getSquareLines();

		for (SquareLine squareLine : lines) {
			String string = squareLine.getPlayerMarks();
			if (string.contains("111")) {
				squareLine.highlight();
				return 1;
			} else if (string.contains("222")) {
				squareLine.highlight();
				return 2;
			} else if (string.contains("333")) {
				squareLine.highlight();
				return 3;
			}
		}

		return 0;
	}

	public boolean isOver() {
		return board.isFull();
	}

	public void next() {
		if (currentPlayer == 1)
			currentPlayer = 2;
		else if (currentPlayer == 2) {
			currentPlayer = 3;
		} else
			currentPlayer = 1;
		setState(State.START);
	}

	public void reset() {
		int numOfSquares = board.numOfSquares;
		Square[][] squares = board.squares;

		for (int i = 0; i < numOfSquares; i++) {
			for (int j = 0; j < numOfSquares; j++) {
				squares[i][j].reset();
			}
		}

		ready();
	}
}
