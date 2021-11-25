
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

    public class HelloWorld extends Application{
        //Scenery est une MACRO
        private static final Image SCENERY = new Image("desert.png",800,400,true,true);
        final private ImageView imageViewSceneryLeft = new ImageView(SCENERY);
        //public Hero hero = new Hero(100,270,"heros.png"); //Création du héros

        @Override
        public void start(Stage primaryStage){
            primaryStage.setTitle("Demo");
            Group start = new Group();

            Text text_1 = new Text("RULE : CLICK TO AVOID HYENAS\n");
            text_1.setFill(Color.SADDLEBROWN);
            Font font = Font.font("Verdana",FontWeight.EXTRA_BOLD,30);
            text_1.setFont(font);
            start.getChildren().add(text_1);

            VBox vbox = new VBox(start);
            vbox.setAlignment(Pos.CENTER);
            vbox.setBackground(new Background(new BackgroundFill(Color.AQUA, CornerRadii.EMPTY, Insets.EMPTY)));
            Scene t = new Scene(vbox, 800, 400);

            Button btn = new Button("Press to start");
            btn.setLayoutX(240);
            btn.setLayoutY(50);
            btn.setMaxWidth(400);
            btn.setMinHeight(100);
            btn.setFont(font);
            vbox.getChildren().add(btn);

            primaryStage.setScene(t);
            primaryStage.show();

            /*Début du jeu sur un appui sur le bouton*/
            btn.setOnMouseClicked( (event)->{
                System.out.println("Start");
                Group root = new Group();
                GameScene scene = new GameScene(root);
                primaryStage.setScene(scene);
            });

            /*if (GameScene.perdu==true){
                Group fin = new Group();
                Text text_2 = new Text("PERDU\n");
                text_1.setFill(Color.SADDLEBROWN);
                Font police = Font.font("Verdana", FontWeight.EXTRA_BOLD,30);
                text_1.setFont(police);
                fin.getChildren().add(text_1);

                VBox vboxFin = new VBox(fin);
                vboxFin.setAlignment(Pos.CENTER);
                Scene termine = new Scene(vboxFin, 800, 400);

                primaryStage.setScene(termine);
                primaryStage.show();
            }*/


            /* Essais première séance
            Button btn = new Button("Bonjour"); //Création du bouton
            root.getChildren().add(imageViewSceneryLeft); //Affichage du désert
            root.getChildren().add(btn); //Affichage du bouton
            root.getChildren().add(hero.getSprite()); //Affichage du héro
            */
        }
        public static void main(String[] args) {
            launch(args); //Definition dans la classe Application Javafx
            // write your code here
        }
    }
