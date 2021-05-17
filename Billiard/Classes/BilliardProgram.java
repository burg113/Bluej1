package Classes;

import Classes.Balls.*;
import Classes.Figurstift;
import sum.kern.*;

import java.awt.*;

/*

    from 6.17

     Zahlkugel und Spurkugel

    hitboxes


 */
/**
 *          The BilliardProgram class is a Billiard simulation.
 *  <br>
 *  <br>    When instantiating this class the program is automatically started.
 *  <br><br>
 *
 * @version 1.0
 * @author Lennart B
 */
public class BilliardProgram {

    //all the needed Objects are declared
    Figurstift pencil;
    Bildschirm screen;

    GameInformation gameInformation;

    //variables that will not be changed while the program is running
    static final float maxFrameRate=144;

    private final int screenWidth;
    private final int screenHeight;

    /**
     *  <br>    Start the Billiard simulation.
     *  <br><br>
     *
     * @param screenWidth   The width of the program window
     * @param screenHeight  The height of the program window
     */

    public BilliardProgram(int screenWidth, int screenHeight) {
        //variables are assigned
        this.screenWidth=screenWidth;
        this.screenHeight=screenHeight;
        screen = new Bildschirm(screenWidth,screenHeight);

        pencil = new Figurstift();

        //starts the gameloop
        run();

        cleanup();
    }

    /**
     *  <br>    Runs the Billiard Game.
     *  <br>
     *  <br>    It is automatically started when this class is instantiated.
     *  <br><br>
     */

    // Game Loop
    public void run() {


        BilliardTable billiardTable=new BilliardTable(150,100,1000,500);

        gameInformation=new GameInformation(billiardTable);
        gameInformation.setCollisionEnergyLoss(0.1);
        //creates test balls
        for (int i=0;i<6;i++){
            for (int i2=0;i2<3;i2++) {
                /*Ball ball = new FrictionBalls(20 + 40 * Math.random(), 250 + i * 100, 200+i2*100, gameInformation);
                Ball ball = new ColorBalls(20 + 40 * Math.random(), 250 + i * 100, 200+i2*100, gameInformation,
                        new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
                Ball ball = new PulsatingBall(20 + 40 * Math.random(), 250 + i * 100, 200+i2*100, gameInformation);
                Ball ball = new NumberedBall(20 + 40 * Math.random(), 250 + i * 100, 200+i2*100, gameInformation, 1+i*6+i2);
                Ball ball = new TraceBall(20 + 40 * Math.random(), 250 + i * 100, 200+i2*100, gameInformation);
                Ball ball = new GravityBall(20 + 40 * Math.random(), 250 + i * 100, 200+i2*100, gameInformation);*/
                double size = 20 + 40 * Math.random();
                Ball ball = new CollisionBall(size, 250 + i * 100, 200+i2*100, gameInformation);
                ball.setMass(size);
                ball.setVel(500 * (Math.random() - 0.5), 500 * (Math.random() - 0.5));
                gameInformation.addBall(ball);
            }
        }


        while(true) {
            double time = System.nanoTime();
            // enforces the frame rate limit
            while (System.nanoTime() < time + 1000000000 / maxFrameRate) {}

            //computes the time the last frame took
            double frameTime = (System.nanoTime() - time) / 1000000000;
            //System.out.println("Fps: " + Math.round(1 / frameTime) + "        the last frame took:" + frameTime);

            //clear screen to erase last frame
            screen.loescheAlles();

            //draw the billiard table
            billiardTable.draw();

            //update all balls
            for (Ball ball : gameInformation.getBalls()) {
                ball.update(frameTime);
            }


        }

    }

    /**
     *  <br>    Does the cleanup. It should only be run when the program finished executing!
     *  <br>
     *  <br>    This is automatically run when the program finishes. (Which it currently does not do!)
     *  <br><br>
     */
    public void cleanup(){
        screen.gibFrei();
        pencil.gibFrei();
    }



}