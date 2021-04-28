package Classes;


import java.util.ArrayList;
import java.util.List;

/** the class that holds all of the important Information about the game
 *
 *
 *
 */
public class GameInformation {

    private List<Ball> balls;
    private int ballSize;
    private BilliardTable billiardTable;

    GameInformation(BilliardTable billiardTable){
        this.billiardTable=billiardTable;
        balls=new ArrayList<Ball>();
    }

    public List<Ball> getBalls() {
        return balls;
    }

    public void setBalls(List<Ball> balls) {
        this.balls = balls;
    }

    public void addBall(Ball ball) {
        this.balls.add(ball);
    }

    public void addBalls(List<Ball> balls) {
        this.balls.addAll(balls);
    }

    public int getBallSize() {
        return ballSize;
    }

    public void setBallSize(int ballSize) {
        this.ballSize = ballSize;
    }

    public BilliardTable getBilliardTable() {
        return billiardTable;
    }


}
