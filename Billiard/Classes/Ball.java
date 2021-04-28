package Classes;

import org.jetbrains.annotations.NotNull;
import sum.kern.Stift;

public class Ball {

    private double size;
    private double [] pos;
    private double [] vel;
    private GameInformation gameInformation;

    private Stift pencil;

    public Ball(double size,double [] pos,GameInformation gameInformation){
        this.size = size;
        this.pos = pos;
        this.vel = new double[]{0,0};
        this.gameInformation = gameInformation;
        pencil = new Stift();
    }

    public Ball(double size,double posX,double posY,GameInformation gameInformation){
        this.size=size;
        this.pos=new double[]{posX,posY};
        this.vel=new double[]{0,0};
        this.gameInformation=gameInformation;
        pencil = new Stift();

    }

    public Ball(double size,double [] pos,double [] vel,GameInformation gameInformation){
        this.size=size;
        this.pos=pos;
        this.vel=vel;
        this.gameInformation=gameInformation;
        pencil = new Stift();

    }

    public Ball(double [] pos, @NotNull GameInformation gameInformation){
        this.size=gameInformation.getBallSize();
        this.pos=pos;
        this.vel=new double[]{0,0};
        this.gameInformation=gameInformation;
        pencil = new Stift();

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
