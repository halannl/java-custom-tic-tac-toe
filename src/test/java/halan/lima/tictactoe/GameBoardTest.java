package halan.lima.tictactoe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javafx.application.Application;

public class GameBoardTest {

	Game game;
	GameBoard board;
	int boardSize = 3;

	@BeforeClass
	public static void initJFX() throws Exception {
		Thread t = new Thread("JavaFX Init Thread") {
			public void run() {
				try {
					Application.launch(App.class, new String[0]);
				} catch (IllegalStateException ise) {
					System.out.println("application already started");
				}
			}
		};
		t.setDaemon(true);
		t.start();
	}

	@Before
	public void prepareSquares() {
		GameStatus gameStatus = new GameStatus();
		GameBoard board = new GameBoard(boardSize);
		Game.getInstance().initialize(board, gameStatus, new GameControls(), new ComputerPlayer());
		Game game = Game.getInstance();

		game.start();
		this.board = board;
		this.game = game;
	}

	@Test
	public void testBoardSize() {
		Assert.assertTrue(boardSize == board.squares.length);
		Assert.assertTrue(boardSize == board.squares[0].length);
	}

	@Test
	public void testFullBoard() {
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				board.squares[i][j].markByPlayer(1);
			}
		}
		Assert.assertTrue(board.isFull());
	}

}
