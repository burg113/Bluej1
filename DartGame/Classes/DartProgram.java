package Classes;

import sum.kern.*;
import java.awt.*;


public class DartProgram {

    //all the needed Objects are declared
    Bildschirm screen;
    Buntstift cPencil;
    Maus mouse;
    Tastatur keyboard;
    Stift pencil;

    //variables that will not be changed while the program is running
    static final float maxFrameRate=144;


    public DartProgram(int xSize, int ySize) {

        // assigning all objects
        screen = new Bildschirm(xSize, ySize);
        cPencil = new Buntstift();
        mouse = new Maus();
        keyboard = new Tastatur();
        pencil=new Stift();
        // assigning dart and Dartboard
        Dart dart=new Dart(200, 0,70, 0);
        DartBoard dartBoard=new DartBoard(1700,540, 120);


        // declaring and assigning other needed variables
        double time = System.nanoTime();

        // the state keeps track of the state the program is currently in
        //  0 = dart falling
        //  1 = dart rotating
        //  2 = dart flying
        //  3 = dart has hit
        int state=0;


        // lets dart fall down at the beginning
        dart.setVelocity(0,250);
        dart.setNoGravity(true);

        //game loop
        while(!mouse.doppelKlick()) {
            // enforces the frame rate limit
            while(System.nanoTime()<time+1000000000/maxFrameRate);
            double frameTime=(System.nanoTime()-time)/1000000000;
            System.out.println("Fps: "+ Math.round(1/frameTime)+"        the last frame took:"+frameTime );
            time = System.nanoTime();

            // draws the dart Board
            dartBoard.draw();

            //System.out.println(state);

            // in the following the different program states are advanced
            if(state == 0 && mouse.istGedrueckt()) {                // this happens when the mouse is pressed. the 1st state (dart dropping down) is ended and the program advances into the 2nd (dart rotating)
                state +=1 ;                                         // advances the state variable
                dart.setNoGravity(true);                            // the dart should not be affected by gravity when rotating as it should not move
                dart.setVelocity(0,0,140);                          // the x and y velocity are set to 0 so that the dart wont move. the rotational Velocity however is set so that the dart rotates

            }else if(state == 1&&!mouse.istGedrueckt()){            // this happens when the mouse is released. the 2st state (dart rotating) is ended and the program advances into the 3nd (dart flying)
                state +=1 ;                                         // advances the state variable
                dart.setVelocity(0,0,0);                            // the darts velocity is at first set to 0 so that it does not keep on rotating
                dart.shoot(1500);                                   // the dart is shot [moves with the passed in speed in the direction it is currently pointing]
                dart.setNoGravity(false);                           // the dart should be affected by gravity while flying
                dart.setFlying(true);                               // this tells the dart that it is able to rotate freely (into the direction it is flying). This makes the dart rotate while its flight path is curving

            }else if(state == 2 && dart.hit(dartBoard)){            // this happens when the dart hits the ceiling, the floor, either of the walls or the target. the 3nd state (dart flying) is ended and the program advances into the 4nd (dart resting)
                state +=1 ;                                         // advances the state variable
                dart.setVelocity(0,0,0);                            // the darts velocity is set to 0 as it is not supposed to move
                dart.setNoGravity(true);                            // the dart should for the same reason also not be affected by gravity
                dart.setFlying(false);                              // the dart is also told that it is no longer flying so that it retains its current rotation

            }

            // the darts movement function is called independently of the programs state. however in some states its velocity is 0 which makes it not move
            dart.move(frameTime);

        }

        //closing the program
        screen.gibFrei();
        pencil.gibFrei();
        mouse.gibFrei();
        keyboard.gibFrei();
        cPencil.gibFrei();
    }





    private class DartBoard{
        // the variables for the dart board are  declared
        private float x;        // x is the dart boards x-position      |note:  the x is between 0 to 1920. The y is between 0 to 1080
        private float y;        // y is the dart boards y-position      |       the coordinates are transformed from this coordinate system to screen space when drawing
        private float size;     // this is the dart boards size         |       the size is also scaled according to the screens width

        // the constructor
        DartBoard(float x,float y,float size){
            this.x=x;
            this.y=y;
            this.size=size;
        }

