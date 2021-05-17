package Classes.Balls;

import Classes.Ball;
import Classes.GameInformation;
import com.sun.istack.internal.NotNull;

/**
 *          The PulsatingBall class represents a billiard ball which pulsates (in size).
 *  <br><br>
 *
 * @version 1.0
 * @author Lennart B
 */
public class PulsatingBall extends Ball {

    private double minSize;
    private double maxSize;
    private double growingSpeed;


    /**
     *  <br>    Creates a new ball which is pulsating (constantly changing size)
     *  <br><br>
     *
     *
     * @param size The median diameter of the ball. The ball will pulsate between 0.5 and 1.5 times this size unless the min or max size is set separately.
     * @param pos The position of the ball <br> {x,y}
     * @param vel The velocity of the ball <br> {x,y}
     * @param gameInformation The GameInformation class containing all information of the current game
     */
    public PulsatingBall(double size, double[] pos, double[] vel, GameInformation gameInformation) {
        super(size, pos, vel, gameInformation);
        assignVariables(size);
    }

    /**
     *  <br>    Creates a new ball which is pulsating (constantly changing size)
     *  <br><br>
     *
     *
     * @param size The median diameter of the ball. The ball will pulsate between 0.5 and 1.5 times this size unless the min or max size is set separately.
     * @param pos The position of the ball <br> {x,y}
     * @param gameInformation The GameInformation class containing all information of the current game
     */
    public PulsatingBall(double size, double[] pos, GameInformation gameInformation) {
        super(size, pos, gameInformation);
        assignVariables(size);
    }

    /**
     *  <br>    Creates a new ball which is pulsating (constantly changing size)
     *  <br><br>
     *
     *
     * @param size The diameter of the ball
     * @param posX The X-position of the ball
     * @param posY The Y-position of the ball
     * @param gameInformation The GameInformation class containing all information of the current game
     */
    public PulsatingBall(double size, double posX, double posY, GameInformation gameInformation) {
        super(size, posX, posY, gameInformation);
        assignVariables(size);
    }

    /**
     *  <br>    Creates a new ball which is pulsating (constantly changing size)
     *  <br><br>
     *
     *
     * @param pos The position of the ball <br> {x,y}
     * @param gameInformation The GameInformation class containing all information of the current game
     */
    public PulsatingBall(double[] pos,@NotNull GameInformation gameInformation) {
        super(pos, gameInformation);
        assignVariables(gameInformation.getBallSize());
    }

    private void assignVariables(double size){
        minSize=0.5*size;
        maxSize=1.5*size;
        growingSpeed=size*2;
    }


    /**
     *  <br>    Updates the balls position and size
     *  <br>    This should be called every frame in order for the Ball to move
     *  <br><br>
     *
     * @param deltaTime The time that passed since the last update in seconds
     */
    @Override
    public void update(double deltaTime) {

        //gets the balls size
        double size=getSize();


        if(size+growingSpeed*deltaTime>maxSize){            // case where the ball is bigger than the max size
            size=maxSize;
            growingSpeed*=-1;
        }else if(size+growingSpeed*deltaTime<minSize) {     // case where the ball is smaller than the min size
            size = minSize;
            growingSpeed *= -1;
        }

        //the size is increased
        size+=growingSpeed*deltaTime;

        //the new size is set
        setSize(size);

        //the overridden update method is executed
        super.update(deltaTime);
    }

    /**
     *  <br>    Gets the balls minimal size
     *  <br><br>
     *
     * @return The balls minimal size
     */
    public double getMinSize() {
        return minSize;
    }

    /**
     *  <br>    Sets the balls minimal size
     *  <br><br>
     *
     * @param minSize The balls minimal size
     */
    public void setMinSize(double minSize) {
        this.minSize = minSize;
    }

    /**
     *  <br>    Gets the balls maximal size
     *  <br><br>
     *
     * @return The balls maximal size
     */
    public double getMaxSize() {
        return maxSize;
    }

    /**
     *  <br>    Sets the balls maximal size
     *  <br><br>
     *
     * @param maxSize The balls maximal size
     */
    public void setMaxSize(double maxSize) {
        this.maxSize = maxSize;
    }

    /**
     *  <br>    Gets the speed at which the ball is growing and shrinking
     *  <br><br>
     *
     * @return The growing speed in pixels/second
     */
    public double getGrowingSpeed() {
        return growingSpeed;
    }

    /**
     *  <br>    Sets the speed at which the ball is growing and shrinking
     *  <br><br>
     *
     * @param growingSpeed The growing speed in pixels/second
     */
    public void setGrowingSpeed(double growingSpeed) {
        this.growingSpeed = growingSpeed;
    }
}
