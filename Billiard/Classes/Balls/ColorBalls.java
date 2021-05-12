package Classes.Balls;

import Classes.Ball;
import Classes.GameInformation;
import sum.kern.Buntstift;
import sum.kern.Muster;
import sum.kern.Stift;

import java.awt.*;

public class ColorBalls extends Ball{

    private Buntstift pencil;

    private Color color;

    public ColorBalls(double size, double[] pos, double[] vel, GameInformation gameInformation) {
        super(size, pos, vel, gameInformation);
        pencil=new Buntstift();
    }

    public ColorBalls(double size, double[] pos, GameInformation gameInformation) {
        super(size, pos, gameInformation);
        initializeVariables();
    }

    public ColorBalls(double size, double posX, double posY, GameInformation gameInformation) {
        super(size, posX, posY, gameInformation);
        initializeVariables();
    }

    public ColorBalls(double size, double posX, double posY, GameInformation gameInformation, Color color) {
        super(size, posX, posY, gameInformation);
        this.color=color;
        initializeVariables();
    }

    public ColorBalls(double[] pos, GameInformation gameInformation) {
        super(pos, gameInformation);
        initializeVariables();
    }

    private void initializeVariables(){
        pencil = new Buntstift();
    }

    @Override
    //draws the ball
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setColor(int red, int green, int blue) {
        this.color = new Color(red,green,blue);
    }
}