        // this function draws the dart board and the wall above and below it
        public void draw() {
            // the board is drawn
            cPencil.hoch();
            cPencil.bewegeBis((float)screen.breite()*x/1920, (float)screen.hoehe()*y/1080);
            cPencil.setzeFuellmuster(Muster.GEFUELLT);
            pencil.hoch();
            pencil.bewegeBis((float)screen.breite()*x/1920, (float)screen.hoehe()*y/1080);

            Color [] colors={Color.YELLOW,Color.RED,Color.BLUE,Color.BLACK,Color.white};
            for(int i=4;i >=0;i--) {
                cPencil.setzeFarbe(colors[i]);
                cPencil.zeichneKreis(size*i/4*screen.breite()/1920);
                pencil.zeichneKreis(size*i/4*screen.breite()/1920);
                if(i!=1) {
                    pencil.zeichneKreis(size * ((i - 0.5f) / 4) * screen.breite() / 1920);
                }
            }
            pencil.zeichneKreis(size * ((0.6f) / 4) * screen.breite() / 1920);

            cPencil.zeichneKreis(size/12*screen.breite()/1920);
            pencil.zeichneKreis(size * ((0.15f) / 4) * screen.breite() / 1920);

            // the wall is drawn
            pencil.hoch();
            pencil.bewegeBis((float)screen.breite()*x/1920, (float)screen.hoehe()*y/1080+size*screen.breite()/1920);
            pencil.runter();
            pencil.bewegeBis((float)screen.breite()*x/1920, screen.hoehe());
            pencil.hoch();
            pencil.bewegeBis((float)screen.breite()*x/1920, (float)screen.hoehe()*y/1080-size*screen.breite()/1920);
            pencil.runter();
            pencil.bewegeBis((float)screen.breite()*x/1920, 0);
            pencil.hoch();
        }

    }


    private class Dart{
        // the variables for the dart are  declared
        private float x;                    // x is the dart boards x-position      |note:  the x is between 0 to 1920. The y is between 0 to 1080
        private float y;                    // y is the dart boards y-position      |       the coordinates are transformed from this coordinate system to screen space when drawing (this is done to allow for different screen sizes)
        private float xVel;                 // xVel is the darts Velocity in parallel to the x-axis     |note:  the value describes the amount the dart will move in the coordinate system per second
        private float yVel;                 // yVel is the darts Velocity in parallel to the y-axis     |       keep in mind that this is NOT the movement in pixels per second (as these are all values in a coordinate system not equivalent to screen space)
        private float rotationalVelocity;   // this is the darts rotational velocity. It is  the angle in degrees the dart will rotate in one second.
        private float length;               // this is the darts size
        private float rotation;             // this is the angle the dart is currently rotated at
        private boolean visible;            // this variable dictates whether the dart is drawn on screen

        final float gravity = 500;          // this is the gravity pulling the dart down. It is describes the amount the darts velocity is increased in one second
        private boolean noGravity;          // this toggles the gravity on or of

        private boolean flying;             // this keeps the information on whether the dart is currently flying through the air

        //the constructor
        Dart(float x,float y,float length,float rotation){
            this.x=x;
            this.y=y;
            this.length=length;
            this.rotation=rotation;
            this.visible=true;
            xVel=0;
            yVel=0;
            noGravity=false;
            rotationalVelocity=0;
        }



        // this method can be used to move the dart to a specific rotation [not used]
        public void moveTo(float x,float y,float rotation){
            erase();
            this.x=x;
            this.y=y;
            this.rotation=rotation;
            draw();
        }

        // this method moves the dart according to its current velocity and gravity (when it is enabled)
        public void move(double time){
            erase();                        // the dart currently drawn on the screen is erased before the dart is moved
            x += xVel*time;                 // the dart is moved according to its velocity      |note:  the movement is scaled with the 'time' variable.
            y += yVel*time;                 // the dart is moved according to its velocity      |       this is done to make the darts speed independent from the programs frame rate

            if(!noGravity) {
                yVel += gravity * time;     // gravity is applied when activated
                 y += gravity * time / 2;   // this is to make the gravity more realistic. see Δs = v*t + a*t^2
            }

            if(!flying) {
                rotation += rotationalVelocity*time;                    // when the dart is not flying it is rotated according to its rotational velocity
                checkBoundary();                                        // this makes the dart go to the top of the screen once it reaches the bottom in program state 0
            }else{
                rotation = (float)(Math.atan(-yVel/xVel)*180/Math.PI);  // this rotates the dart according to its flight direction in program state 2
                if(xVel<0){
                    rotation=rotation-180;                              // this has to be done as the atan will only give out the angle between 0 and 180 instead of between 0 and 360
                }
            }


            draw();     // the dart is drawn at its new position
        }

