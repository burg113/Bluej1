package Classes.Balls;

import Classes.GameInformation;


/**
 *          The GravityBall class represents a ball being pulled down by gravity.
 *  <br><br>
 *
 * @version 1.0
 * @author Lennart B
 */
public class GravityBall extends FrictionBall {

    private double gravity;


    /**
     *  <br>    Creates a new ball affected by gravity
     *  <br><br>
     *
     *
     * @param size The diameter of the ball
     * @param pos The position of the ball <br> {x,y}
     * @param vel The velocity of the ball <br> {x,y}
     * @param gameInformation The GameInformation class containing all information of the current game
     */
    public GravityBall(double size, double[] pos, double[] vel, GameInformation gameInformation) {
        super(size, pos, vel, gameInformation);
        assignVariables();
    }

    /**
     *  <br>    Creates a new ball affected by gravity
     *  <br><br>
     *
     *
     * @param size The diameter of the ball
     * @param pos The position of the ball <br> {x,y}
     * @param gameInformation The GameInformation class containing all information of the current game
     */
    public GravityBall(double size, double[] pos, GameInformation gameInformation) {
        super(size, pos, gameInformation);
        assignVariables();
    }

    /**
     *  <br>    Creates a new ball affected by gravity
     *  <br><br>
     *
     *
     * @param size The diameter of the ball
     * @param posX The X-position of the ball
     * @param posY The Y-position of the ball
     * @param gameInformation The GameInformation class containing all information of the current game
     */
    public GravityBall(double size, double posX, double posY, GameInformation gameInformation) {
        super(size, posX, posY, gameInformation);
        assignVariables();
    }

    /**
     *  <br>    Creates a new ball affected by gravity
     *  <br><br>
     *
     *
     * @param pos The position of the ball <br> {x,y}
     * @param gameInformation The GameInformation class containing all information of the current game
     */
    public GravityBall(double[] pos, GameInformation gameInformation) {
        super(pos, gameInformation);
        assignVariables();
    }

    private void assignVariables(){
        gravity=1000;
    }

    @Override
    public void move(double deltaTime) {
        //get the velocity
        double[] vel = getVel();

        //apply gravity
        vel[1]+=gravity*deltaTime;

        //sets the velocity
        setVel(vel);


        super.move(deltaTime);
    }


    /**
     *  <br>    Gets the gravity
     *  <br><br>
     *
     * @return The gravity in pixels/s^2
     */
    public double getGravity() {
        return gravity;
    }


    /**
     *  <br>    Sets the gravity
     *  <br><br>
     *
     * @param gravity The gravity in pixels/s^2
     */
    public void setGravity(double gravity) {
        this.gravity = gravity;
    }
}
