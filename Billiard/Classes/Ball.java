package Classes;

import com.sun.istack.internal.NotNull;
import sum.kern.Stift;

/**
 *          The Ball class represents a billiard ball.
 *  <br><br>
 *
 * @version 1.0
 * @author Lennart B
 */

public class Ball {

    //needed variables are declared
    private double size;
    private double [] pos;
    private double [] vel;
    private double mass=0.17;

    //needed objects are declared
    private GameInformation gameInformation;
    private Stift pencil;

    /**
     *  <br>    Creates a new ball
     *  <br><br>
     *
     *
     * @param size The diameter of the ball
     * @param pos The position of the ball <br> {x,y}
     * @param vel The velocity of the ball <br> {x,y}
     * @param gameInformation The GameInformation class containing all information of the current game
     */
    public Ball(double size,double [] pos,double [] vel,GameInformation gameInformation){
        //assigns all variables
        this.size=size;
        this.pos=pos;
        this.vel=vel;
        this.gameInformation=gameInformation;
        pencil = new Stift();

    }

    /**
     *  <br>    Creates a new ball
     *  <br><br>
     *
     *
     * @param size The diameter of the ball
     * @param pos The position of the ball <br> {x,y}
     * @param gameInformation The GameInformation class containing all information of the current game
     */
    public Ball(double size,double [] pos,GameInformation gameInformation){
        this(size,pos,new double[]{0,0},gameInformation);
    }

    /**
     *  <br>    Creates a new ball
     *  <br><br>
     *
     *
     * @param size The diameter of the ball
     * @param posX The X-position of the ball
     * @param posY The Y-position of the ball
     * @param gameInformation The GameInformation class containing all information of the current game
     */
    public Ball(double size,double posX,double posY,GameInformation gameInformation){
        this(size,new double[]{posX,posY},new double[]{0,0},gameInformation);
    }

    /**
     *  <br>    Creates a new ball
     *  <br><br>
     *
     *
     * @param pos The position of the ball <br> {x,y}
     * @param gameInformation The GameInformation class containing all information of the current game
     */
    public Ball(double [] pos, @NotNull GameInformation gameInformation){
        this(gameInformation.getBallSize(),pos,new double[]{0,0},gameInformation);
    }

    /**
     *  <br>    Updates the balls position
     *  <br>    This should be called every frame in order for the Ball to move
     *  <br><br>
     *
     * @param deltaTime The time that passed since the last update in seconds
     */
    public void update(double deltaTime){
        //moves the ball
        move(deltaTime);

        //handles collisions
        handleCollisions();

        //draws the ball
        draw();
    }


    /**
     *  <br>    Moves the ball
     *  <br>    This is automatically called by the update method
     *  <br><br>
     *
     * @param deltaTime The time that passed since the last time this function has been called in seconds
     */
    public void move(double deltaTime){
        //applies the velocity
        pos[0]+=vel[0]*deltaTime;
        pos[1]+=vel[1]*deltaTime;
    }

    /**
     *  <br>    Handles collisions with the walls
     *  <br>    This is automatically called by the update method
     *  <br><br>
     *
     */
    //handles collisions
    public void handleCollisions(){
        //handle collisions with the walls
        handleWallCollisions();
    }

    //handles collisions with the wall
    private  void handleWallCollisions(){
        //gets the bounding box of the table
        double[][] tableBounds=gameInformation.getBilliardTable().getBounds();

        //iterates through the horizontal and vertical walls
        for(int i=0;i<2;i++) {
            //checks if there was a collision
            if (pos[i] > tableBounds[i][1]-size/2) {
                //changes velocity
                vel[i] = -Math.abs(vel[i]) * (1 - gameInformation.getCollisionEnergyLoss());
                vel[(i + 1) % 2] = vel[(i + 1) % 2] * (1 - gameInformation.getCollisionEnergyLoss());


                //the ball is moved outside of the wall
                //this is done to ensure that a ball neither by slowing down nor by changing size can get stuck in the wall
                pos[i] = tableBounds[i][1] - size/2;
            }

            if (pos[i] < tableBounds[i][0] + size/2 ) {
                //changes velocity
                vel[i] = Math.abs(vel[i]) * (1 - gameInformation.getCollisionEnergyLoss());
                vel[(i + 1) % 2] = vel[(i + 1) % 2] * (1 - gameInformation.getCollisionEnergyLoss());

                //the ball is moved outside of the wall
                //this is done to ensure that a ball neither by slowing down nor by changing size can get stuck in the wall
                pos[i] = tableBounds[i][0] + size/2;
            }
        }


    }

    /**
     *  <br>    Draws the ball onto the screen
     *  <br>    This is automatically called by the update method
     *  <br><br>
     *
     */
    public void draw(){
        // move to the balls position
        pencil.bewegeBis(pos[0],pos[1]);

        //draw the ball
        pencil.zeichneKreis(size/2);

    }

    /**
     *  <br>    Does the cleanup. It should only be run when the ball is not needed anymore!
     *  <br><br>
     */
    public void cleanup(){
        pencil.gibFrei();
    }


    /**
     *  <br>    Gets the balls velocity
     *  <br><br>
     *
     * @return The balls velocity <br> {x,y}
     */
    public double[] getVel() {
        return vel;
    }

    /**
     *  <br>    Sets the balls velocity
     *  <br><br>
     *
     * @param velX The X component of the velocity
     * @param velY The Y component of the velocity
     */
    public void setVel(double velX,double velY) {
        this.vel = new double[]{velX,velY};
    }

    /**
     *  <br>    Sets the balls velocity
     *  <br><br>
     *
     * @param vel The balls velocity <br> {x,y}
     */
    public void setVel(double[] vel) {
        this.vel =vel;
    }

    /**
     *  <br>    Gets the balls mass
     *  <br><br>
     *
     * @return The balls mass
     */
    public double getMass() {
        return mass;
    }

    /**
     *  <br>    Sets the balls mass
     *  <br><br>
     *
     * @param mass The mass of the ball
     */
    public void setMass(double mass) {
        this.mass = mass;
    }

    /**
     *  <br>    Gets the balls position
     *  <br><br>
     *
     * @return The balls position <br> {x,y}
     */
    public double[] getPos() {
        return pos;
    }

    /**
     *  <br>    Sets the balls position
     *  <br><br>
     *
     * @param pos The position of the ball
     */
    public void setPos(double[] pos) {
        this.pos = pos;
    }

    /**
     *  <br>    Sets the balls position
     *  <br><br>
     *
     * @param posX The X component of the position
     * @param posY The Y component of the position
     */
    public void setPos(double posX,double posY) {
        this.vel = new double[]{posX,posY};
    }

    /**
     *  <br>    Gets the balls size
     *  <br><br>
     *
     * @return The balls position <br> {x,y}
     */
    public double getSize() {
        return size;
    }

    /**
     *  <br>    Sets the balls size
     *  <br><br>
     *
     * @param size The size of the ball
     */
    public void setSize(double size) {
        this.size = size;
    }

    /**
     *  <br>    Gets the gameInformation of the game this ball is a part of
     *  <br><br>
     *
     * @return  The gameInformation
     */
    public GameInformation getGameInformation() {
        return gameInformation;
    }

    /**
     *  <br>    Sets the gameInformation of the game this ball is a part of
     *  <br><br>
     *
     * @param gameInformation The gameInformation
     */
    public void setGameInformation(GameInformation gameInformation) {
        this.gameInformation = gameInformation;
    }
}
