package Classes.Balls;

import Classes.Ball;
import Classes.GameInformation;
import sum.kern.Buntstift;
import sum.kern.Muster;
import sum.kern.Stift;

import java.awt.*;

/**
 *          The ColorBall class represents a colored billiard ball.
 *  <br><br>
 *
 * @version 1.0
 * @author Lennart B
 */
public class ColorBall extends Ball{

    private Buntstift pencil;

    private Color color;

    /**
     *  <br>    Creates a new colored ball
     *  <br><br>
     *
     *
     * @param size The diameter of the ball
     * @param pos The position of the ball <br> {x,y}
     * @param vel The velocity of the ball <br> {x,y}
     * @param gameInformation The GameInformation class containing all information of the current game
     */
    public ColorBall(double size, double[] pos, double[] vel, GameInformation gameInformation) {
        super(size, pos, vel, gameInformation);
        pencil=new Buntstift();
    }

    /**
     *  <br>    Creates a new colored ball
     *  <br><br>
     *
     *
     * @param size The diameter of the ball
     * @param pos The position of the ball <br> {x,y}
     * @param gameInformation The GameInformation class containing all information of the current game
     */
    public ColorBall(double size, double[] pos, GameInformation gameInformation) {
        super(size, pos, gameInformation);
        initializeVariables();
    }

    /**
     *  <br>    Creates a new colored ball
     *  <br><br>
     *
     *
     * @param size The diameter of the ball
     * @param posX The X-position of the ball
     * @param posY The Y-position of the ball
     * @param gameInformation The GameInformation class containing all information of the current game
     */
    public ColorBall(double size, double posX, double posY, GameInformation gameInformation) {
        super(size, posX, posY, gameInformation);
        initializeVariables();
    }

    /**
     *  <br>    Creates a new colored ball
     *  <br><br>
     *
     *
     * @param size The diameter of the ball
     * @param posX The X-position of the ball
     * @param posY The Y-position of the ball
     * @param gameInformation The GameInformation class containing all information of the current game
     * @param color The color of the ball
     */
    public ColorBall(double size, double posX, double posY, GameInformation gameInformation, Color color) {
        super(size, posX, posY, gameInformation);
        this.color=color;
        initializeVariables();
    }

    /**
     *  <br>    Creates a new colored ball
     *  <br><br>
     *
     *
     * @param pos The position of the ball <br> {x,y}
     * @param gameInformation The GameInformation class containing all information of the current game
     */
    public ColorBall(double[] pos, GameInformation gameInformation) {
        super(pos, gameInformation);
        initializeVariables();
    }

    private void initializeVariables(){
        pencil = new Buntstift();
    }

    //javadoc is kept from the overridden function
    //draws the ball
    @Override
    public void draw(){
        double [] pos = getPos();
        // move to the balls position
        pencil.bewegeBis(pos[0],pos[1]);

        //sets the color
        pencil.setzeFuellmuster(Muster.GEFUELLT);
        pencil.setzeFarbe(color);


        //draw the ball
        pencil.zeichneKreis(getSize()/2);

    }

    //javadoc is kept from the overridden function
    //does the cleanup
    @Override
    public void cleanup() {
        pencil.gibFrei();
        super.cleanup();
    }

    /**
     *  <br>    Gets the color of the ball
     *  <br><br>
     *
     * @return The balls color
     */
    public Color getColor() {
        return color;
    }

    /**
     *  <br>    Sets the color of the Ball
     *  <br><br>
     *
     * @param color The balls color
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     *  <br>    Sets the color of the Ball
     *  <br><br>
     *
     * @param red The red value of the balls color
     * @param green The green value of the balls color
     * @param blue The blue value of the balls color
     */
    public void setColorRGB(int red, int green, int blue) {
        this.color = new Color(red,green,blue);
    }
}
