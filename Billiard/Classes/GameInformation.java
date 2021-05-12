package Classes;


import java.util.ArrayList;
import java.util.List;

/**
 *          The GameInformation class is a variable container, holding all of the important information about the game.
 *  <br><br>
 *
 * @version 1.0
 * @author Lennart B
 */

public class GameInformation {

    //needed variables are declared
    private int ballSize;

    //needed objects are declared
    private List<Ball> balls;
    private BilliardTable billiardTable;

    /**
     *  <br>    Creates the GameInformation of a billiard game
     *  <br><br>
     *
     * @param billiardTable The BilliardTable the game is played on
     */
    GameInformation(BilliardTable billiardTable){
        //assigns variables
        this.billiardTable=billiardTable;
        balls=new ArrayList<Ball>();
    }

    /**
     *  <br>    Gets a List of all balls that belong to this game
     *  <br><br>
     *
     * @return A List containing all the balls
     */
    public List<Ball> getBalls() {
        return balls;
    }

    /**
     *  <br>    Sets all of the balls that belong to this game
     *  <br><br>
     *
     * @param balls A List of all Balls
     */
    public void setBalls(List<Ball> balls) {
        this.balls = balls;
    }

    /**
     *  <br>    Adds a ball to the current game
     *  <br><br>
     *
     * @param ball The ball that should be added
     */
    public void addBall(Ball ball) {
        this.balls.add(ball);
    }

    /**
     *  <br>    Adds balls to the current game
     *  <br><br>
     *
     * @param balls A List containing all the balls that should be added
     */
    public void addBalls(List<Ball> balls) {
        this.balls.addAll(balls);
    }

    /**
     *  <br>    Gets the size all balls should have
     *  <br><br>
     *
     * @return The diameter all balls should have
     */
    public int getBallSize() {
        return ballSize;
    }

    /**
     *  <br>    Sets the size all balls should have
     *  <br><br>
     *
     * @param ballSize The diameter all balls should have
     */
    public void setBallSize(int ballSize) {
        this.ballSize = ballSize;
    }

    /**
     *  <br>    Gets the BilliardTable the game is played on
     *  <br><br>
     *
     * @return The BilliardTable the game is played on
     */
    public BilliardTable getBilliardTable() {
        return billiardTable;
    }


}
