import java.util.Scanner;

public class RunClassExample {


    public static void main(String[] args) {
        start();
        while(true) {
            long t1 = System.nanoTime();
            draw();
            while((System.nanoTime()-t1)<1000000000) {}

        }
    }

    public static void start(){
        ClassExample [] pipes=new ClassExample[5];
        for(int i=0;i<pipes.length;i++) {
            pipes[i]=new ClassExample(i*100, (float)(Math.random()*400+100),"PipeImage");
        }


        while(true) {
            long t1 = System.nanoTime();

            int count=0;

            for (ClassExample pipe:pipes) {
                pipe.move(10);
                count++;
                System.out.println("pipe: "+count);
                pipe.show();
            }


            System.out.println("");
            System.out.println("");
            System.out.println("");




            while((System.nanoTime()-t1)<1000000000) {}


        }


    }


    public static void draw(){



    }




}
