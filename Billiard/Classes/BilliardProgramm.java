package Classes;

import Classes.Figurstift;
import sum.kern.*;

/*

    after 6.14

    hitboxes


 */
/**
 *  <br>    This is a Billiard program.
 *  <br>
 *  <br>    When instantiating this class the program is automatically started.
 *  <br>
 *
 * @version 1.0
 * @author Lennart B
 */
public class BilliardProgramm {

    //all the needed Objects are declared
    Figurstift pencil;
    Bildschirm screen;

    GameInformation gameInformation;

    //variables that will not be changed while the program is running
    static final float maxFrameRate=144;

    private int screenWidth;
    private int screenHeight;

    /**
     *  <br>    When called the Billiard simulation will automatically start.
     *
     * @param screenWidth   The width of the program window
     * @param screenHeight  The height of the program window
     */

    public BilliardProgramm(int screenWidth, int screenHeight) {
        this.screenWidth=screenWidth;
        this.screenHeight=screenHeight;
        screen = new Bildschirm(screenWidth,screenHeight);

        pencil = new Figurstift();

        //starts the gameloop
        run();

        cleanup();
    }

    /**
     *  <br>    This function runs the Billiard Game.
     *  <br>
     *  <br>    This is automatically Started when this Class is instantiated.
     */

    // Game Loop
    public void run() {


        BilliardTable billiardTable=new BilliardTable(150,100,1000,500);

        gameInformation=new GameInformation(billiardTable);

        //creates test balls
        for (int i=0;i<6;i++){
            for (int i2=0;i2<3;i2++) {
                Ball ball = new Ball(20 + 40 * Math.random(), 250 + i * 100, 200+i2*100, gameInformation);
                ball.setVel(200 * (Math.random() - 0.5), 200 * (Math.random() - 0.5));
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
            time = System.nanoTime();

            //clear screen to earase last frame
            screen.loescheAlles();

            billiardTable.draw();
            //update all balls
            for (Ball ball : gameInformation.getBalls()) {
                ball.update(frameTime);
            }


        }

    }

    /**
     *  <br>    This function does the cleanup. It should only be run when the program finished executing!
     *  <br>
     *  <br>    This is automatically run when the program finises. (Which it currently does not do!)
     */
    public void cleanup(){
        screen.gibFrei();
        pencil.gibFrei();

    }



}