 package testProject;

import sum.kern.*;

public class Programm {
    Bildschirm screen;
    Stift pencil;
    
    public Programm(){
        screen=new Bildschirm();
        pencil=new Stift();
    }

    public void sampleMethod(int x,int y)    {
        pencil.runter();
        pencil.bewegeBis(x,y);
        
    }
}
