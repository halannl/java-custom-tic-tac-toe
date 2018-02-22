package halan.lima.tictactoe;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * @author halan.lima <halannl85@gmail.com>
 */
public class Square extends Button {

	private String defaultText = " ";
	private String p1Text = "X";
	private String p2Text = "O";
	private String p3Text = "Y";

	public Square(String p1Text, String p2Text, String p3Text) {
		if (p1Text != null && p2Text != null && p3Text != null) {
			this.p1Text = p1Text;
			this.p2Text = p2Text;
			this.p3Text = p3Text;
		}
		setPrefSize(App.SQUARESIZE, App.SQUARESIZE);
		setFont(Font.font("Arial", App.FONTSIZE));
		setOnAction(event -> Game.getInstance().selectSquare(this));
		reset();
	}

	public void reset() {
		setText(defaultText);
		setTextFill(Color.BLACK);
	}

	public void highlight() {
		setTextFill(Color.RED);
	}

	public void markByPlayer(int player) {
		if (player == 1)
			setText(p1Text);
		else if (player == 2)
			setText(p2Text);
		else
			setText(p3Text);
	}

	public int getPlayerMark() {
		String text = getText();
		if (text.equalsIgnoreCase(p1Text))
			return 1;
		else if (text.equalsIgnoreCase(p2Text))
			return 2;
		else if (text.equalsIgnoreCase(p3Text))
			return 3;
		else
			return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Square other = (Square) obj;
		if (other.getText().equalsIgnoreCase(this.getText())) {
			return true;
		}
		return false;
	}

}
