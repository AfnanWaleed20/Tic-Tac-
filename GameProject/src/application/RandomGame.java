package application;

import java.util.Random;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class RandomGame {
	int scorePlayer1 = 0;
	int scorePlayer2 = 0;
	Stage stag2,stage3;
	TextField text,text2,text3;
	RadioButton btno,btnx;
	Button[][] buttons = new Button[3][3];
	private String firstPlayer;
	Label score2,score3;
	private String computer;
	Random random=new Random();
    private int Player = 1;
    private int computerplayer=2;
    int round=1;
	int myRound;
	TextArea area=new TextArea();
	GridPane gridPane;
	public void Stage2forOnlyPlayer() {
		stag2=new Stage();
		Label namelabel=new Label("player Name:");
		namelabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 18));
	    text=new TextField();
		Label label=new Label("Choose for first Player:");
		label.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 18));
		Label ask=new Label("who's first:");
		Button play1=new Button(text.getText());
		Button play2=new Button("computer");
		btnx=new RadioButton("X");
		btnx.setOnAction(e->{
				play1.setText(text.getText());
				});


		btnx.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 20));
		ToggleGroup tg=new ToggleGroup();
		btnx.setToggleGroup(tg);
		btno = new RadioButton("O");
		btno.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 20));
		btno.setToggleGroup(tg);
		btnx.setOnAction(e -> {
		    play1.setText(text.getText());
		    if (Player == 1) {
		        firstPlayer = "X";
		        computer = "O";
		    } else if (Player == 2) {
		        firstPlayer = "O";
		        computer = "X";
		    }
		});

		btno.setOnAction(e -> {
		    play1.setText(text.getText());
		    if (Player == 1) {
		        firstPlayer = "O";
		        computer = "X";
		    } else if (Player == 2) {
		        firstPlayer = "X";
		        computer = "O";
		    }
		});



		    play1.setMinSize(70, 70);
		    play1.setOnAction(e -> {
		        Player = 1;
		     
		    });

		    play2.setMinSize(70, 70);
		    play2.setOnAction(e -> {
		        Player = 2;
		        makeRandomMove();
		        checkForWinner2();
		    });

		Label ask2=new Label("Number of terms:");
		ask2.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 18));
		ask.setFont(Font.font("Times New Roman", FontWeight.BLACK, FontPosture.REGULAR, 18));
		TextField text3=new TextField();
		String round2=text3.getText();
		HBox hbox1=new HBox(20);
		hbox1.getChildren().addAll(namelabel ,text);
		hbox1.setAlignment(Pos.CENTER);
		HBox hbox3=new HBox(20);
		hbox3.getChildren().addAll(label,btnx,btno);
		HBox hbox4=new HBox(20);
		hbox4.getChildren().addAll(ask2,text3);
		HBox hbox5=new HBox(20);
		hbox5.getChildren().addAll(ask,play1,play2);
		Button btnNext=new Button("Next");
				btnNext.setOnAction(e -> {
					String round3 = " ";
				      round3=text3.getText(); // Move this line here
				        //round = Integer.parseInt(round2);
					if (!round3.isEmpty()) {
				        round = 2;}
				    if (btnx.isSelected() || btno.isSelected()) {
				        if (btnx.isSelected()) {
				            firstPlayer = "X";
				            computer = "O";
				        } else {
				            firstPlayer = "O";
				            computer = "X";
				        }

				        // If the computer starts, make the first move
				        if (Player == 2) {
				            Platform.runLater(() -> {
				                makeRandomMove();
				                checkForWinner2();
				            });
				        }
				    } else {
				        Alert alert = new Alert(Alert.AlertType.WARNING);
				        alert.setTitle("Warning");
				        alert.setHeaderText(null);
				        alert.setContentText("Please select a symbol (X or O) for Player 1");
				        alert.showAndWait();
				    }

		    Stage3OnePlayer();
		});
		
		VBox vbox=new VBox(50);
		hbox3.setAlignment(Pos.CENTER);
		hbox4.setAlignment(Pos.CENTER);
		hbox5.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(hbox1,hbox3,hbox4,hbox5,btnNext);
		vbox.setAlignment(Pos.CENTER);
		Scene scene2 = new Scene(vbox, 800, 800);
		vbox.setStyle("-fx-background: #D8BFD8");
		stag2.setScene(scene2);
		stag2.show();			
	}
	public void Stage3OnePlayer()  {
		stage3=new Stage();
	    Label title=new Label("My Game");
	    area.appendText("Score : \n Player X : 0  \n Player O : 0  ");
	    text.setText("Round " + myRound+" / "+round);
	   area.setPrefWidth(300);
	   area.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 20));
	    gridPane = new GridPane();
	    	title.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 30));
	    	title.setTextFill(Color.WHITE);
	        gridPane.setAlignment(Pos.CENTER);
	        gridPane.setStyle("-fx-background-color: black;");
	        gridPane.setHgap(10);
	        gridPane.setVgap(10);

	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
	                buttons[i][j] = createButton(i, j);
	                gridPane.add(buttons[i][j], j, i);
	                buttons[i][j].setStyle("-fx-background-color: pink");
	            }
	        }
	        if (Player == 2) {
	            Platform.runLater(() -> {
	                makeRandomMove();
	                checkForWinner2();
	            });
	        }
	        VBox vbox2=new VBox(50);
	          HBox hboxplay3=new HBox(30);
	          hboxplay3.setAlignment(Pos.CENTER);
	          Button nextRound=new Button("Next");
	          HBox hboxplay2=new HBox(30);
	          hboxplay2.getChildren().addAll(title , text);
	          hboxplay3.getChildren().addAll(area,nextRound);
	          nextRound.setOnAction(e->{
	        	 myRound++;
	        	 startNewRound();
	        	// myRound++;
	        	
	        	  
	          });
		        VBox vbox1 = new VBox(50);
		        vbox1.setAlignment(Pos.CENTER);
		        vbox1.getChildren().addAll(hboxplay3);
		        vbox1.setAlignment(Pos.CENTER);
		        vbox2.setAlignment(Pos.CENTER);
		        vbox2.getChildren().addAll(hboxplay2,gridPane,hboxplay3);
		        Scene scene = new Scene(vbox2, 800, 800);
		        vbox2.setStyle("-fx-background-color: black;");
		      stage3.setScene(scene);
		      stage3.show();
		    }

	
	private void startNewRound() {
	    if (round >= myRound) {
	        // Increment the round counter
	

	        // Update the text in text and area components
	        text.setText("Round " + myRound + " / " + round);
	        area.appendText("\n\nRound " + myRound + ":\nPlayer X : 0\nPlayer O : 0");

	        // Create a new instance of GridPane
	        GridPane newGridPane = new GridPane();
	        newGridPane.setAlignment(Pos.CENTER);
	        newGridPane.setStyle("-fx-background-color: black;");
	        newGridPane.setHgap(10);
	        newGridPane.setVgap(10);

	        // Initialize the buttons array
	        buttons = new Button[3][3];

	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
	                buttons[i][j] = createButton(i, j);
	                newGridPane.add(buttons[i][j], j, i);
	                buttons[i][j].setStyle("-fx-background-color: pink");
	            }
	        }

	       /* if (btnx.isSelected()) {
	            computer = "O";
	            makeRandomMove();
	        } else {
	            computer = "X";
	            computer = "O";
	        }*/

	        // Add a TextField and a TextArea for the new round
	        TextField newRoundText = new TextField(text.getText()); // Copy text data
	        TextArea newRoundArea = new TextArea(area.getText());    // Copy area data
	        newRoundArea.setPrefWidth(300);
	        newRoundArea.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 20));

	        // Add components to the newGridPane
	        newGridPane.add(newRoundText, 0, 4, 3, 1);
	        newGridPane.add(newRoundArea, 0, 5, 3, 1);

	        // Add a "Next" button
	        Button nextRoundButton = new Button("Next Round");
	        nextRoundButton.setOnAction(e -> startNewRound());
	        if (myRound==round) {
	        	showGameCompleteAlert();
	        }
	        newGridPane.add(nextRoundButton, 1, 6);

	        // Use the updated text components
	        Scene scene4 = new Scene(newGridPane, 800, 800);
	        stage3.setScene(scene4);
	        stage3.show();
	    } else {
	        showGameCompleteAlert();
	    }
	}



	  
	private Button createButton(int row, int col) {
	    Button button = new Button();
	    button.setMinSize(100, 100);
	    button.setOnAction(event -> handleButtonClick(row, col));
	    buttons[row][col] = button;  // Set the button in the array
	    return button;
	}

	private int[][] getCurrentBoardState() {
	    int[][] boardState = new int[3][3];
	    for (int i = 0; i < 3; i++) {
	        for (int j = 0; j < 3; j++) {
	            if (buttons[i][j] == null || buttons[i][j].getText().isEmpty()) {
	                boardState[i][j] = 0;
	            } else if ("X".equals(buttons[i][j].getText())) {
	                boardState[i][j] = 1;
	            } else if ("O".equals(buttons[i][j].getText())) {
	                boardState[i][j] = 2;
	            }
	        }
	    }
	    return boardState;
	}

	 private void handleButtonClick(int row, int col) {
	        Button button = buttons[row][col];

	        if (button.getText().isEmpty() && !isGameOver()) {
	            button.setText(Player == 1 ? "X" : "O");
	            checkForWinner2();

	            // Switch to the other player
	            Player = 3 - Player;

	            // If the current player is 2 (O), make a random move
	            if (!isGameOver() && Player == 2) {
	                makeRandomMove();
	                checkForWinner2();
	            }
	        }
	    }
	 
	 private void makeRandomMove() {
		    Platform.runLater(() -> {
		        int[] move = getRandomMove();
		        if (move != null) {
		            int row = move[0];
		            int col = move[1];
		            if (buttons[row][col] == null) {
		                buttons[row][col] = createButton(row, col);
		            }
		            buttons[row][col].fire();
		        }
		    });
		}

	private int[] getRandomMove() {
	    int[] move = null;
	    int[][] boardState = getCurrentBoardState();

	    while (move == null) {
	        int row = random.nextInt(3);
	        int col = random.nextInt(3);

	        if (boardState[row][col] == 0) {
	            move = new int[]{row, col};
	        }
	    }

	    return move;
	}
	
	 private boolean isGameOver() {
	        return checkForWinner(1) || checkForWinner(2) || isBoardFull();
	    }
	 private boolean checkForWinner(int player) {
	        int[][] boardState = getCurrentBoardState();

	        for (int i = 0; i < 3; i++) {
	            if ((boardState[i][0] == player && boardState[i][1] == player && boardState[i][2] == player) ||
	                (boardState[0][i] == player && boardState[1][i] == player && boardState[2][i] == player)) {
	                return true;
	            }
	        }

	        if ((boardState[0][0] == player && boardState[1][1] == player && boardState[2][2] == player) ||
	            (boardState[0][2] == player && boardState[1][1] == player && boardState[2][0] == player)) {
	            return true;
	        }

	        return false;
	    }

	    private boolean isBoardFull() {
	        int[][] currentBoardState = getCurrentBoardState();
	        for (int i = 0; i < currentBoardState.length; i++) {
	            for (int j = 0; j < currentBoardState[i].length; j++) {
	                if (currentBoardState[i][j] == 0) {
	                    return false;
	                }
	            }
	        }
	        return true;
	    }


		private void Winner(String winner) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText(null);
        alert.setContentText("Player " + winner + " wins!");
        alert.showAndWait();
    }

    
    private void checkForWinner() {
	    if (checkForWinner(1)) {
	        announceWinner("X");
	        Player = 1; // Reset Player to 1
	    } else if (checkForWinner(2)) {
	        announceWinner("O");
	        Player = 1; // Reset Player to 1
	    } else if (isBoardFull()) {
	        announceDraw();
	        Player = 1; // Reset Player to 1
	    }
	}

  

    private void checkForWinner2() {
        if (checkForWinner(1)) {
            announceWinner("X");
        } else if (checkForWinner(2)) {
            announceWinner("O");
        } else if (isBoardFull()) {
            announceDraw();
        }
    }
    private boolean ifWinner() {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (buttons[i][0].getText().equals(buttons[i][1].getText()) &&
                buttons[i][1].getText().equals(buttons[i][2].getText()) &&
                !buttons[i][0].getText().isEmpty()) {
                announceWinner(buttons[i][0].getText());
                highlightWinningButtons(buttons[i][0].getText());
               
                return true;
            }

            if (buttons[0][i].getText().equals(buttons[1][i].getText()) &&
                buttons[1][i].getText().equals(buttons[2][i].getText()) &&
                !buttons[0][i].getText().isEmpty()) {
                announceWinner(buttons[0][i].getText());
                highlightWinningButtons(buttons[0][i].getText());
                return true;
            }
        }

        // Check diagonals
        if (buttons[0][0].getText().equals(buttons[1][1].getText()) &&
            buttons[1][1].getText().equals(buttons[2][2].getText()) &&
            !buttons[0][0].getText().isEmpty()) {
            announceWinner(buttons[0][0].getText());
            highlightWinningButtons(buttons[0][0].getText());
            return true;
        }

        if (buttons[0][2].getText().equals(buttons[1][1].getText()) &&
            buttons[1][1].getText().equals(buttons[2][0].getText()) &&
            !buttons[0][2].getText().isEmpty()) {
            announceWinner(buttons[0][2].getText());
            highlightWinningButtons(buttons[0][2].getText());
            return true;
        }

        boolean isBoardFull = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].getText().isEmpty()) {
                    isBoardFull = false;
                    break;
                }
            }
        }

        if (isBoardFull) {
            announceDraw();
            return true;
        }

        return false;
    }

   
    private void announceWinner(String winner) {
        showResultAlert("Player " + winner + " wins!");
        
        // Update scores
        if (winner.equals("X")) {
        	highlightWinningButtons("X");
            scorePlayer1++;
            area.setText("\t\t\t\tScores:\n Player  ("+text.getText() +" )  : " + scorePlayer1 + "\n Player  ("+computer+" ) : " + scorePlayer2 );

        } else if (winner.equals("O")) {
        	 highlightWinningButtons("O");
            scorePlayer2++;
            area.setText("\t\t\t\tScores:\n Player  ("+text.getText() +" )  : " + scorePlayer1 + "\n Player  ("+computer +" ) : " + scorePlayer2 );
        }

       
    }

  
			   


