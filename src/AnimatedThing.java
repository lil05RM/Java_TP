import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class AnimatedThing {
    private double x;
    private double y;
    private Image spriteSheet;
    private ImageView sprite;

    public ImageView getSprite(){
        return sprite;
    };

    private int attitude;
    private int index = 0;
    private int i = 0;
    private int maxIndex = 5;
    private double timeFrame = 0.2;
    private int offsetFrame = 85;

    /*Constructeur*/
    public AnimatedThing(double x, double y, String filename, int attitude){
        this.x=x;
        this.y=y;
        spriteSheet = new Image(filename);
        this.attitude=attitude;
        sprite = new ImageView(spriteSheet);
    }

    public void update(long time){
        i += 1;
        if(i%4 == 0){
            i = 0;

            index ++;
            index=index%6;

        }
        sprite.setViewport(new Rectangle2D((index*offsetFrame),0,85,100));
        sprite.setX(x);
        sprite.setY(y);
        System.out.println(index);
    }
}

