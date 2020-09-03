package Classes;

import sum.kern.*;

public class Program {
    Bildschirm screen;
    Stift pencil;

    public Program(int xSize,int ySize){
            screen=new Bildschirm(xSize,ySize);
            pencil=new Stift();
    }


    public void square(int x,int y,int xSize,int ySize){
        pencil.normal();
        pencil.bewegeBis(x, y);
        pencil.runter();
        pencil.bewegeBis(x+xSize, y);
        pencil.bewegeBis(x+xSize, y+ySize);
        pencil.bewegeBis(x, y+ySize);
        pencil.bewegeBis(x, y);


    }

    public void circle(int x,int y, int radius){
        pencil.normal();
        pencil.bewegeBis(x, y+radius);
        pencil.runter();
        float angle=0;
        for(int i=0;i<radius*10;i++){
            angle=i*(float)Math.PI/(radius*5);
            System.out.println(x+Math.sin(angle)*radius+"  "+y+Math.cos(angle)*radius);
            pencil.bewegeBis(x+Math.sin(angle)*radius,y+Math.cos(angle)*radius);
        }


    }

}

