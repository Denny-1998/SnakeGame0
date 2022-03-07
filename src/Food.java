import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.concurrent.ThreadLocalRandom;

public class Food {
    private int randomX, randomY;

    GraphicsContext gc;
    Board b;



    public Food(GraphicsContext gc, Board b){
        this.gc = gc;
        this.b = b;

        randomX = ThreadLocalRandom.current().nextInt(1,  b.getTiles());
        randomY = ThreadLocalRandom.current().nextInt(1,  b.getTiles());


        gc.setFill(Color.BLACK);
        gc.fillOval(randomX * b.getTilesize(), randomY * b.getTilesize(), b.getTilesize(), b.getTilesize());

    }




    public int getXPosition() {
        return randomX;
    }

    public int getYPosition() {
        return randomY;
    }





    public void delete(){
        //gc.clearRect(randomX * b.getTilesize(), randomY * b.getTilesize(), b.getTilesize(), b.getTilesize());
        Square currentPos = b.getSquares(randomX, randomY);

        gc.setFill(currentPos.getColor());
        gc.fillRect(randomX * b.getTilesize(), randomY * b.getTilesize(), b.getTilesize(), b.getTilesize());
    }

}
