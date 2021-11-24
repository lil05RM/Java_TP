import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;

import java.util.ArrayList;
import java.util.Random;

public class GameScene extends Scene {
    private Camera camera;
    private staticThing left;
    private staticThing right;
    private Hero hero;
    private Foe foe;
    public ArrayList<Foe> list=null;
    private Random rand = new Random();
    private int minValBetweenFoe = 50;


    /*Constructeur*/
    public GameScene(Group root) {
        super(root,800,400);
        left=new staticThing(800,400,"desert.png");
        right=new staticThing(800,400,"desert.png");
        root.getChildren().add(right.getBackView()); //Rendre visible côté droit
        root.getChildren().add(left.getBackView()); //Rendre visible côté gauche
        camera = new Camera (1900,0); //Création de ma caméra avec ses coordonnées
        render();

        hero = new Hero (100,250,"heros.png");
        root.getChildren().add(hero.getSprite()); //Rendre visible image héro

        timer.start();

        this.setOnMouseClicked( (event)->{
            System.out.println("Jump");
            //hero.jump();
            hero.attitude = 2;
        });

        this.list = new ArrayList<>();
        foe = new Foe (800,290,"foe.png");
        list.add(foe);
        list.add(new Foe (rand.nextInt(800)+minValBetweenFoe,290,"foe.png"));
        System.out.println(list);
        root.getChildren().add(foe.getSprite()); //Rendre visible image foe

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
            foe.updateFoe(time);
            render(); //Update de GameScene pour voir défilement désert
            //GameScene.update(time);
            //System.out.println(time);
            //System.out.println(tn);

            //System.out.println(foe.getX());

            for(Foe foe : list){
                if(hero.collision(foe)){
                    System.out.println("Collision");
                }
                /*else{
                    System.out.println("Go");
                }*/
            }

        }
    };

}
