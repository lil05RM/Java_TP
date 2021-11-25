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
    }

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
    private int yOffsetFrameJump = 160;

    private int indexFoe = 0;
    private int k = 0;
    private int maxIndexFoe = 5;
    private double timeFrameFoe = 6;
    private int xOffsetFrameFoe = 48;
    private int yOffsetFrameFoe = 20;

    private double spriteWidth;
    private double spriteHeight;
    public double getSpriteWidth() {
        return spriteWidth;
    }
    public double getSpriteHeight() {
        return spriteHeight;
    }


    /*Constructeur*/
    public AnimatedThing(double x, double y, String filename, int attitude,double spriteWidth,double spriteHeight){
        this.x=x;
        this.y=y;
        this.spriteWidth=spriteWidth;
        this.spriteHeight=spriteHeight;
        spriteSheet = new Image(filename);
        this.attitude=attitude;
        sprite = new ImageView(spriteSheet);
    }

    /*Méthode pour mettre à jour le héro en fonction du temps */
    public void update(long time){

        switch(attitude){
            case 1: //Courir
                i += 1;
                if(i%timeFrame == 0){ //Condition quand le temps entre chaque frame est dépassé
                    i = 0;

                    index ++; //Change d'index
                    index=index%(maxIndex+1); //Si index est incrémenté à 6 la valeur revient à 0

                }
                sprite.setViewport(new Rectangle2D((index*offsetFrame),0,spriteWidth,spriteHeight)); //Definition fenetre sur la spritesheet du héro
                sprite.setX(x);
                sprite.setY(y);
                //System.out.println(index); //Affichage numero d'index
                break;

            case 2: //Saut haut
                //System.out.println(y);
                y -= 6;
                if(y <= jumpMax){
                    indexJump = 1;
                    attitude = 3; //Aller au saut vers le bas
                }
                sprite.setViewport(new Rectangle2D((indexJump*offsetFrame),yOffsetFrameJump,spriteWidth,spriteHeight));
                sprite.setY(y);
                break;

            case 3: //Saut bas
                //System.out.println(y);
                y += 6;
                if(y >= jumpMin){
                    indexJump = 0;
                    attitude = 1; //Retour à la course
                }
                sprite.setViewport(new Rectangle2D((indexJump*offsetFrame),yOffsetFrameJump,spriteWidth,spriteHeight));
                sprite.setY(y);
                break;

            default :
                System.out.println("Erreur attitude incorrecte");
                break;
        }

    }

    /*Méthode pour mettre à jour l'ennemi en fonction du temps */
    public void updateFoe(long time) {
        k += 1;
        if (k % timeFrameFoe == 0) { //Condition quand le temps entre chaque frame est dépassé
            k = 0;

            indexFoe++; //Change d'index
            indexFoe = indexFoe % (maxIndexFoe + 1); //Si index est incrémenté à 6 la valeur revient à 0

        }
        sprite.setViewport(new Rectangle2D((indexFoe * xOffsetFrameFoe), yOffsetFrameFoe, spriteWidth, spriteHeight)); //Definition fenetre sur la spritesheet du foe
        sprite.setX(x);
        sprite.setY(y);
        sprite.setFitHeight(100);
        sprite.setFitWidth(100);
        sprite.setPreserveRatio(true);
        x-=4;

    }

    /*Création d'une méthode permettant de créer un rectangle en fonction de la position*/
    public Rectangle2D getHitBox(){
        return new Rectangle2D((x+30),(y+10),(spriteWidth-30),(spriteHeight-20));
    }

    /*Méthode pour savoir s'il y a une intersection entre 2 rectangles de la méthode getHitBox()*/
    public boolean collision (AnimatedThing box){
        return box.getHitBox().intersects(this.getHitBox());
    }

}

