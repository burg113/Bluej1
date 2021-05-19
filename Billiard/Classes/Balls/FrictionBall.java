package Classes.Balls;

import Classes.Ball;
import Classes.GameInformation;

/**
 *          The FrictionBall class represents a billiard ball which slows down when moving.
 *  <br><br>
 *
 * @version 1.0
 * @author Lennart B
 */
public class FrictionBall extends Ball {

    /**
     *  <br>    Creates a new ball that slows down when rolling
     *  <br><br>
     *
     *
     * @param size The diameter of the ball
     * @param pos The position of the ball <br> {x,y}
     * @param vel The velocity of the ball <br> {x,y}
     * @param gameInformation The GameInformation class containing all information of the current game
     */
    public FrictionBall(double size, double[] pos, double[] vel, GameInformation gameInformation) {
        super(size, pos, vel, gameInformation);
    }

    /**
     *  <br>    Creates a new ball that slows down when rolling
     *  <br><br>
     *
     *
     * @param size The diameter of the ball
     * @param pos The position of the ball <br> {x,y}
     * @param gameInformation The GameInformation class containing all information of the current game
     */
    public FrictionBall(double size, double[] pos, GameInformation gameInformation) {
        super(size, pos, gameInformation);
    }

    /**
     *  <br>    Creates a new ball that slows down when rolling
     *  <br><br>
     *
     *
     * @param size The diameter of the ball
     * @param posX The X-position of the ball
     * @param posY The Y-position of the ball
     * @param gameInformation The GameInformation class containing all information of the current game
     */
    public FrictionBall(double size, double posX, double posY, GameInformation gameInformation) {
        super(size, posX, posY, gameInformation);
    }

    /**
     *  <br>    Creates a new ball that slows down when rolling
     *  <br><br>
     *
     *
     * @param pos The position of the ball <br> {x,y}
     * @param gameInformation The GameInformation class containing all information of the current game
     */
    public FrictionBall(double[] pos, GameInformation gameInformation) {
        super(pos, gameInformation);
    }


    /**
     *  <br>    Moves the ball and applies friction
     *  <br>    This is automatically called by the update method
     *  <br><br>
     *
     * @param deltaTime The time that passed since the last time this function has been called in seconds
     *
     */
    @Override
    public void move(double deltaTime) {

        applyFriction(deltaTime);

        super.move(deltaTime);

    }


    //changes the balls velocity according to a frictional force
    private void applyFriction(double deltaTime){

        //gets the velocity
        double [] vel=getVel();

        //applies friction
        vel[0]*=1 - 0.6*deltaTime;
        vel[1]*=1 - 0.6*deltaTime;

        //sets the new velocity
        setVel(vel[0],vel[1]);

    }


}
