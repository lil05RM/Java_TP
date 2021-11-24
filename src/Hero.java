import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Hero extends AnimatedThing {
    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    /*Constructeur*/
    public Hero (double x, double y, String fileName){
        super(x,y,fileName,1,85,100);
        this.x=x;
        this.y=y;

        /* Affichage statique du héro
        spriteSheet=new Image(fileName);
        sprite = new ImageView(spriteSheet);
        sprite.setViewport(new Rectangle2D(0,0,85,100));
        sprite.setX(x);
        sprite.setY(y);
        */
    }

}
