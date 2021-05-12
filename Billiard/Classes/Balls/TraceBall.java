package Classes.Balls;

import Classes.Ball;
import Classes.GameInformation;
import sum.kern.Stift;

import java.util.ArrayList;
import java.util.List;

public class TraceBall extends Ball {

    private Stift pencil;

    List<double[]> trace;

    int ID;

    public TraceBall(double size, double[] pos, double[] vel, GameInformation gameInformation) {
        super(size, pos, vel, gameInformation);
        initializeVariables();
    }

    public TraceBall(double size, double[] pos, GameInformation gameInformation) {
        super(size, pos, gameInformation);
        initializeVariables();
    }

    public TraceBall(double size, double posX, double posY, GameInformation gameInformation) {
        super(size, posX, posY, gameInformation);
        initializeVariables();
    }

    public TraceBall(double[] pos, GameInformation gameInformation) {
        super(pos, gameInformation);
        initializeVariables();
    }

    private void initializeVariables(){
        pencil = new Stift();
        trace =new ArrayList<>();
        ID=(int)(Math.random()*100000000);
    }

    @Override
    public void update(double deltaTime) {
        handleTrace();

        drawTrace();

        super.update(deltaTime);
    }

    private void handleTrace(){
        try{
            if(sqrDist(trace.get(trace.size()-1),getPos())>40){
                trace.add(new double[]{getPos()[0],getPos()[1]});

                //for performance reasons the length of the trace is limited
                while(trace.size()>20){
                    trace.remove(0);
                }
            }

        }catch (IndexOutOfBoundsException e){
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

}
