import java.util.Scanner;

public class RunMiniBruch {

    public static void main(String[] args) {
        test1(args);
        test2(args);
        test3(args);
    }

    public static void test1(String[] args){
        ClassExample classExample = new ClassExample(7,3);

        System.out.println(classExample.berechne());
    }

    public static void test2(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter numerator");
        long numerator = Long.parseLong(scanner.nextLine());
        System.out.println("Enter denominator");
        long denominator = Long.parseLong(scanner.nextLine());

        ClassExample classExample = new ClassExample(numerator,denominator);

        System.out.println(classExample.berechne());
    }

    public static void test3(String[] args){
        ClassExample classExample = new ClassExample(321083,12399);

        classExample.print();
    }


}
