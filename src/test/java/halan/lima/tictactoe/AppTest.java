package halan.lima.tictactoe;

import org.junit.Test;

public class AppTest {

	@Test
	public void testValidationsOk() throws Exception {
		App app = new App();
		app.validateParameters("X", "O", "Y", 7);
	}

	@Test(expected = Exception.class)
	public void testValidationSymbol() throws Exception {
		App app = new App();
		app.validateParameters("XX", "O", "Y", 10);
	}

	@Test(expected = Exception.class)
	public void testValidationBoardBigger() throws Exception {
		App app = new App();
		app.validateParameters("XX", "O", "Y", 11);
	}

	@Test(expected = Exception.class)
	public void testValidationBoardSmaller() throws Exception {
		App app = new App();
		app.validateParameters("XX", "O", "Y", 2);
	}
}
