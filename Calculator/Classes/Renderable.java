package Classes;

import sum.kern.Buntstift;

public abstract class Renderable {

    public Buntstift pencil;
    public double posX, posY;
    public double sizeX, sizeY;


    public Renderable(){
        this(0,0);
    }

    public Renderable(double posX,double posY){
        this.posX = posX;
        this.posY = posY;

        pencil=new Buntstift();
    }

    public Renderable(double posX,double posY,double sizeX,double sizeY){
        this.posX = posX;
        this.posY = posY;
        this.sizeX = sizeX;
        this.sizeY = sizeY;

        pencil=new Buntstift();
    }


    public abstract void render();


    public void setPosition(double posX, double posY) {
        this.posX = posX;
        this.posY = posY;

    }

    public void setPosition(double[] posXY) {
        this.posX = posXY[0];
        this.posY = posXY[1];

    }

    public double[] getPosition() {
        return new double[]{posX,posY};
    }

    public double getPositionX() {
        return posX;
    }

    public double getPositionY() {
        return posY;
    }


    public void setSize(double sizeX, double sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;

    }

    public void setSize(double[] sizeXY) {
        this.sizeX = sizeXY[0];
        this.sizeY = sizeXY[1];

    }

    public double[] getSize() {
        return new double[]{sizeX,sizeY};
    }

    public double getSizeX() {
        return sizeX;
    }

    public double getSizeY() {
        return sizeY;
    }


}
