public class Camera {
    private int x;
    private int y;

    private int timeToAccelerate = 1000; //Variable pour le temps avant une accélération du désert
    private int acc=2; //Variable pour accélérer le défilement du désert

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    /*Constructeur*/
    public Camera(int x, int y){
        this.x=x;
        this.y=y;
    }

    @Override
    public String toString() {
        return "Camera{" +
                "x=" + x + "," + "y=" + y +
                '}';
    }

    /*Méthode pour mettre à jour la caméra en fonction du temps */
    public void update(long time){
        x = x+acc; //Défilement du désert
        if(x%timeToAccelerate == 0){ //Condition quand le temps pour accélérer est arrivé
            acc+= 1; //On augmente l'accélération
        }
    }
}
