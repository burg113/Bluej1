package Classes;

public class BilliardTable {

    private double [] pos;
    private double [] size;

    BilliardTable(double posX, double posY, double sizeX, double sizeY){
        this.size=new double[]{sizeX,sizeY};
        this.pos=new double[]{posX,posY};
    }
    BilliardTable(double [] pos, double[] size){
        this.size=size;
        this.pos=pos;
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
        return pos[2]+size[2];
    }

    public double getMinY(){
        return pos[2];
    }

    public double[][] getBounds(){
        return new double[][]{new double[]{getMinX(),getMaxX()},new double[]{getMinY(),getMaxY()}};
    }

}
