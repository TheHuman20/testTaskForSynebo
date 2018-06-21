import java.util.Scanner;

public class testTaskOne {

    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        int startNum = scanner.nextInt();
        int endNum = scanner.nextInt();

        // whole squares counter
        int counter = 0;

        int temp;

        for (temp = startNum;temp <= endNum;temp++){
            boolean checkFlag = check(Math.sqrt(temp));
            if (checkFlag == true)
            counter += 1;
        }
        System.out.println(counter);
    }

    public static boolean check(double a){
        double b = Math.round(a);
        return a == b;
    }
}
