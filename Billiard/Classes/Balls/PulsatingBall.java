package Classes.Balls;

import Classes.Ball;
import Classes.GameInformation;
import com.sun.istack.internal.NotNull;

public class PulsatingBall extends Ball {

    private double minSize;
    private double maxSize;
    private double growingSpeed;

    public PulsatingBall(double size, double[] pos, double[] vel, GameInformation gameInformation) {
        super(size, pos, vel, gameInformation);
        assignVariables(size);
    }

    public PulsatingBall(double size, double[] pos, GameInformation gameInformation) {
        super(size, pos, gameInformation);
        assignVariables(size);
    }

    public PulsatingBall(double size, double posX, double posY, GameInformation gameInformation) {
        super(size, posX, posY, gameInformation);
        assignVariables(size);
    }

    public PulsatingBall(double[] pos,@NotNull GameInformation gameInformation) {
        super(pos, gameInformation);
        assignVariables(gameInformation.getBallSize());
    }

    private void assignVariables(double size){
        minSize=0.5*size;
        maxSize=1.5*size;
        growingSpeed=size*2;
    }



    @Override
    public void update(double deltaTime) {

        double size=getSize();

        if(size+growingSpeed*deltaTime>maxSize){
            size=maxSize;
            growingSpeed*=-1;
        }else if(size+growingSpeed*deltaTime<minSize){
            size=minSize;
            growingSpeed*=-1;
        }else{
            size+=growingSpeed*deltaTime;
        }

        setSize(size);

        super.update(deltaTime);
    }

    public double getMinSize() {
        return minSize;
    }

    public void setMinSize(double minSize) {
        this.minSize = minSize;
    }

    public double getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(double maxSize) {
        this.maxSize = maxSize;
    }

    public double getGrowingSpeed() {
        return growingSpeed;
    }

    public void setGrowingSpeed(double growingSpeed) {
        this.growingSpeed = growingSpeed;
    }
}
