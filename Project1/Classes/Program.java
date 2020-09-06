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
        draw.triangle(100,100,100);
    }
}

