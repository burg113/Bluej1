/*



        !!!!!KOMMENTIEREN!!!!!



 */
package Classes;

import sum.kern.*;

import java.util.Vector;

public class DartProgram {

    Bildschirm screen;
    Stift pencil;
    Maus mouse;
    Tastatur keyboard;
    Buntstift colourPencil;

    float dartRotation=0;
    float dartHeight=0;
    float maxFrameRate=30;

    public DartProgram(int xSize, int ySize) {

        screen = new Bildschirm(xSize, ySize);
        pencil = new Stift();
        mouse = new Maus();
        keyboard = new Tastatur();
        colourPencil = new Buntstift();
        Dart dart=new Dart(0,0,0,0);
        double time = System.nanoTime();
        while(!mouse.doppelKlick()) {
            while(System.nanoTime()<time+1000000000/maxFrameRate) System.out.println(time);
            time = System.nanoTime();

            drawDartBoard(screen.breite() / 5 * 4, screen.hoehe() / 2, 100);

            dartHeight++;
            dart.deleteDart();
            dart=new Dart(screen.breite() / 5, dartHeight%screen.hoehe(), 100, dartRotation);
            dart.drawDart();
        }

        screen.gibFrei();
        pencil.gibFrei();
        mouse.gibFrei();
        keyboard.gibFrei();
        colourPencil.gibFrei();
    }

    void drawDartBoard(float x,float y,float size){
        pencil.hoch();
        pencil.bewegeBis(x,y);
        pencil.runter();
        for(int i=0;i <5;i++) {
            pencil.zeichneKreis(size*i/5);
        }

    }




    private class Dart{
        float x;
        float y;
        float length;
        float rotation;
        Dart(float x,float y,float length,float rotation){
            this.x=x;
            this.y=y;
            this.length=length;
            this.rotation=rotation;
        }

        public void drawDart() {
            pencil.normal();
            pencil.hoch();
            pencil.bewegeBis(x, y);
            pencil.runter();
            pencil.dreheBis(rotation);
            pencil.bewegeUm(length);
        }

        public void deleteDart(){
            pencil.radiere();
            pencil.hoch();
            pencil.bewegeBis(x, y);
            pencil.runter();
            pencil.dreheBis(rotation);
            pencil.bewegeUm(length);

        }

    }

}
