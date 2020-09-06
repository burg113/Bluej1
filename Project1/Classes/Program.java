package Classes;

import sum.kern.*;

public class Program {
    Bildschirm screen;
    Stift pencil;
    Drawing draw;
    public Program(int xSize, int ySize) {
        screen = new Bildschirm(xSize, ySize);
        pencil = new Stift();
        draw=new Drawing(screen,pencil);

        draw.polygon(100,200,100,3);
        draw.polygon(250,200,100,4);
        draw.polygon(400,200,70,5);
        draw.algorithme(100,300,0,100,144,5);
        draw.asterisk(300,300,8,50);
        draw.circle(440,300,50);

    }
}

