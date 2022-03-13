import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;



public class Board {

    private int size = 600; //size in px
    private int tiles = 24; //size in squares
    private int tilesize;
    private Square[][] squares = new Square[tiles][tiles];




    public Board(GraphicsContext gc){
        tilesize = size/ tiles;

        createSquares();

        for (int i = 0; i < tiles; i++) {
            for (int j = 0; j < tiles; j++) {

                Square square = squares[j][i];
                gc.setFill(square.getColor());
                gc.fillRect(square.getX(), square.getY(), square.getSize(), square.getSize());
            }
        }
    }

    public Square getSquares(int x, int y) {
        return squares[x][y];
    }
    public int getTilesize() {
        return tilesize;
    }
    public int getTiles() {
        return tiles;
    }
    public int getSize(){
        return size;
    }



    public void createSquares (){

        boolean change = false;
        int x = 0;
        int y = 0;

        for (int i = 0; i < tiles; i++) {
            for (int j = 0; j < tiles; j++) {

                x = j * tilesize;
                y = i * tilesize;

                if(change) {
                    squares[j][i] = new Square(x, y, tilesize, Color.GREEN);
                    change = false;
                } else {
                    squares[j][i] = new Square(x, y, tilesize, Color.rgb(0, 160, 0));
                    change = true;
                }
            }

            if(i%2 == 0){
                change = true;
            }else {
                change = false;
            }
        }
    }

}



