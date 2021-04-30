package Classes;

import com.sun.istack.internal.NotNull;
import sum.kern.Stift;

public class Ball {

    private double size;
    private double [] pos;
    private double [] vel;
    private GameInformation gameInformation;

    private Stift pencil;

    public Ball(double size,double [] pos,double [] vel,GameInformation gameInformation){
        this.size=size;
        this.pos=pos;
        this.vel=vel;
        this.gameInformation=gameInformation;
        pencil = new Stift();

    }

    public Ball(double size,double [] pos,GameInformation gameInformation){
        this(size,pos,new double[]{0,0},gameInformation);
    }

    public Ball(double size,double posX,double posY,GameInformation gameInformation){
        this(size,new double[]{posX,posY},new double[]{0,0},gameInformation);
    }

    public Ball(double [] pos, @NotNull GameInformation gameInformation){
        this(gameInformation.getBallSize(),pos,new double[]{0,0},gameInformation);
    }


    public void update(double deltaTime){
        move(deltaTime);

        handleCollisions();

        draw();
    }


    private void move(double deltaTime){
        pos[0]+=vel[0]*deltaTime;
        pos[1]+=vel[1]*deltaTime;
    }

    private void handleCollisions(){
        handleWallCollisions();

    }

    private  void handleWallCollisions(){
        double[][] tableBounds=gameInformation.getBilliardTable().getBounds();
        for(int i=0;i<2;i++) {
            if (pos[i] < tableBounds[i][0]+size/2 || pos[i] > tableBounds[i][1]-size/2) {
                vel[i] *= -1;
            }
        }
    }

    private void draw(){

        pencil.bewegeBis(pos[0],pos[1]);

        pencil.zeichneKreis(size/2);

    }

    public void cleanup(){
        pencil.gibFrei();
    }

    public double[] getVel() {
        return vel;
    }

    public void setVel(double velX,double velY) {
        this.vel = new double[]{velX,velY};
    }
}
