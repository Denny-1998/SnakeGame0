import javafx.scene.paint.Color;

public class Square {
    private int x;
    private int y;

    private int size;
    private Color color;




    public Square (int x, int y, int size, Color color){
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
    }




    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSize(){
        return this.size;
    }

    public Color getColor() {
        return color;
    }
}
