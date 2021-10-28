
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

    public class HelloWorld extends Application{
        //Scenery est une MACRO
        private static final Image SCENERY = new Image("desert.png",1200,400,true,true);
        final private ImageView imageViewSceneryLeft = new ImageView(SCENERY);
        public Hero hero = new Hero(100,270,"heros.png"); //Création du héros

        @Override
        public void start(Stage primaryStage){
            primaryStage.setTitle("Demo");
            Group root = new Group();
            GameScene scene = new GameScene(root);
            primaryStage.setScene(scene);

            primaryStage.show();

            Button btn = new Button("Bonjour"); //Création du bouton

            root.getChildren().add(imageViewSceneryLeft); //Affichage du désert
            root.getChildren().add(btn); //Affichage du bouton
            root.getChildren().add(hero.getSprite()); //Affichage du héro
        }
        public static void main(String[] args) {
            launch(args); //Definition dans la classe Application Javafx
            // write your code here
        }
    }
