package application;
	
import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class Main extends Application {
	Stage stag2,stage3;
	int playerInGame;
	TextField text,text2,text3;
	RadioButton btno,btnx;
	Button[][] buttons = new Button[3][3];
	private String firstPlayer;
	private String secondPlayer;
	int scorePlayer1 = 0;
	int scorePlayer2 = 0;
	Label score2,score3;
	private String computer;
	int round=1;
	int myRound;
	Text text5=new Text();
RandomGame rand=new RandomGame();
TextArea area=new TextArea();
GridPane gridPane ;
MinMaxGame game=new MinMaxGame();
	@Override
	public void start(Stage primaryStage) {
		Label title = new Label("Welcome To Tic Tac Toe Game");
		title.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 25));
		Image image1 = new Image("C:\\Users\\user\\Desktop\\Afnan\\GameProject\\src\\application\\420029077_1093925998625380_3735517072073123019_n.jpg");
		ImageView img = new ImageView(image1);
		img.setFitWidth(500);
		img.setFitHeight(500);
		Label lbl = new Label("way to Gaming:");
		RadioButton btn1=new RadioButton("two Players");
		RadioButton btn2=new RadioButton("one player");
		RadioButton btn3=new RadioButton("unbetable computer");
		lbl.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
		btn1.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 12));
		btn1.setOnAction(e->{
			showStage2();
		});
		btn2.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 12));
		btn2.setOnAction(e->{
			rand.Stage2forOnlyPlayer();
		});
		btn3.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 12));
		btn3.setOnAction(e->{
		game.show3Method();
		});
		HBox hbox1=new HBox(20);
		hbox1.setAlignment(Pos.BASELINE_CENTER);
		hbox1.getChildren().addAll(btn1,btn2,btn3);
		Button btn4 = new Button("Next");
		btn2.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));	    	
		VBox vBox = new VBox(40);
		vBox.getChildren().addAll(title, img, lbl,hbox1 ,btn4);
		vBox.setStyle("-fx-background:ffffad");
		vBox.setAlignment(Pos.CENTER);
		Scene scene1 = new Scene(vBox, 800, 800);
		primaryStage.setScene(scene1);
		primaryStage.show();

	}
	public void showStage2() {
		stag2=new Stage();
		Label namelabel=new Label("player Name:");
		namelabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 18));
	    text=new TextField();
		Label label=new Label("Choose for first Player:");
		label.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 18));
		Label namelabel2=new Label("player Name:");
		namelabel2.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 18));
		namelabel2.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 18));
		text2=new TextField();
		Label ask=new Label("who's first:");
		Button play1=new Button(text.getText());
		Button play2=new Button(text2.getText());
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
		    play2.setText(text2.getText());
		    if (playerInGame == 1) {
		        firstPlayer = "X";
		        secondPlayer = "O";
		    } else if (playerInGame == 2) {
		        firstPlayer = "O";
		        secondPlayer = "X";
		    }
		});

		btno.setOnAction(e -> {
		    play1.setText(text.getText());
		    
		    play2.setText(text2.getText());
		    if (playerInGame == 1) {
		        firstPlayer = "O";
		        secondPlayer = "X";
		    } else if (playerInGame == 2) {
		        firstPlayer = "X";
		        secondPlayer = "O";
		    }
		});


		    play1.setMinSize(70, 70);
		    play1.setOnAction(e -> {
		        playerInGame = 1;
		     
		    });

		    play2.setMinSize(70, 70);
		    play2.setOnAction(e -> {
		        playerInGame = 2;
		        
		    });
		Label ask2=new Label("Number of terms:");
		ask2.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 18));
		ask.setFont(Font.font("Times New Roman", FontWeight.BLACK, FontPosture.REGULAR, 18));
		text3=new TextField();
		//String round2 = text3.getText().trim(); // trim to remove leading/trailing whitespaces
		HBox hbox1=new HBox(20);
		hbox1.getChildren().addAll(namelabel ,text);
		hbox1.setAlignment(Pos.CENTER);
		HBox hbox2=new HBox(20);
		hbox2.getChildren().addAll(namelabel2,text2);
		HBox hbox3=new HBox(20);
		hbox3.getChildren().addAll(label,btnx,btno);
		HBox hbox4=new HBox(20);
		hbox4.getChildren().addAll(ask2,text3);
	
		HBox hbox5=new HBox(20);
		hbox5.getChildren().addAll(ask,play1,play2);
		Button btnNext=new Button("Next");
		btnNext.setOnAction(e -> {
			String round2 = text3.getText().trim();
		    if (!round2.isEmpty()) {
		        round = Integer.parseInt(round2);}
		    if (btnx.isSelected()) {
		        firstPlayer = "X";
		        secondPlayer = "O";
		    } else if (btno.isSelected()) {
		        firstPlayer = "O";
		        secondPlayer = "X";
		    } else {
		        System.out.println("Please select a symbol (X or O) for Player 1");
		        return;
		    }
		    showStage3();
		});
		
		VBox vbox=new VBox(50);
		hbox2.setAlignment(Pos.CENTER);
		hbox3.setAlignment(Pos.CENTER);
		hbox4.setAlignment(Pos.CENTER);
		hbox5.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(hbox1,hbox2,hbox3,hbox4,hbox5,btnNext);
		vbox.setAlignment(Pos.CENTER);
		Scene scene2 = new Scene(vbox, 800, 800);
		vbox.setStyle("-fx-background: #D8BFD8");
		stag2.setScene(scene2);
		stag2.show();		
	}
	public void showStage3() {
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

	   
	private Button createButton(int row, int col) {
	    Button button = new Button();
	    button.setMinSize(100, 100);
	    button.setOnAction(e -> handleButtonClick(row, col));
	    buttons[row][col] = button; // Initialize the array element
	    return button;
	}


	
	private void handleButtonClick(int row, int col) {
        Button button = buttons[row][col];

        if (button.getText().isEmpty()) {
            String symbol = null;

            if (playerInGame == 1) {
                symbol = firstPlayer;
            } else if (playerInGame == 2) {
                symbol = secondPlayer;
            }

            if (symbol != null) {
                button.setText(symbol);
                ifWinner();
                playerInGame = 3 - playerInGame;
            } else {
                System.out.println("Please select a symbol (X or O) for Player " + playerInGame);
            }
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
	            area.setText("\t\t\t\tScores:\n Player  ("+text.getText() +" )  : " + scorePlayer1 + "\n Player  ("+text2.getText() +" ) : " + scorePlayer2 );

	        } else if (winner.equals("O")) {
	        	 highlightWinningButtons("O");
	            scorePlayer2++;
	            area.setText("\t\t\t\tScores:\n Player  ("+text.getText() +" )  : " + scorePlayer1 + "\n Player  ("+text2.getText() +" ) : " + scorePlayer2 );
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
            alert.setHeaderText("Player "+ text2.getText() + " wins");
        } else {
            alert.setHeaderText("It's a Draw between to players");
        }
        
        alert.showAndWait();
        
    }

  
   /* private void startNewRound() {     
        if (round <= myRound) {
        	
        	area.appendText("Score : \n Player X : 0  \n Player O : 0  ");
        	text.setText("Round " + myRound+" / "+round);
        	// gridPane.getChildren().clear();
        	  for (int i = 0; i < 3; i++) {
        	        for (int j = 0; j < 3; j++) {
        	            buttons[i][j] = createButton(i, j);
        	            gridPane.add(buttons[i][j], j, i);
        	            buttons[i][j].setStyle("-fx-background-color: pink");
        	        }
        	    }
            
       
         
        	 
            Scene scene4 = new Scene(gridPane, 800, 800);
            stage3.setScene(scene4);
            stage3.show();
                    } 
        
        else {
        	
            showGameCompleteAlert();
        }
    }*/
   /* private void startNewRound() {
        if (round <= myRound) {
            area.appendText("Score : \n Player X : 0  \n Player O : 0  ");
            text.setText("Round " + myRound + " / " + round);

            // Reset game state
            playerInGame = 1;
            resetButtons();
            resetGridPane();

            Scene scene4 = new Scene(gridPane, 800, 800);
            stage3.setScene(scene4);
            stage3.show();
        } else {
            showGameCompleteAlert();
        }
    }
*/
   

    private void startNewRound() {
        if (myRound < round) {
            area.appendText("Score : \n Player X : 0  \n Player O : 0  ");
            text.setText("Round " + (myRound + 1) + " / " + round);  // Update round display
            playerInGame = 1;  // Reset player to Player 1 for a new round

            // Reset game state
            resetButtons();
            resetGridPane();

            Scene scene4 = new Scene(gridPane, 800, 800);
            stage3.setScene(scene4);
            stage3.show();
            
            myRound++;
        } else {
            showGameCompleteAlert();
        }
    }

    // Remove unnecessary code setting text in showStage3

    // Add a method to reset buttons
    private void resetButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
                buttons[i][j].setStyle("-fx-background-color: pink");
            }
        }
    }

    // Add a method to reset the gridPane
    private void resetGridPane() {
        gridPane.getChildren().clear();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = createButton(i, j);
                gridPane.add(buttons[i][j], j, i);
                buttons[i][j].setStyle("-fx-background-color: pink");
            }}
        }
		public static void main(String[] args) {
		launch(args);
	}
}
