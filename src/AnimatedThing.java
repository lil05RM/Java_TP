import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class AnimatedThing {
    private double x;
    private double y;
    private Image spriteSheet;
    private ImageView sprite;

    public ImageView getSprite(){
        return sprite;
    };

    public int attitude;
    private int index = 0;
    private int i = 0;
    private int maxIndex = 5;
    private double timeFrame = 6;
    private int offsetFrame = 85;

    private int jumpMax = 100;
    private int jumpMin = 250;
    private int indexJump = 0;
    private int maxIndexJump = 1;
    private double timeFrameJump = 10;


    /*Constructeur*/
    public AnimatedThing(double x, double y, String filename, int attitude){
        this.x=x;
        this.y=y;
        spriteSheet = new Image(filename);
        this.attitude=attitude;
        sprite = new ImageView(spriteSheet);
    }

    public void update(long time){
        switch(attitude){
            case 1: //Courir
                i += 1;
                if(i%timeFrame == 0){ //Condition quand le temps entre chaque frame est dépassé
                    i = 0;

                    index ++; //Change d'index
                    index=index%(maxIndex+1); //Si index est incrémenté à 6 la valeur revient à 0

                }
                sprite.setViewport(new Rectangle2D((index*offsetFrame),0,85,100)); //Definition fenetre sur la spritesheet du héro
                sprite.setX(x);
                sprite.setY(y);
                //System.out.println(index); //Affichage numero d'index
                break;

            case 2: //Saut haut
                System.out.println(y);
                y -= 6;
                if(y <= jumpMax){
                    indexJump = 1;
                    attitude = 3; //Aller au saut vers le bas
                }
                sprite.setViewport(new Rectangle2D((indexJump*offsetFrame),160,85,100));
                sprite.setY(y);
                break;

            case 3: //Saut bas
                System.out.println(y);
                y += 6;
                if(y >= jumpMin){
                    indexJump = 0;
                    attitude = 1; //Retour à la course
                }
                sprite.setViewport(new Rectangle2D((indexJump*offsetFrame),160,85,100));
                sprite.setY(y);
                break;

            default :
                System.out.println("Erreur attitude incorrecte");
                break;
        }

    }
}

