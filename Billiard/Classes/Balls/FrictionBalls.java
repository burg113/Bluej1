package Classes.Balls;

import Classes.Ball;
import Classes.GameInformation;

public class FrictionBalls extends Ball {


    public FrictionBalls(double size, double[] pos, double[] vel, GameInformation gameInformation) {
        super(size, pos, vel, gameInformation);
    }

    public FrictionBalls(double size, double[] pos, GameInformation gameInformation) {
        super(size, pos, gameInformation);
    }

    public FrictionBalls(double size, double posX, double posY, GameInformation gameInformation) {
        super(size, posX, posY, gameInformation);
    }

    public FrictionBalls(double[] pos, GameInformation gameInformation) {
        super(pos, gameInformation);
    }

    @Override
    public void move(double deltaTime) {

        applyFriction(deltaTime);

        super.move(deltaTime);

    }


    private void applyFriction(double deltaTime){

        double [] vel=getVel();


        vel[0]*=1 - 0.6*deltaTime;
        vel[1]*=1 - 0.6*deltaTime;

        setVel(vel[0],vel[1]);

    }


}
