package application;

import java.util.Optional;
import java.util.Random;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MinMaxGame {
	StringBuilder builder = new StringBuilder();
	private static final int SIZE = 3;
    private static  String PLAYER_X = "X";   // player
    private static  String PLAYER_O = "O";  // computer 
    private String currentPlayer ;
    private Button[][] buttons = new Button[SIZE][SIZE];  
    private ComboBox<String> startingPlayerComboBox;
    private ComboBox<String> PlayerChr = new ComboBox<>();

    private int roundsToPlay;
    private int currentRound = 1;
    private int scoreForPlayer = 0;
    private int scoreForComputer = 0;
    private Stage primaryStage;
   private TextArea resultTextArea = new TextArea();
    private boolean initialChoiceMade = false;
    private Text text = new Text();
    private TextField name = new TextField();
    private Label Lname = new Label();
    private Label Loption = new Label();
    private VBox option = new VBox (30);
    private Button ok = new Button ("Start");
    int yse = 0 ;
    Stage stage4=new Stage();
	public void show3Method() {
	resultTextArea.setFont(Font.font("Time New Roman" , FontWeight.BOLD , FontPosture.REGULAR ,15));
	text.setFont(Font.font("Time New Roman" , FontWeight.BOLD , FontPosture.REGULAR ,15));
	resultTextArea.setMaxWidth(300);
	resultTextArea.setPrefHeight(300);
    this.primaryStage = primaryStage;
    startingPlayerComboBox = new ComboBox<>();
    startingPlayerComboBox.getItems().addAll("Player", "Computer");
    startingPlayerComboBox.setValue("Player");
    PlayerChr.getItems().addAll("X","O");
    PlayerChr.setValue("X");

	
    GridPane gridPane = createGridPane();
    
    

  
    startingPlayerComboBox.setOnAction(e->{
    	String selectedPlayer = startingPlayerComboBox.getValue();
    	if ("Player".equals(selectedPlayer)) {
    	    currentPlayer = PLAYER_X;
    	} else {
    	    currentPlayer = PLAYER_O;
    	    makeComputerMove();
    	}

    });
    
    PlayerChr.setOnAction(e->{
    	if ("O".equals(PlayerChr.getValue())) {
    		PLAYER_X = "O";
    		PLAYER_O = "X";
    		currentPlayer = "O";
    		
    		
    		
    	}
    });
    
    
    Lname.setText("Enter Your Name: ");
    Lname.setFont(Font.font("Time New Roman", FontWeight.BOLD, FontPosture.ITALIC, 15));

    ok.setOnAction(e -> {
        handleOkButton();
    });


    option.setAlignment(Pos.CENTER);
    option.getChildren().addAll( Lname, name , ok );
    roundsToPlay = askRoundsToPlay();
    
 
    startNewRound();
    
}
private void startNewRound() {     
    if (currentRound <= roundsToPlay) {
    	
    	resultTextArea.appendText("Score : \n Player X : 0  \n Player O : 0  ");
    	text.setText("Round " + currentRound+" / "+roundsToPlay);
    	text.setFill(Color.RED); 
    	
    	//("Round " + currentRound);
        GridPane gridPane = createGridPane();
        
        initializebuttons();
        
        if ("Computer".equals(startingPlayerComboBox.getValue())) {
            currentPlayer = PLAYER_O;
            makeComputerMove();
        }

        Scene scene = new Scene(createLayout(gridPane), 1000, 750);
        stage4.setScene(scene);
        stage4.show();
     
        gridPane.setStyle("-fx-background-color:Black");

    } 
    
    else {
    	
        showGameCompleteAlert();
    }
}


private void initializebuttons() {
   for (int i = 0; i < 3; i++) {
       for (int j = 0; j < 3; j++) {
       	buttons[i][j].setText(""); // Clear the text on buttons
       	buttons[i][j].setStyle("-fx-background-color: pink;");
       	buttons[i][j].setDisable(false); 
       }
   }
   currentPlayer = PLAYER_X;
}


private BorderPane createLayout(GridPane gridPane) {
	 
   BorderPane layout = new BorderPane();
   HBox nameBox = new HBox (20);
   HBox combox = new HBox (20);
  


   nameBox.setAlignment(Pos.CENTER);
   Lname.setText("Player Name");
   Lname.setFont(Font.font("Time New Roman" , FontWeight.BOLD , FontPosture.ITALIC ,15));
   Lname.setTextFill(Color.WHITE); 
   Loption.setText("Start player");
   Loption.setFont(Font.font("Time New Roman" , FontWeight.BOLD , FontPosture.ITALIC ,15));
   Loption.setTextFill(Color.WHITE); 
   startingPlayerComboBox.setPrefWidth(150);
   nameBox.getChildren().addAll(Lname , name , ok);    
   combox.getChildren().addAll(Loption , startingPlayerComboBox , PlayerChr );
   option.setAlignment(Pos.CENTER);
   option.getChildren().addAll(nameBox , combox  );
   //layout.setAlignment(Pos.CENTER);
   
   Button nextRoundButton = new Button("Next Round");
   nextRoundButton.setPrefWidth(100);
   nextRoundButton.setFont(Font.font("Time New Roman" , FontWeight.BOLD  ,20));
   
   Button help = new Button("Help");
   help.setPrefWidth(100);
   help.setStyle("-fx-background-color: #ff0000;"); // Set background color to red
   help.setFont(Font.font("Time New Roman" , FontWeight.BOLD  ,20));
   
   help.setOnAction(e->{
	   resultTextArea.setText(builder.toString());
   });
   
   HBox buttonBox = new HBox(15);
   buttonBox.setAlignment(Pos.CENTER);
   buttonBox.getChildren().addAll(help , nextRoundButton );
   
   
   layout.setStyle("-fx-background-color:Black");
   
   VBox vbox = new VBox(10);
   vbox.setAlignment(Pos.CENTER);
   vbox.getChildren().addAll(text , gridPane, resultTextArea , buttonBox );

   //layout.getChildren().add(vbox);
   layout.setCenter(vbox);
   
   if (yse == 0) {
   	 layout.setLeft(option);
   	 yse++;
   	 
   	 
   }
  
   layout.setPadding(new Insets (5 ,5 ,5 ,5));

 
   nextRoundButton.setOnAction(e -> {
       currentRound++;
       startNewRound();
   });
   
   
   
   return layout;
}



private GridPane createGridPane() {
   GridPane gridPane = new GridPane();
   gridPane.setAlignment(Pos.CENTER);
   gridPane.setHgap(10);
   gridPane.setVgap(10);

   for (int row = 0; row < SIZE; row++) {
       for (int col = 0; col < SIZE; col++) {
           Button button = createButton(row, col);
           buttons[row][col] = button;
           button.setMinSize(100, 100);
           button.setFont(Font.font("Time New Roman", FontWeight.BOLD, 40));
           gridPane.add(button, col, row);
       }
   }

   return gridPane;
}


private Button createButton(int row, int col) {
   Button button = new Button();
   button.setMinSize(100, 100);
   button.setOnAction(event -> onButtonClick(row, col));
   return button;
}

private void onButtonClick(int row, int col) {
   if (buttons[row][col].getText().equals("") && !isGameOver()) {
   	buttons[row][col].setText(currentPlayer);

       if (isGameOver()) {
           announceWinner();
       } else {
           switchPlayer();
           makeComputerMove();
       }
   }
}

private boolean isGameOver() {
   return isWinner(PLAYER_X) || isWinner(PLAYER_O) || isbuttonsFull();
}

private boolean isWinner(String player) {
   // Check rows
   for (int i = 0; i < SIZE; i++) {
       if (buttons[i][0].getText().equals(player) &&  buttons[i][1].getText().equals(player) && buttons[i][2].getText().equals(player)) {
       	
       	
           return true;
       }
   }

   // Check columns
   for (int i = 0; i < SIZE; i++) {
       if (buttons[0][i].getText().equals(player) && buttons[1][i].getText().equals(player) && buttons[2][i].getText().equals(player)) {
       	
          return true;
       }
   }

   // Check diagonals
   if (buttons[0][0].getText().equals(player) && buttons[1][1].getText().equals(player) && buttons[2][2].getText().equals(player)) {
   	       	
       return true;
   }

   if (buttons[0][2].getText().equals(player) && buttons[1][1].getText().equals(player) &&  buttons[2][0].getText().equals(player)) {

       return true;
   }

   return false;
}

private boolean isbuttonsFull() {
   for (int i = 0; i < SIZE; i++) {
       for (int j = 0; j < SIZE; j++) {
           if (buttons[i][j].getText().equals("")) {
               return false;
           }
       }
   }
   return true;
}

private void announceWinner() {
   String winner = currentPlayer.equals(PLAYER_X) ? PLAYER_O : PLAYER_X;
   if (isWinner(winner)) {
       System.out.println("Player " + winner + " wins!");
       
   } else {
       System.out.println("It's a draw!");
   }
}



private void switchPlayer() {
   currentPlayer = (currentPlayer.equals(PLAYER_X)) ? PLAYER_O : PLAYER_X;
}

private void makeComputerMove() {
   if (!isGameOver() && currentPlayer.equals(PLAYER_O)) {
       int[] bestMove = findBestMove();
       buttons[bestMove[0]][bestMove[1]].fire();

       if (isWinner(PLAYER_O)) {
           scoreForComputer++;
           resultTextArea.clear();
	    	resultTextArea.setText("\t\t\t\tScores:\n Player  ("+ name.getText() +" )  : " + scoreForPlayer + "\n\nPlayer  ( Computer ) : " + scoreForComputer+"\n\n");
           highlightWinningButtons(PLAYER_O);

       }
   }
}



private int evaluateMove(int row, int col) {
   if (isGameOver()) {
       if (isWinner(PLAYER_X)) {
           return -1;
       } else if (isWinner(PLAYER_O)) {
           return 1;
       } else {
           return 0;
       }
   }

   int score;
   buttons[row][col].setText(PLAYER_X);
   score = minimaxAlgo( false);
   buttons[row][col].setText("");

   return score;
}

private int[] findBestMove() {
   int[] bestMove = { -1, -1 };
   int bestScore = Integer.MIN_VALUE;

   for (int i = 0; i < SIZE; i++) {
       for (int j = 0; j < SIZE; j++) {
    	   
           if (buttons[i][j].getText().equals("")) {
           	buttons[i][j].setText(PLAYER_O);
               int score = minimaxAlgo(false);
               buttons[i][j].setText("");
            	   String state=" ";
            	   if(score==1) {
            		   state="win";
            	   }
            	   else if (score==-1) {
            		   state="Lose";
            	   }
            	   else {
            		   state="Draw";}
           
               if (score > bestScore) {
            	   state="win";
                   bestScore = score;
                   bestMove[0] = i;
                   bestMove[1] = j;
               }
               builder.append("move"+i+","+j+":" +state+"\n");
           }
       }
   }

   return bestMove;
}

private int minimaxAlgo( boolean isMax) {
   if (isGameOver()) {
       if (isWinner(PLAYER_X)) {
           return -1;
       } else if (isWinner(PLAYER_O)) {
           return 1;
       } else {
           return 0;
       }
   }

   int bestScore;
   if (isMax) {
       bestScore = Integer.MIN_VALUE;
       for (int i = 0; i < SIZE; i++) {
           for (int j = 0; j < SIZE; j++) {
               if (buttons[i][j].getText().equals("")) {
               	buttons[i][j].setText(PLAYER_O);
                   bestScore = Math.max(bestScore, minimaxAlgo( false));
                   buttons[i][j].setText("");
               }
           }
       }
   } else {
       bestScore = Integer.MAX_VALUE;
       for (int i = 0; i < 3; i++) {
           for (int j = 0; j < 3; j++) {
               if (buttons[i][j].getText().equals("")) {
               	buttons[i][j].setText(PLAYER_X);
                   bestScore = Math.min(bestScore, minimaxAlgo( true));
                   buttons[i][j].setText("");
               }
           }
       }
   }

   return bestScore;
}


private int askRoundsToPlay() {
    TextInputDialog dialog = new TextInputDialog();
    dialog.setHeaderText("Dear please Enter the number of Round:");
    dialog.setContentText("Rounds:");

    // Get the DialogPane to apply styling
    DialogPane dialogPane = dialog.getDialogPane();

    // Set font size and style
    dialog.getDialogPane().setStyle("-fx-font-size: 16px; -fx-font-family: 'Arial';");
    dialogPane.setStyle("-fx-font-size: 16; -fx-font-family: 'Arial';");

    Optional<String> result = dialog.showAndWait();
    return result.map(Integer::parseInt).orElse(1);
}


    



private void handleOkButton() {
   if (!name.getText().trim().isEmpty()) {
   	resultTextArea.appendText("\t\t\t\tScores : \nPlayer X ( "+name.getText() +" ): 0  \n\n Player O (Computer) : 0  ");
       option.setVisible(false);
   } else {
       // Show an alert or message indicating that the name is required
       Alert alert = new Alert(Alert.AlertType.WARNING);
       alert.setHeaderText(null);
       alert.setContentText("Please enter your name before starting the game.");
       alert.showAndWait();
   }
}


private void showGameCompleteAlert() {
   Alert alert = new Alert(Alert.AlertType.INFORMATION);
   alert.setTitle("Game Complete");

   if (scoreForPlayer > scoreForComputer) {
       alert.setHeaderText("Player "+ name.getText() + " wins!");
   } else if (scoreForComputer > scoreForPlayer) {
       alert.setHeaderText(" Computer is  wins!");
   } else {
       alert.setHeaderText("It's a draw!");
   }

   alert.setContentText("Scores:\nPlayer "+name.getText() +" : " + scoreForPlayer + "\nPlayer computer : " + scoreForComputer);
   alert.showAndWait();
   primaryStage.close();
}
private void highlightWinningButtons(String player) {
 
   for (int i = 0; i < SIZE; i++) {
       if (buttons[i][0].getText().equals(player) && buttons[i][1].getText().equals(player) && buttons[i][2].getText().equals(player)) {
           highlightButton(buttons[i][0]);
           highlightButton(buttons[i][1]);
           highlightButton(buttons[i][2]);
           return;
       }
   }

   
   for (int i = 0; i < SIZE; i++) {
       if (buttons[0][i].getText().equals(player) && buttons[1][i].getText().equals(player) && buttons[2][i].getText().equals(player)) {
           highlightButton(buttons[0][i]);
           highlightButton(buttons[1][i]);
           highlightButton(buttons[2][i]);
           return;
       }
   }

   
   if (buttons[0][0].getText().equals(player) && buttons[1][1].getText().equals(player) && buttons[2][2].getText().equals(player)) {
       highlightButton(buttons[0][0]);
       highlightButton(buttons[1][1]);
       highlightButton(buttons[2][2]);
       return;
   }

   if (buttons[0][2].getText().equals(player) && buttons[1][1].getText().equals(player) && buttons[2][0].getText().equals(player)) {
       highlightButton(buttons[0][2]);
       highlightButton(buttons[1][1]);
       highlightButton(buttons[2][0]);
   }
}

private void highlightButton(Button button) {
   button.setStyle("-fx-background-color: Red;");
}

}	
	
	
	
	
	