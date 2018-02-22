package halan.lima.tictactoe;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javafx.application.Application;

public class ComputerPlayerTest {

	static GameBoard board;
	static Thread t;

	@BeforeClass
	public static void initJFX() throws Exception {
		t = new Thread("JavaFX Init Thread") {
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
		GameStatus gameStatus = new GameStatus();
		GameBoard board = new GameBoard(3);
		Game.getInstance().initialize(board, gameStatus, new GameControls(), new ComputerPlayer());
		Game game = Game.getInstance();

		game.start();
		ComputerPlayerTest.board = board;
	}

	@Test
	public void testFirstMove() {
		ComputerPlayer cpu = new ComputerPlayer();
		Square newSquare = new Square("X", "O", "Y");
		Assert.assertTrue(cpu.mark(board.getSquareLines(), board.squares).equals(newSquare));
	}

}
