import javafx.scene.image.ImageView;

public abstract class AnimatedThing {
    private double x;
    private double y;
    private ImageView spriteSheet;
    private int attitude;

    public ImageView getSpriteSheet(){ return spriteSheet; };

    public AnimatedThing(double x, double y, String filename, int attitude){
        this.x=x;
        this.y=y;
        spriteSheet = new ImageView(filename);
        this.attitude=attitude;
    }

}

