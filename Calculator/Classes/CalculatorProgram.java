package Classes;

import Classes.Balls.CollisionBall;
import Classes.RenderableObjects.*;
import Classes.RenderableObjects.Button;
import sum.kern.*;

import java.util.*;

//fix multiple text fields

public class CalculatorProgram {

    //all the needed Objects are declared
    Figurstift pencil;
    Bildschirm screen;
    Maus mouse;
    Tastatur keyboard;
    GUIRenderer renderer;

    List<Textfield> textfields;

    //variables that will not be changed while the program is running
    static final float maxFrameRate = 60;

    private final int screenWidth;
    private final int screenHeight;

    public CalculatorProgram(int screenWidth, int screenHeight) {
        //variables are assigned
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;

        screen = new Bildschirm(screenWidth, screenHeight);
        pencil = new Figurstift();
        mouse = new Maus();
        keyboard = new Tastatur();

        renderer = new GUIRenderer();

        generateGUI();

        run();

    }

    public void generateGUI(){
        textfields = new ArrayList<Textfield>();

        Button button = new Button("Button",400, 100,400,100, mouse);
        renderer.add(button);

        for(int i=0;i < 6; i++) {
            Textfield textfield = new Textfield(200 + 300*(i%3), 200+200*(int)(i/3), 200, 100, mouse, keyboard);
            System.out.println(200+200*(int)(i/2));
            renderer.add(textfield);
            textfields.add(textfield);
        }

        button.setWritingSize(40);


    }

    public void run() {

        while (!mouse.doppelKlick()) {
            double time = System.nanoTime();
            // enforces the frame rate limit
            while (System.nanoTime() < time + 1000000000 / maxFrameRate) {}

            //computes the time the last frame took
            double frameTime = (System.nanoTime() - time) / 1000000000;
            System.out.println("Fps: " + Math.round(1 / frameTime) + "        the last frame took:" + frameTime);

            //clear screen to erase last frame
            screen.loescheAlles();

            for(Textfield textfield : textfields) {
                textfield.update();
            }

            renderer.render();
        }

    }
}