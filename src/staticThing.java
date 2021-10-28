
import javafx.scene.image.ImageView;

public class staticThing {

    private double w;
    private double l;
    private ImageView backView;

    public double getW() { return w; }
    public double getL(){ return l; }
    public ImageView getBackView(){
        return backView;
    }

    /*Constructeur*/
    public staticThing(double w, double l, String fileName) {
        this.w = w;
        this.l = l;

        backView = new ImageView(fileName);
    }
}
