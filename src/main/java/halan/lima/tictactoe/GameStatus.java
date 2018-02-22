package halan.lima.tictactoe;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

/**
 * @author halan.lima <halannl85@gmail.com>
 */
public class GameStatus extends VBox {

    Label gameStatus;
    Label warning;
    
    /**
     * Instantiate the game status with messages
     */
    public GameStatus() {
        super(2); // Set spacing
        
        gameStatus = new Label();
        gameStatus.setFont(Font.font("Arial", 20));
        gameStatus.setTextAlignment(TextAlignment.CENTER);
        gameStatus.setTextFill(Color.CADETBLUE);
        
        warning = new Label();
        warning.setFont(Font.font("Arial", 20));
        warning.setTextAlignment(TextAlignment.CENTER);
        warning.setTextFill(Color.RED);

        getChildren().addAll(gameStatus, warning);
    }

    /**
     * Set warning message
     * @param str
     */
    public void setWarning(String str) {
        warning.setText(str);
    }

    /**
     * Set game status message
     * @param str
     */
    public void setGameStatus(String str) {
        gameStatus.setText(str);
        warning.setText("");
    }
}
