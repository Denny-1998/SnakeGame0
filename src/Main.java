import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Main extends Application {

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
        Label scoreLabel = new Label("your score is toast");
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

        Food food;
        do {
            boolean win = false;

            //TODO spawn snake

            //main gameLoop
            do {

                //TODO snake.move


                food = new Food(gc, b);
                //TODO snake eat food





               break;
            } while (true);



            food.delete();
            //finish game win/lose
            if (win) {
                Alert alertLost = new Alert(Alert.AlertType.INFORMATION, "You won!");
                alertLost.showAndWait();
            } else {
                Alert alertLost = new Alert(Alert.AlertType.ERROR, "You lost!");
                alertLost.showAndWait();
            }
        } while (true);
    }
}
