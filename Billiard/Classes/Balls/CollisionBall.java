package Classes.Balls;

import Classes.Ball;
import Classes.GameInformation;

import java.util.List;

public class CollisionBall extends Ball {


    public CollisionBall(double size, double[] pos, double[] vel, GameInformation gameInformation) {
        super(size, pos, vel, gameInformation);
    }

    public CollisionBall(double size, double[] pos, GameInformation gameInformation) {
        super(size, pos, gameInformation);
    }

    public CollisionBall(double size, double posX, double posY, GameInformation gameInformation) {
        super(size, posX, posY, gameInformation);
    }

    public CollisionBall(double[] pos, GameInformation gameInformation) {
        super(pos, gameInformation);
    }

    //handles collisions
    public void handleCollisions(){
        //handle collisions with the walls
        super.handleCollisions();

        //handles collisions with other balls
        handleBallCollisions();
    }

    //handles collisions with other Balls
    private void handleBallCollisions(){
        //gets all Balls in the Game
        List<Ball> allBalls = getGameInformation().getBalls();

        //loops through all of the Balls after the current (in order to avoid doubled collision Maths)
        for(Ball ball : allBalls.subList(allBalls.indexOf(this)+1,allBalls.size())){

            //gets the position of both balls
            double[] p1=getPos();
            double[] p2=ball.getPos();

            //gets the (square of) the distance between both balls
            double sqrDist= sqrDist(p1, p2);

            //checks if two balls are colliding
            if(sqrDist<Math.pow((ball.getSize()+getSize())/2,2)){

                /*  following calculations are done according to: https://gamedev.stackexchange.com/questions/7862/is-there-an-algorithm-for-a-pool-game/7901#7901

                    note:   in line 12 of the pseudocode (computing the impulseStrength) the last factor seems to be wrong:
                    given:              float impulseStrength = (1 + coefficient) * dot * (1 / ball1.mass + 1 / ball2.mass)
                    correct (& used):   float impulseStrength = (1 + coefficient) * dot / (1 / ball1.mass + 1 / ball2.mass)

                */

                //gets the velocities of both balls
                double[] v1 = getVel();
                double[] v2 = ball.getVel();

                //gets the mass of both balls
                double m1 = getMass();
                double m2 = ball.getMass();

                //computes the difference
                double[] velDelta = {v1[0]-v2[0],v1[1]-v2[1]};

                //computes the collision normal (vector of length 1 perpendicular to collision surface)
                double[] collisionNormal = collisionNormal(p2,p1,Math.sqrt(sqrDist));

                //computes the dot product of the difference in velocities and collision normal
                double dot = 0;
                try {
                    dot = dotProduct(velDelta,collisionNormal);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // checks if the balls are moving towards eac other (if they are not no velocities will be changed as they are already moving away from each oter)
                if(dot>0){
                    //computes the strength of the impact
                    double impulseStrength = 2 * (1 - getGameInformation().getCollisionEnergyLoss()) * dot / (1/m1 + 1/m2);

                    //computes the impulse vector (collision normal scaled by the impulseStrength)
                    double[] impulse = {impulseStrength * collisionNormal[0],impulseStrength * collisionNormal[1]};

                    //computes the velocities after the collision
                    double [] v1new=new double[]{v1[0]-impulse[0]/m1,v1[1]-impulse[1]/m1};
                    double [] v2new=new double[]{v2[0]+impulse[0]/m2,v2[1]+impulse[1]/m2};

                    //sets both velocities to the new computed velocities
                    setVel(v1new);
                    ball.setVel(v2new);
                }



            }


        }



    }

    /*  computes and returns the square of the distance between two given points

        note:   the squared distance is returned for performance reasons as it saves a square root call
                in the case the actual distance is needed the square root can be taken later
    */
    private double sqrDist(double[] p1, double[] p2){
        return Math.pow(p1[0]-p2[0],2)+Math.pow(p1[1]-p2[1],2);
    }

    //calculates the dot product of two vectors
    private double dotProduct(double[] v1,double[] v2) throws Exception {
        double sum=0;
        if(v1.length==v2.length){
            for(int i=0;i<v1.length;i++) sum+=v1[i]*v2[i];
        }else{
            throw new Exception("vectors do not have the same length");
        }
        return sum;
    }

    //calculates the normal for the collision between two balls     (normalized difference between positions)
    private double[] collisionNormal(double[] p1,double[] p2){
        return collisionNormal(p1,p2,Math.sqrt(sqrDist(p1,p2)));
    }

    //calculates the normal for the collision between two balls     (normalized difference between positions)
    private double[] collisionNormal(double[] p1,double[] p2,double len){
        return new double[]{(p1[0]-p2[0])/len,(p1[1]-p2[1])/len};
    }


}
