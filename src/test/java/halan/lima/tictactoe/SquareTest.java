package halan.lima.tictactoe;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javafx.application.Application;

public class SquareTest {

	static Square square;

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
		square = new Square("X", "O", "Y");
	}

	@Test
	public void testMarking() {
		Assert.assertTrue(square.getText().equalsIgnoreCase(" "));
		Assert.assertTrue(square.getPlayerMark() == 0);
		square.markByPlayer(1);
		Assert.assertTrue(square.getText().equalsIgnoreCase("X"));
		Assert.assertTrue(square.getPlayerMark() == 1);
		square.markByPlayer(2);
		Assert.assertTrue(square.getText().equalsIgnoreCase("O"));
		Assert.assertTrue(square.getPlayerMark() == 2);
		square.markByPlayer(3);
		Assert.assertTrue(square.getText().equalsIgnoreCase("Y"));
		Assert.assertTrue(square.getPlayerMark() == 3);
	}

}
