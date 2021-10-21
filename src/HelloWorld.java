
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
        public Hero hero = new Hero(100,200,"heros.png");

        public void start(Stage primaryStage){
            primaryStage.setTitle("Demo");
            Group root = new Group();
            Scene scene = new Scene(root, 800, 400);
            primaryStage.setScene(scene);
            primaryStage.show();

            Button btn = new Button("Bonjour");

            root.getChildren().add(imageViewSceneryLeft); //Affichage
            root.getChildren().add(btn);
            root.getChildren().add(hero.getSprite());
        }
        public static void main(String[] args) {
            launch(args); //Definition dans la classe Application Javafx
            // write your code here
        }
    }
