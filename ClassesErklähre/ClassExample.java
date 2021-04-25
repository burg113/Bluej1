public class ClassExample {
    float xPos;
    float yPos;
    String Image;

    public ClassExample(float xPos,float yPos,String Image){
        this.xPos=xPos;
        this.yPos=yPos;
        this.Image=Image;
    }

    void show(){
        System.out.println(xPos);
    }

    boolean hitbox(int x, int y){
        //do calcutatoins

        //return true/false;

        return y>yPos;

    }

    void move(float amount){
        xPos+=amount;
    }


}
