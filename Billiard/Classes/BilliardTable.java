package Classes;

import sum.kern.Stift;

public class BilliardTable {

    private double [] pos;
    private double [] size;

    private Stift pencil;

    BilliardTable(double [] pos, double[] size){
        this.size=size;
        this.pos=pos;
        pencil=new Stift();
    }

    BilliardTable(double posX, double posY, double sizeX, double sizeY){
        this(new double[]{posX,posY},new double[]{sizeX,sizeY});
    }

    public void draw(){
        pencil.bewegeBis(pos[0],pos[1]);
        pencil.zeichneRechteck(size[0],size[1]);

    }


    public double[] getPos() {
        return pos;
    }

    public void setPos(double[] pos) {
        this.pos = pos;
    }

    public double [] getSize() {
        return size;
    }

    public void setSize(double [] size) {
        this.size = size;
    }

    public double getMaxX(){
        return pos[0]+size[0];
    }

    public double getMinX(){
        return pos[0];
    }

    public double getMaxY(){
        return pos[1]+size[1];
    }

    public double getMinY(){
        return pos[1];
    }

    public double[][] getBounds(){
        return new double[][]{new double[]{getMinX(),getMaxX()},new double[]{getMinY(),getMaxY()}};
    }

}
