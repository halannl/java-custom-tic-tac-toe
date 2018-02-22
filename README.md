# java-custom-tic-tac-toe
A custom Tic Tac Toe game made in java.

This tic tac toe version is made for 3 players, 2 of them are human and another is a computer.
You can choose which symbol each player will use and can set the board size between 3 and 10.

To play the game you must build the project using maven by the commands:

	mvn test compile

Or, if you want to skip tests:

	mvn compile

And then start it with the following command:

	java -cp target/classes halan.lima.tictactoe.App

## The architecture

Java 8, already using the nicest feature that is the lambda expressions.
After researching some other Tic Tac Toe games, I've found that the JavaFX API is the easiest to implement and the visual looks great!
JUnit for testing because I've already experience with the API.