private void showResultAlert(String result) {
    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Game Result");
    alert.setHeaderText(null);
    alert.setContentText(result);
    alert.showAndWait();
}


private void announceDraw() {
    
    String resultMessage = ("It's a Draw between ");
    showResultAlert(resultMessage);
}


private void highlightWinningButtons(String player) {
    // Check rows
    for (int i = 0; i < 3; i++) {
        if (buttons[i][0].getText().equals(player) && buttons[i][1].getText().equals(player) && buttons[i][2].getText().equals(player)) {
            highlight(buttons[i][0]);
            highlight(buttons[i][1]);
            highlight(buttons[i][2]);
            return;
        }
    }

    // Check columns
    for (int i = 0; i < 3; i++) {
        if (buttons[0][i].getText().equals(player) && buttons[1][i].getText().equals(player) &&buttons[2][i].getText().equals(player)) {
            highlight(buttons[0][i]);
            highlight(buttons[1][i]);
            highlight(buttons[2][i]);
            return;
        }
    }

    // Check diagonals
    if (buttons[0][0].getText().equals(player) && buttons[1][1].getText().equals(player) && buttons[2][2].getText().equals(player)) {
        highlight(buttons[0][0]);
        highlight(buttons[1][1]);
        highlight(buttons[2][2]);
        return;
    }

    if (buttons[0][2].getText().equals(player) && buttons[1][1].getText().equals(player) && buttons[2][0].getText().equals(player)) {
        highlight(buttons[0][2]);
        highlight(buttons[1][1]);
        highlight(buttons[2][0]);
    }
}

private void highlight(Button button) {
    button.setStyle("-fx-background-color: Red;");
}

private void showGameCompleteAlert() {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Game Complete");

    if (scorePlayer1 > scorePlayer2) {
    
        alert.setHeaderText("Player "+ text.getText() + " wins");
    } else if (scorePlayer2 > scorePlayer1) {
        alert.setHeaderText("Player  computer wins");
    } else {
        alert.setHeaderText("It's a Draw between to players");
    }
    
    alert.showAndWait();
    
}}

