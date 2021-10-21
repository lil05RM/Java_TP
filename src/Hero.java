import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Hero {
    private double x;
    private double y;

    private Image spriteSheet;

    public ImageView getSprite() {
        return sprite;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    private ImageView sprite;

    /*Constructeur*/
    public Hero(double x, double y, String fileName){
        this.x=x;
        this.y=y;

        spriteSheet=new Image(fileName);
        sprite = new ImageView(spriteSheet);

        sprite.setViewport(new Rectangle2D(20,15,60,80));

    }
}
