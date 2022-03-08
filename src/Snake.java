import javafx.geometry.Pos;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Snake {
    Position pos;
    ArrayList<Position> previousPositions;


    public Snake(Board b, GraphicsContext gc) {

        //start at random position
        int randX = ThreadLocalRandom.current().nextInt(1,  b.getTiles());
        int randY = ThreadLocalRandom.current().nextInt(1,  b.getTiles());

        //put coordinats into position object
        pos = new Position(randX, randY);

        //create previous positions arrayList
        previousPositions = new ArrayList<>();
    }



    public Position getPos (){
        return this.pos;
    }


    public void move(){
        //TODO
    }
}
