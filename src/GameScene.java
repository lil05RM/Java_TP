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
        camera = new Camera (1900,0); //Création de ma caméra avec ses coordonnées
        render();

        hero = new Hero (100,250,"heros.png");
        g.getChildren().add(hero.getSprite()); //Rendre visible image héro

        timer.start();

        this.setOnMouseClicked( (event)->{
            System.out.println("Jump");
            //hero.jump();
            hero.attitude = 2;
        });
    }

    void render(){
        double offset = camera.getX()%left.getW();
        left.getBackView().setViewport(new Rectangle2D(offset,0,left.getW(),left.getL()));
        right.getBackView().setViewport(new Rectangle2D(0,0,right.getW(),right.getL()));
        right.getBackView().setX(right.getW()-offset);
        //System.out.println(offset);
        //System.out.println(camera);
    }

    final long timeNanoSecond = System.nanoTime();
    AnimationTimer timer = new AnimationTimer() {
        public void handle(long time) {
            double tn = Math.abs((timeNanoSecond - time)/1000000000.0);
            hero.update(time);
            camera.update(time);
            render();
            //GameScene.update(time);
            //System.out.println(time);
            //System.out.println(tn);

        }
    };

}
