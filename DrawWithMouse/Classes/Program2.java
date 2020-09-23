package Classes;

import sum.kern.Bildschirm;
import sum.kern.Maus;
import sum.kern.Stift;
import sum.kern.Tastatur;

public class Program2 {

    Bildschirm screen;
    Stift pencil;
    Maus mouse;
    Tastatur keyboard;

    float smoothMousePosX=0;
    float smoothMousePosY=0;
    float smoothnesFactor =0.5f;

    public Program2(int xSize, int ySize) {

        screen = new Bildschirm(xSize, ySize);
        pencil = new Stift();
        mouse = new Maus();
        keyboard = new Tastatur();

        smoothMousePosX = mouse.hPosition();
        smoothMousePosY = mouse.vPosition();

        do{
            if(keyboard.wurdeGedrueckt()){
                pencil.radiere();
            }else{
                pencil.normal();
            }

            if(mouse.istGedrueckt()) {
                pencil.bewegeBis(smoothMousePosX,smoothMousePosY);
                pencil.runter();
            }else{
                pencil.hoch();
            }
            moveSmooth(mouse.hPosition(), mouse.vPosition());
        } while (!mouse.doppelKlick());

        screen.gibFrei();
        pencil.gibFrei();
        mouse.gibFrei();
    }

    void moveSmooth(float x,float y){
        smoothMousePosX+=(x-smoothMousePosX)*smoothnesFactor;
        smoothMousePosY+=(y-smoothMousePosY)*smoothnesFactor;
    }



}
