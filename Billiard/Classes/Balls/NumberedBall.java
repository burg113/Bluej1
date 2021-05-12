package Classes.Balls;

import Classes.Ball;
import Classes.GameInformation;
import sum.kern.Stift;

public class NumberedBall extends Ball {

    private int number;
    private Stift pencil;

    public NumberedBall(double size, double[] pos, double[] vel, GameInformation gameInformation) {
        super(size, pos, vel, gameInformation);
        pencil = new Stift();
    }

    public NumberedBall(double size, double[] pos, GameInformation gameInformation) {
        super(size, pos, gameInformation);
        pencil = new Stift();
    }

    public NumberedBall(double size, double posX, double posY, GameInformation gameInformation, int number) {
        super(size, posX, posY, gameInformation);
        this.number=number;
        pencil = new Stift();
    }

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

        // move to the balls position
        pencil.bewegeBis(pos[0],pos[1]);

        //draw the ball
        pencil.zeichneKreis(getSize()/2);

        //center number
        pencil.bewegeBis(pos[0]-4-3*((int)Math.log10(number)),pos[1]+6);

        //write number
        pencil.schreibeZahl(number);

    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
