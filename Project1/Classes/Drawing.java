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
    public void polygon(int x, int y, int size, int corners){
        algorithme(x,y,0,size,1,corners);
    }

    public void triangle(int x, int y, int length){
        algorithme(x,y,0,length,120,3);
    }
    public void circle(int x,int y, int radius) {
        pencil.normal();
        pencil.bewegeBis(x, y + radius);
        pencil.runter();
        float angle = 0;
        for (int i = 0; i < radius * 10; i++) {
            angle = i * (float) Math.PI / (radius * 5);
            System.out.println(x + Math.sin(angle) * radius + "  " + y + Math.cos(angle) * radius);
            pencil.bewegeBis(x + Math.sin(angle) * radius, y + Math.cos(angle) * radius);
        }

    }

    public void polygon(float[] points){
        pencil.normal();
        pencil.bewegeBis(points[0],points[1]);
        pencil.runter();
        for(int i=0;i<points.length;i+=2){
            pencil.bewegeBis(points[i],points[i+1]);
        }
        pencil.bewegeBis(points[0],points[1]);

    }

    public void algorithme(float startX,float startY,float startRotation,float length,float rotation,float turns){
        pencil.normal();
        pencil.bewegeBis(startX,startY);
        pencil.runter();
        pencil.dreheBis(startRotation);
        for(int i=0;i< turns;i++){
            pencil.bewegeUm(length);
            pencil.dreheUm(rotation);
        }


    }


}
