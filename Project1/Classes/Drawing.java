package Classes;

import sum.kern.Bildschirm;
import sum.kern.Stift;

public class Drawing {
    Bildschirm screen;
    Stift pencil;

    public Drawing(Bildschirm screen, Stift pencil){
        this.screen=screen;
        this.pencil=pencil;

    }
    public void polygon(float x, float y, int size, int corners){
        algorithme(x,y,0,size,360/corners,corners);
    }


    public void circle(float x,float y, float radius) {
        pencil.normal();
        pencil.hoch();
        pencil.bewegeBis(x, y + radius);
        pencil.runter();
        float angle = 0;
        float percision=1;
        for (int i = 0; i < radius * percision; i++) {
            angle = i * (float) Math.PI * 2 / (radius * percision);
            pencil.bewegeBis(x + Math.sin(angle) * radius, y + Math.cos(angle) * radius);
        }
        pencil.bewegeBis(x + Math.sin(2*Math.PI) * radius, y + Math.cos(2*Math.PI) * radius);
    }

    public void polygon(float[] points){
        pencil.normal();
        pencil.hoch();
        pencil.bewegeBis(points[0],points[1]);
        pencil.runter();
        for(int i=0;i<points.length;i+=2){
            pencil.bewegeBis(points[i],points[i+1]);
        }
        pencil.bewegeBis(points[0],points[1]);

    }

    public void algorithme(float startX,float startY,float startRotation,float length,float rotation,float turns){
        pencil.normal();
        pencil.hoch();
        pencil.bewegeBis(startX,startY);
        pencil.runter();
        for(int i=0;i< turns;i++){
            pencil.dreheBis(startRotation+rotation*i);
            pencil.bewegeUm(length);

        }


    }

    public void asterisk(float x,float y,float lines,float length){
        pencil.normal();
        for(int i=0;i<lines;i++){
            pencil.hoch();
            pencil.bewegeBis(x,y);
            pencil.runter();
            pencil.bewegeBis(x+Math.cos(2*Math.PI/lines*i)*length,y+Math.sin(2*Math.PI/lines*i)*length);
        }
    }


}
