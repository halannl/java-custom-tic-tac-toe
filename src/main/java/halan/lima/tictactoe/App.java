package halan.lima.tictactoe;

import java.io.IOException;
import java.util.Properties;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @author halan.lima <halannl85@gmail.com>
 */
public class App extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	public static String P1CHAR;
	public static String P2CHAR;
	public static String P3CHAR;
	public static int SQUARESIZE;
	public static int FONTSIZE;
	private static int BOARDSIZE;

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Tic Tac Toe - play!");
		Properties prop = new Properties();
		try {
			prop.load(App.class.getClassLoader().getResourceAsStream("app.properties"));

			P1CHAR = prop.getProperty("p1.character");
			P2CHAR = prop.getProperty("p2.character");
			P3CHAR = prop.getProperty("p3.character");
			BOARDSIZE = Integer.valueOf(prop.getProperty("board.size"));

			validateParameters(P1CHAR, P2CHAR, P3CHAR, BOARDSIZE);
			calcSquareSize(BOARDSIZE);

			GameBoard board = new GameBoard(BOARDSIZE);
			GameStatus status = new GameStatus();
			GameControls controls = new GameControls();
			ComputerPlayer computer = new ComputerPlayer();
			Game.getInstance().initialize(board, status, controls, computer);

			HBox topBar = new HBox(10);
			topBar.getChildren().addAll(controls, status);

			BorderPane gameContainer = new BorderPane();
			gameContainer.setTop(topBar);
			gameContainer.setCenter(board);

			primaryStage.setScene(new Scene(gameContainer, 700, 750));
			primaryStage.show();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

	public void validateParameters(String p1Char, String p2Char, String p3Char, int boardSize) throws Exception {
		if (boardSize < 3 || boardSize > 10) {
			throw new Exception("Incorrect board size, should be from 3 to 10!");
		}
		if (p1Char.length() != 1 || p2Char.length() != 1 || p3Char.length() != 1) {
			throw new Exception("Each player should have a single char symbol!");
		}
	}

	private void calcSquareSize(int squaresNumber) {
		SQUARESIZE = 700 / squaresNumber;
		FONTSIZE = SQUARESIZE / 3;
	}
}