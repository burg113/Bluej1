package Classes;

import sum.kern.*;

import java.util.Vector;

public class DrawWithMouseProgramm {

    int mode=2;

    Bildschirm screen;
    Stift pencil;
    Maus mouse;
    Tastatur keyboard;
    Buntstift colourPencil;

    float smoothMousePosX=0;
    float smoothMousePosY=0;
    float smoothnesFactor =0.5f;

    boolean mousePressed=false;

    int pencilSize=1;

    public DrawWithMouseProgramm(int xSize, int ySize) {

        screen = new Bildschirm(xSize, ySize);
        pencil = new Stift();
        mouse = new Maus();
        keyboard = new Tastatur();
        colourPencil = new Buntstift();


        if(mode==0)zeichneFreihand();
        else if(mode==1)zeichneLinien();
        else if(mode==2)zeichneFarbig();
        else System.out.println("No part of the program was executed. Check your mode ("+mode+")");


        screen.gibFrei();
        pencil.gibFrei();
        mouse.gibFrei();
        keyboard.gibFrei();
        colourPencil.gibFrei();
    }

    void zeichneFreihand(){
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


    }

    void zeichneLinien(){
        do{
            if(mouse.istGedrueckt()&&!mousePressed) {
                pencil.hoch();
                pencil.bewegeBis(mouse.hPosition(),mouse.vPosition());
                pencil.zeichneKreis(2);
                mousePressed=true;
            }
            if(!mouse.istGedrueckt()&&mousePressed){
                pencil.runter();
                pencil.bewegeBis(mouse.hPosition(),mouse.vPosition());
                pencil.zeichneKreis(2);
                mousePressed=false;
            }
        } while (!mouse.doppelKlick());


    }

    void zeichneFarbig(){

        smoothMousePosX = mouse.hPosition();
        smoothMousePosY = mouse.vPosition();
        do{
            while(keyboard.wurdeGedrueckt()){
                try {
                    if (keyboard.zeichen() == 'r') colourPencil.setzeFarbe(Farbe.rgb(200, 0, 0));
                    else if (keyboard.zeichen() == 'g') colourPencil.setzeFarbe(Farbe.rgb(0, 200, 0));
                    else if (keyboard.zeichen() == 'b') colourPencil.setzeFarbe(Farbe.rgb(0, 0, 200));
                    else if (keyboard.zeichen() == 'j') colourPencil.setzeFarbe(Farbe.rgb(200, 200, 0));
                    else if (keyboard.zeichen() == 'o') colourPencil.setzeFarbe(Farbe.rgb(200, 150, 0));

                    else if (Integer.parseInt("" + keyboard.zeichen()) >= 0) {
                        pencilSize = Integer.parseInt("" + keyboard.zeichen());
                    }
                }catch(NumberFormatException e){
                    colourPencil.setzeFarbe(Farbe.rgb(0, 0, 0));
                }

                keyboard.weiter();
            }

            colourPencil.setzeLinienBreite(pencilSize);

            if(mouse.istGedrueckt()) {
                colourPencil.bewegeBis(smoothMousePosX,smoothMousePosY);
                colourPencil.runter();
            }else{
                colourPencil.hoch();
            }
            moveSmooth(mouse.hPosition(), mouse.vPosition());
        } while (!mouse.doppelKlick());



    }


    void moveSmooth(float x,float y){
        smoothMousePosX+=(x-smoothMousePosX)*smoothnesFactor;
        smoothMousePosY+=(y-smoothMousePosY)*smoothnesFactor;
    }



}
