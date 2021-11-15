import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;

public class GameScene extends Scene {
    Camera camera;
    staticThing left;
    staticThing right;
    Hero hero;

    /*Constructeur*/
    public GameScene(Group g) {
        super(g,800,400);
        left=new staticThing(800,400,"desert.png");
        right=new staticThing(800,400,"desert.png");
        g.getChildren().add(right.getBackView()); //Rendre visible côté droit
        g.getChildren().add(left.getBackView()); //Rendre visible côté gauche
        camera = new Camera (0,0); //Création de ma caméra avec ses coordonnées
        render();

        hero = new Hero (100,270,"heros.png"); //Rendre visible image héro
        g.getChildren().add(hero.getSprite());

        //timer.start();
    }

    void render(){
        double offset = camera.getX()%left.getW();
        left.getBackView().setViewport(new Rectangle2D(offset,0,left.getW()-offset,left.getL()));
        right.getBackView().setViewport(new Rectangle2D(0,0,right.getW()-offset,right.getL()));
        right.getBackView().setX(right.getW()-offset);
        System.out.println(offset);
    }

    /*AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long time) {
            hero.update(time);
            camera.update(time);
            GameScene.update(time);

        }
    }

    public void update(long time){

    }*/

}
