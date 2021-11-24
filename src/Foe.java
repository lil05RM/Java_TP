import javafx.geometry.Rectangle2D;

import java.util.ArrayList;

public class Foe extends AnimatedThing {
    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    /*Constructeur*/
    public Foe (double x, double y, String fileName){
        super(x,y,fileName,1,49,28);
        this.x=x;
        this.y=y;

    }

}