        // this function moves the dart to the top of the screen once it reaches the bottom in program state 2
        private void checkBoundary(){
            if(y>1080||y<0){
                y=(y%1080+1080)%1080;       // this is overcomplicated for this example however it is needed when accounting for being above as well as under the screen
            }
        }

        // this function shoots the dart in the direction it is currently facing
        public void shoot(float speed){
            xVel = (float)Math.cos(rotation/180*Math.PI)*speed;     // the x velocity is set
            yVel = -(float)Math.sin(rotation/180*Math.PI)*speed;    // the y velocity is set
        }

        // this fuction is a setter for the 'flying' variable'
        public void setFlying(boolean flying){
            this.flying=flying;
        }

        // this function (with the help of the following two) determines whether the dart hit the ceiling, floor or either of the walls
        boolean hit(DartBoard dartBoard) {
            return furthestPoint() > dartBoard.x || furthestPoint() < 0 || highestPoint() > 1080 || highestPoint() < 0;
        }
        public float furthestPoint() {
            return x + (float) Math.cos(rotation / 180 * Math.PI) * length / 2;
        }
        private float highestPoint(){
            return y-(float)Math.sin(rotation/180*Math.PI)*length/2;
        }

        // this function is a setter for the x as well as y velocity of the dart
        public void setVelocity(float xVel,float yVel){
            setVelocity(xVel,yVel,0);
        }

        // this function is a setter for the x, y and rotational velocity of the dart
        public void setVelocity(float xVel,float yVel,float rotationalVelocity){
            this.xVel = xVel;
            this.yVel = yVel;
            this.rotationalVelocity = rotationalVelocity;
        }

        // this function can be used to accelerate the dart with a force [not used]
        public void Accelerate(float xVel,float yVel){
            this.xVel += xVel;
            this.yVel += yVel;
        }

        // this is a setter for the 'noGravity' variable
        public void setNoGravity(boolean noGravity){
            this.noGravity=noGravity;
        }

        //this function draws the dart
        private void draw() {
            if(visible) {
                pencil.normal();
                shape();
            }
        }

        //this function erases the dart
        private void erase() {
            pencil.radiere();
            shape();
        }

        //this is the function used for both drawing and erasing the dart
        private void shape(){
            //System.out.println(rotation);

            // the pencil is moved to the back of the dart
            pencil.hoch();
            pencil.bewegeBis((float)screen.breite()*x/1920, (float)screen.hoehe()*y/1080);
            pencil.dreheBis(rotation);
            pencil.bewegeUm(-length/2*screen.breite()/1920);
            pencil.runter();

            // the back of the dart is drawn
            for(int i=0;i<3;i++) {
                pencil.dreheUm(120);
                pencil.bewegeUm(length * screen.breite() / 1920 / 10);
                pencil.dreheUm(180);
                pencil.bewegeUm(length * screen.breite() / 1920 / 10);
                pencil.dreheUm(180 - 2 * 120);
                pencil.bewegeUm(length * screen.breite() / 1920 / 10);
                pencil.dreheUm(180);
                pencil.bewegeUm(length * screen.breite() / 1920 / 10);
                pencil.dreheUm(120 + 180);
                pencil.bewegeUm(length * screen.breite() / 1920 / 10);
            }

            // the long middle part of the dart is drawn
            pencil.bewegeUm(length*screen.breite()/1920/10*7);

            // the front of the dart is drawn
            pencil.dreheUm(160);
            pencil.bewegeUm(length*screen.breite()/1920/10);
            pencil.dreheUm(180);
            pencil.bewegeUm(length*screen.breite()/1920/10);
            pencil.dreheUm(180-2*160);
            pencil.bewegeUm(length*screen.breite()/1920/10);
            pencil.dreheUm(-110);
            pencil.bewegeUm(length*screen.breite()/1920/20);
        }

    }

}
