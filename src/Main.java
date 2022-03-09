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
    static Dir direction = Dir.left;
    static int width = 20;
    static int height = 20;
    static int cornersize = 25;
    //added by mads
    static List<Corner> snake = new ArrayList<>();
    //added by mads
    public enum Dir{
        left,right,up,down;
    }
    //added by mads
    public static class Corner{
        int x;
        int y;

        public Corner(int x, int y){
            this.x = x;
            this.y = y;
        }
    }



    @Override
    public void start(Stage primaryStage) throws Exception {
        //added by mads
        Scene scene = new Scene(uiRoot,width*cornersize,height*cornersize);
        scene.addEventFilter(KeyEvent.KEY_PRESSED, key->{
            if(key.getCode()== KeyCode.W){
                direction = Dir.up;
            }
            if(key.getCode()== KeyCode.A){
                direction = Dir.left;
            }
            if(key.getCode()== KeyCode.D){
                direction = Dir.right;
            }
            if(key.getCode()== KeyCode.S){
                direction = Dir.down;
            }

        });
        //added by mads
        snake.add(new Corner(width/2,height/2));
        snake.add(new Corner(width/2,height/2));
        snake.add(new Corner(width/2,height/2));
        switch (direction){
            case up:
                snake.get(0).y--;
                if (snake.get(0).y<0){
                    gameOver = true;
                }
                break;
            case down:
                snake.get(0).y++;
                if (snake.get(0).y>height){
                    gameOver = true;
                }
                break;
            case left:
                snake.get(0).x--;
                if (snake.get(0).x<0){
                    gameOver = true;
                }
                break;
            case right:
                snake.get(0).x++;
                if (snake.get(0).x>width){
                    gameOver = true;
                }
                break;
        }
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

        game(b, gc);
    }

    public void game(Board b, GraphicsContext gc) {

        do {
            boolean win = false;
            int scoreCount = 0;


            Snake snake = new Snake(b, gc);
            Food food = new Food(gc, b);


            //main gameLoop
            do {

                //TODO make snake move

                //if food and snake are in the same position, increase counter and create new food
                if( Objects.equals(food.getPos(), snake.getPos()) ){
                    scoreCount++;
                    scoreLabel.setText("Your score is: " + scoreCount);
                    food.delete();
                    food = new Food(gc, b);
                }

                if (true){
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
