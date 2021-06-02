package Classes;

import Classes.Balls.CollisionBall;
import Classes.RenderableObjects.*;
import sum.kern.*;


/**
 *          The BilliardProgram class is a Billiard simulation.
 *  <br>
 *  <br>    When instantiating this class the program is automatically started.
 *  <br><br>
 *
 * @version 1.0
 * @author Lennart B
 */
public class CalculatorProgram {

    //all the needed Objects are declared
    Figurstift pencil;
    Bildschirm screen;
    Maus mouse;

    //variables that will not be changed while the program is running
    static final float maxFrameRate = 144;

    private final int screenWidth;
    private final int screenHeight;

    public CalculatorProgram(int screenWidth, int screenHeight) {
        //variables are assigned
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        screen = new Bildschirm(screenWidth, screenHeight);

        pencil = new Figurstift();

        mouse = new Maus();

        run();

    }

    public void run() {

        Text text = new Text("hallo",0, 100);
        text.setWritingSize(40);
        int x = 0;

        while (!mouse.doppelKlick()) {
            double time = System.nanoTime();
            // enforces the frame rate limit
            while (System.nanoTime() < time + 1000000000 / maxFrameRate) {
            }

            //computes the time the last frame took
            double frameTime = (System.nanoTime() - time) / 1000000000;
            //System.out.println("Fps: " + Math.round(1 / frameTime) + "        the last frame took:" + frameTime);

            //clear screen to erase last frame
            screen.loescheAlles();

            x++;
            text.setPosition(x, 100);
            text.render();


        }

    }
}