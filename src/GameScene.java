import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;

public class GameScene extends Scene {
    Camera camera;
    staticThing left;
    staticThing right;

    /*Constructeur*/
    public GameScene(Group g) {
        super(g);
        left=new staticThing(0,400,"desert.png");
        right=new staticThing(800,400,"desert.png");
        g.getChildren().add(right.getBackView()); //Rendre visible
        g.getChildren().add(left.getBackView()); //Rendre visible
        camera = new Camera (1500,0); //Création de ma caméra avec ses coordonnées
        render();
    }

    void render(){
        double offset = camera.getX()%left.getW();
        left.getBackView().setViewport(new Rectangle2D(offset,0,left.getW()-offset,left.getL()));
        right.getBackView().setViewport(new Rectangle2D(offset,400,right.getW()-offset,right.getL()));
    }

}
