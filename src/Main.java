import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Main extends Application {

    private Label scoreLabel;
    //added by mads







    @Override
    public void start(Stage primaryStage) throws Exception {

        //create scene
        Pane uiRoot = new Pane();
        Scene scene = new Scene(uiRoot, 640, 660);

        //create canvas
        javafx.scene.canvas.Canvas canvas = new Canvas(600, 600);
        canvas.setLayoutX(20);
        canvas.setLayoutY(40);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        //score
        scoreLabel = new Label("your score is toast");
        scoreLabel.setLayoutX(30);
        scoreLabel.setLayoutY(10);

        //add all to pane
        uiRoot.getChildren().addAll(canvas, scoreLabel);

        //set up window
        primaryStage.setScene(scene);
        primaryStage.setTitle("Snake Game");
        primaryStage.show();

        Board b = new Board(gc);

        game(b, gc, scene);
    }

    public void game(Board b, GraphicsContext gc, Scene scene) {

        do {
            boolean win = false;
            int scoreCount = 0;


            Snake snake = new Snake(b, gc);
            Food food = new Food(gc, b);


            //main gameLoop
            do {

                snake.move(b, scene);

                //if food and snake are in the same position, increase counter and create new food
                if( Objects.equals(food.getPos(), snake.getPos()) ){
                    scoreCount++;
                    scoreLabel.setText("Your score is: " + scoreCount);
                    food.delete();
                    food = new Food(gc, b);
                }

                //TODO very important: change to something useful
                if (scoreCount == 10){
                    break;
                }

            } while (true);



            food.delete();
            //finish game win/lose
            if (win) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "You won!");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "You lost!");
                alert.showAndWait();
            }
        } while (true);
    }
}
