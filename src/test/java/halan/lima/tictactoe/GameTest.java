package halan.lima.tictactoe;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javafx.application.Application;

public class GameTest {

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

	@Test
	public void testStart() throws Exception {
		GameStatus gameStatus = new GameStatus();
		Game.getInstance().initialize(new GameBoard(3), gameStatus, new GameControls(), new ComputerPlayer());
		Game game = Game.getInstance();

		game.start();
		Assert.assertTrue(game.gameState == Game.State.START || game.gameState == Game.State.READY);
		Assert.assertTrue(gameStatus.warning.getText().isEmpty());

		game.start();
	}

	@Test
	public void testEnd() throws Exception {
		GameStatus gameStatus = new GameStatus();
		Game.getInstance().initialize(new GameBoard(3), gameStatus, new GameControls(), new ComputerPlayer());
		Game game = Game.getInstance();

		game.end(0);
		Assert.assertTrue(game.gameState == Game.State.OVER);

		game.end(1);
		Assert.assertTrue(game.gameState == Game.State.READY);
	}

}
