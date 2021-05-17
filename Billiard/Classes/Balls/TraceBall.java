package Classes.Balls;

import Classes.Ball;
import Classes.GameInformation;
import sum.kern.Stift;

import java.util.ArrayList;
import java.util.List;


/**
 *          The TraceBall class represents a billiard ball with a trace behind it.
 *  <br><br>
 *
 * @version 1.0
 * @author Lennart B
 */
public class TraceBall extends Ball {

    private Stift pencil;

    List<double[]> trace;

    private int tracePoints=100;


    /**
     *  <br>    Creates a new ball with a trace behind it
     *  <br><br>
     *
     *
     * @param size The diameter of the ball
     * @param pos The position of the ball <br> {x,y}
     * @param vel The velocity of the ball <br> {x,y}
     * @param gameInformation The GameInformation class containing all information of the current game
     */
    public TraceBall(double size, double[] pos, double[] vel, GameInformation gameInformation) {
        super(size, pos, vel, gameInformation);
        initializeVariables();
    }

    /**
     *  <br>    Creates a new ball with a trace behind it
     *  <br><br>
     *
     *
     * @param size The diameter of the ball
     * @param pos The position of the ball <br> {x,y}
     * @param gameInformation The GameInformation class containing all information of the current game
     */
    public TraceBall(double size, double[] pos, GameInformation gameInformation) {
        super(size, pos, gameInformation);
        initializeVariables();
    }

    /**
     *  <br>    Creates a new ball with a trace behind it
     *  <br><br>
     *
     *
     * @param size The diameter of the ball
     * @param posX The X-position of the ball
     * @param posY The Y-position of the ball
     * @param gameInformation The GameInformation class containing all information of the current game
     */
    public TraceBall(double size, double posX, double posY, GameInformation gameInformation) {
        super(size, posX, posY, gameInformation);
        initializeVariables();
    }

    /**
     *  <br>    Creates a new ball with a trace behind it
     *  <br><br>
     *
     *
     * @param pos The position of the ball <br> {x,y}
     * @param gameInformation The GameInformation class containing all information of the current game
     */
    public TraceBall(double[] pos, GameInformation gameInformation) {
        super(pos, gameInformation);
        initializeVariables();
    }

    private void initializeVariables(){
        pencil = new Stift();
        trace =new ArrayList<>();
    }

    //javadoc is kept from the overridden function
    @Override
    public void update(double deltaTime) {
        //handle the trace
        handleTrace();

        //draw the trace
        drawTrace();

        //execute the overridden function
        super.update(deltaTime);
    }

    //saves the trace as a array of points ({x,y})
    private void handleTrace(){
        try{
            if(sqrDist(trace.get(trace.size()-1),getPos())>25){ //if the ball is further than 5 pixels away from the last point added to the trace

                //adds the balls current position to the trace
                trace.add(new double[]{getPos()[0],getPos()[1]});

                //for performance reasons the length of the trace is limited    (ensures the program will not eventually run out of memory)
                while(trace.size()>tracePoints){
                    trace.remove(0);
                }
            }

        }catch (IndexOutOfBoundsException e){                   // if the trace doesn't have points jet

            //adds the balls current position to the trace
            trace.add(new double[]{getPos()[0],getPos()[1]});
        }

    }

    private void drawTrace(){
        //move to the start of the trace
        pencil.normal();
        pencil.hoch();
        pencil.bewegeBis(trace.get(0)[0], trace.get(0)[1]);
        pencil.runter();

        //draw trace
        for (int i = 0; i< trace.size(); i++) {
            double[] point = trace.get(i);
            pencil.bewegeBis(point[0],point[1]);
        }

    }

    /*  computes and returns the square of the distance between two given points

        note:   the squared distance is returned for performance reasons as it saves a square root call
                in the case the actual distance is needed the square root can be taken later
    */
    private double sqrDist(double[] p1, double[] p2){
        return Math.pow(p1[0]-p2[0],2)+Math.pow(p1[1]-p2[1],2);
    }

    /**
     *  <br>    Gets the balls number
     *  <br>    The length of the trace will roughly be 5* this number in pixels
     *  <br><br>
     *
     * @return The amount of points the trace holds
     */
    public int getTracePoints() {
        return tracePoints;
    }

    /**
     *  <br>    Sets the amount of points the trace holds
     *  <br>    The length of the trace will roughly be 5* this number in pixels
     *  <br><br>
     *
     * @param tracePoints The amount of points the trace holds
     */
    public void setTracePoints(int tracePoints) {
        this.tracePoints = tracePoints;
    }
}
