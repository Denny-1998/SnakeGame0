import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Snake {
    Position pos;
    ArrayList<Position> previousPositions;


    static Dir direction = Dir.left;
    static int width = 20;
    static int height = 20;
    static int cornersize = 25;

    boolean gameOver;
    //added by mads
    static List<Corner> snake = new ArrayList<Corner>();
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


    public Snake(Board b, GraphicsContext gc) {

        //start at random position
        int randX = ThreadLocalRandom.current().nextInt(1,  b.getTiles());
        int randY = ThreadLocalRandom.current().nextInt(1,  b.getTiles());

        //put coordinats into position object
        pos = new Position(randX, randY);

        gc.setFill(Color.BLACK);
        gc.fillOval(randX * b.getTilesize(), randY * b.getTilesize(), b.getTilesize(), b.getTilesize());

        //create previous positions arrayList
        previousPositions = new ArrayList<>();
    }



    public Position getPos (){
        return this.pos;
    }


    public void move(Board b, Scene scene){


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
    }
}
