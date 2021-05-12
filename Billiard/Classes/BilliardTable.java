package Classes;

import sum.kern.Stift;

/**
 *          The BilliardTable class represents the billiard table.
 *  <br><br>
 *
 * @version 1.0
 * @author Lennart B
 */

public class BilliardTable {

    //needed variables are declared
    private double [] pos;
    private double [] size;

    //needed objects are declared
    private Stift pencil;

    /**
     *  <br>    Creates a new billiard table
     *  <br><br>
     *
     * @param pos The position of the table on the screen <br> the coordinates of the upper left corner <br> {x,y}
     * @param size The size of the table on the screen <br> {x,y}
     */
    BilliardTable(double [] pos, double[] size){
        //assigns variables
        this.size=size;
        this.pos=pos;
        pencil=new Stift();
    }

    /**
     *  <br>    Creates a new billiard table
     *  <br><br>
     *
     * @param posX The X component of the position <br> The distance between the top of the screen and the top of the table
     * @param posY The X component of the position <br> The distance between the left of the screen and the left of the table
     * @param sizeX The X component of the size
     * @param sizeY The X component of the size
     */
    BilliardTable(double posX, double posY, double sizeX, double sizeY){
        this(new double[]{posX,posY},new double[]{sizeX,sizeY});
    }

    /**
     *  <br>   Draws the billiard table on the screen
     *  <br><br>
     */
    public void draw(){
        //move to the tables position
        pencil.bewegeBis(pos[0],pos[1]);

        //draw the table
        pencil.zeichneRechteck(size[0],size[1]);

    }

    /**
     *  <br>   Gets the position of the table
     *  <br><br>
     *
     * @return The position of the table <br> {x,y}
     */
    public double[] getPos() {
        return pos;
    }

    /**
     *  <br>   Sets the position of the table
     *  <br><br>
     *
     * @param pos The position of the table <br> {x,y}
     */
    public void setPos(double[] pos) {
        this.pos = pos;
    }

    /**
     *  <br>   Gets the size of the table
     *  <br><br>
     *
     * @return The size of the table <br> {x,y}
     */
    public double [] getSize() {
        return size;
    }

    /**
     *  <br>   Sets the size of the table
     *  <br><br>
     *
     * @param size The size of the table <br> {x,y}
     */
    public void setSize(double [] size) {
        this.size = size;
    }

    /**
     *  <br>   Gets the maximal distance between the top of the screen and the table
     *  <br><br>
     *
     * @return The distance between the top of the screen and the bottom of the table
     */
    public double getMaxX(){
        return pos[0]+size[0];
    }

    /**
     *  <br>   Gets the minimal distance between the top of the screen and the table
     *  <br><br>
     *
     * @return The distance between the top of the screen and the top of the table
     */
    public double getMinX(){
        return pos[0];
    }

    /**
     *  <br>   Gets the maximal distance between the left of the screen and the table
     *  <br><br>
     *
     * @return The distance between the left of the screen and the right of the table
     */
    public double getMaxY(){
        return pos[1]+size[1];
    }

    /**
     *  <br>   Gets the minimal distance between the left of the screen and the table
     *  <br><br>
     *
     * @return The distance between the left of the screen and the left of the table
     */
    public double getMinY(){
        return pos[1];
    }

    /**
     *  <br>   Gets the bounds of the table
     *  <br><br>
     *
     * @return The Bounds of the table <br> {{minX,maxX},{minY,maxY}}
     */
    public double[][] getBounds(){
        return new double[][]{new double[]{getMinX(),getMaxX()},new double[]{getMinY(),getMaxY()}};
    }

}
