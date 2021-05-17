package Classes.Balls;

import Classes.Ball;
import Classes.GameInformation;
import sum.kern.Stift;

/**
 *          The NumberedBall class represents a billiard ball with a number.
 *  <br><br>
 *
 * @version 1.0
 * @author Lennart B
 */
public class NumberedBall extends Ball {

    private int number;
    private Stift pencil;

    /**
     *  <br>    Creates a new ball with a number
     *  <br><br>
     *
     *
     * @param size The diameter of the ball
     * @param pos The position of the ball <br> {x,y}
     * @param vel The velocity of the ball <br> {x,y}
     * @param gameInformation The GameInformation class containing all information of the current game
     */
    public NumberedBall(double size, double[] pos, double[] vel, GameInformation gameInformation) {
        super(size, pos, vel, gameInformation);
        pencil = new Stift();
    }

    /**
     *  <br>    Creates a new ball with a number
     *  <br><br>
     *
     *
     * @param size The diameter of the ball
     * @param pos The position of the ball <br> {x,y}
     * @param gameInformation The GameInformation class containing all information of the current game
     */
    public NumberedBall(double size, double[] pos, GameInformation gameInformation) {
        super(size, pos, gameInformation);
        pencil = new Stift();
    }

    /**
     *  <br>    Creates a new ball with a number
     *  <br><br>
     *
     *
     * @param size The diameter of the ball
     * @param posX The X-position of the ball
     * @param posY The Y-position of the ball
     * @param gameInformation The GameInformation class containing all information of the current game
     */
    public NumberedBall(double size, double posX, double posY, GameInformation gameInformation, int number) {
        super(size, posX, posY, gameInformation);
        this.number=number;
        pencil = new Stift();
    }

    /**
     *  <br>    Creates a new ball with a number
     *  <br><br>
     *
     *
     * @param pos The position of the ball <br> {x,y}
     * @param gameInformation The GameInformation class containing all information of the current game
     */
    public NumberedBall(double[] pos, GameInformation gameInformation) {
        super(pos, gameInformation);
        pencil = new Stift();
    }

    private void initializeVariables(){
        pencil = new Stift();
    }

    @Override
    public void draw(){
        double [] pos = getPos();

        //the ball is drawn
        super.draw();

        //center number
        pencil.bewegeBis(pos[0]-4-3*((int)Math.log10(number)),pos[1]+6);

        //write number
        pencil.schreibeZahl(number);

    }

    /**
     *  <br>    Gets the balls number
     *  <br><br>
     *
     * @return The balls number
     */
    public int getNumber() {
        return number;
    }

    /**
     *  <br>    Sets the balls number
     *  <br><br>
     *
     * @param number The balls number
     */
    public void setNumber(int number) {
        this.number = number;
    }
}
