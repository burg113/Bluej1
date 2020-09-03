package Classes;

import sum.kern.*;

public class Program {
    Bildschirm screen;
    Stift pencil;
    
    public Program(int ){
        screen=new Bildschirm();
        pencil=new Stift();
    }

    public void sampleMethod(int x,int y)    {
        pencil.runter();
        pencil.bewegeBis(x,y);
        
    }
}
