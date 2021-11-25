import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;

import java.util.ArrayList;
import java.util.Random;

public class GameScene extends Scene {
    private Camera camera;
    private int maxWidthScreen = 800;
    private int maxLongScreen = 400;
    private staticThing left;
    private staticThing right;
    private Hero hero;
    private int yPosHero = 250;
    private int xPosHero = 100;
    private Foe foe;
    private int yPosFoe = 290;
    private int xPosFoe = 800;
    public ArrayList<Foe> list = new ArrayList<>();
    private Random rand = new Random();
    private int minValBetweenFoe = 300;
    private int nbFoe = 500;
    public boolean perdu = false;


    /*Constructeur*/
    public GameScene(Group root) {
        super(root,800,400);
        left=new staticThing(maxWidthScreen,maxLongScreen,"desert.png");
        right=new staticThing(maxWidthScreen,maxLongScreen,"desert.png");
        root.getChildren().add(right.getBackView()); //Rendre visible côté droit
        root.getChildren().add(left.getBackView()); //Rendre visible côté gauche
        camera = new Camera (1900,0); //Création de ma caméra avec ses coordonnées
        render(); //Permet le défilement du désert

        hero = new Hero (xPosHero,yPosHero,"heros.png");
        root.getChildren().add(hero.getSprite()); //Rendre visible image héro

        timer.start(); //Début du timer

        this.setOnMouseClicked( (event)->{
            System.out.println("Jump");
            hero.attitude = 2;
        });

        /*Ajout d'un ennemi à la liste pour premier test*/
        /*foe = new Foe (xPosFoe,yPosFoe,"foe.png");
        list.add(foe);
        root.getChildren().add(foe.getSprite()); //Rendre visible image foe
        */

        /*Ajout de multiples ennemis et affichage*/
        for(int i=0;i<nbFoe;i++){
            list.add(new Foe (rand.nextInt(maxWidthScreen)+minValBetweenFoe,yPosFoe,"foe.png"));
            minValBetweenFoe=minValBetweenFoe+maxWidthScreen;
        }
        for(int i=0;i<list.size();i++){
            root.getChildren().add(list.get(i).getSprite());
        }

    }
    /*Méthode qui permet de faire l'effet de défilement du désert */
    void render(){
        double offset = camera.getX()%left.getW();
        left.getBackView().setViewport(new Rectangle2D(offset,0,left.getW(),left.getL()));
        right.getBackView().setViewport(new Rectangle2D(0,0,right.getW(),right.getL()));
        right.getBackView().setX(right.getW()-offset);
        //System.out.println(offset);
        //System.out.println(camera);
    }

    /*Création du moteur du jeu avec des méthodes appelées après un certain temps passé*/
    final long timeNanoSecond = System.nanoTime();
    AnimationTimer timer = new AnimationTimer() {
        public void handle(long time) {
            double tn = Math.abs((timeNanoSecond - time)/1000000000.0);
            hero.update(time);
            camera.update(time);
            //foe.updateFoe(time);
            render(); //Update de GameScene pour voir défilement désert

            /* Affichage des ennemis en parcourant la liste*/
            for(int i=0;i<list.size();i++){
                list.get(i).updateFoe(time);
            }

            /*Détection de collision entre le héro et les ennemis de la liste créée*/
            for(Foe foe : list){
                if(hero.collision(foe)){
                    System.out.println("Collision");
                    perdu = true;
                }
            }

        }
    };

}
