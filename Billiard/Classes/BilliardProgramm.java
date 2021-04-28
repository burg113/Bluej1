package Classes;

import Classes.Figurstift;
import sum.kern.*;

/*

    erase after frame

    hitboxes


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

    public BilliardProgramm(int screenWidth, int screenHeight) {
        this.screenWidth=screenWidth;
        this.screenHeight=screenHeight;
        screen = new Bildschirm(screenWidth,screenHeight);

        pencil = new Figurstift();

        //starts the gameloop
        run();

        cleanup();
    }

    // Game Loop
    public void run() {


        BilliardTable billiardTable=new BilliardTable(200,100,800,600);

        gameInformation=new GameInformation(billiardTable);

        for (int i=0;i<6;i++){
            Ball ball =new Ball(20+i*5,200+i*100,300,gameInformation);
            ball.setVel(5,3);
            gameInformation.addBall(ball);
        }

        while(true) {
            double time = System.nanoTime();
            // enforces the frame rate limit
            while (System.nanoTime() < time + 1000000000 / maxFrameRate) {
                double frameTime = (System.nanoTime() - time) / 1000000000;
                //System.out.println("Fps: " + Math.round(1 / frameTime) + "        the last frame took:" + frameTime);
                time = System.nanoTime();

                for (Ball ball : gameInformation.getBalls()) {
                    ball.update(frameTime);
                }

            }
        }

    }


    public void cleanup(){
        screen.gibFrei();
        pencil.gibFrei();

    }



}