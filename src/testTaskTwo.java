import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class testTaskTwo {

    private static ArrayList<Integer> baseListOfMeasurements;
    private static ArrayList<Integer> winterListOfMeasurements;
    private static ArrayList<Integer> summerListOfMeasurements;
    private static int numberOfElements;

    public static void main(String[] args) {

        baseListOfMeasurements = new ArrayList<>();
        winterListOfMeasurements = new ArrayList<>();
        summerListOfMeasurements = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        numberOfElements = scanner.nextInt();
        app();

        System.out.println(baseListOfMeasurements.toString() + "\n"
                + winterListOfMeasurements.toString() + "\n"
                + summerListOfMeasurements.toString());
    }

    public static void random(int numberOfElements, int topBorderOfRandom, int bottomBorderOfRandom) {
        baseListOfMeasurements.clear();
        for (int i = 0; i < numberOfElements; i++) {
            baseListOfMeasurements.add(
                    (int) (Math.random() * (topBorderOfRandom * 2)) + bottomBorderOfRandom);
            topBorderOfRandom += 2;
            bottomBorderOfRandom += 2;
        }
    }

    public static int maxOfArray(ArrayList<Integer> list, int divider) {
        int maxElement = list.get(0);
        int i;
        for (i = 0; i <= divider; i++) {
            if (list.get(i) >= maxElement)
                maxElement = list.get(i);
        }

        return maxElement;
    }

    public static void app() {
        random(numberOfElements, 15, -10);
        int elementForDividing = baseListOfMeasurements.get(0);
        int temp;
        int divider = 0;
        for (int i = 1; i < baseListOfMeasurements.size(); i++) {
            temp = baseListOfMeasurements.get(i);
            if (temp <= elementForDividing) {
                divider = i;
                elementForDividing = maxOfArray(baseListOfMeasurements, divider);
            }
        }
        if (winterListOfMeasurements.size() == 0) {
            winterListOfMeasurements.add(elementForDividing);
            summerListOfMeasurements.addAll(
                    baseListOfMeasurements.subList(1, baseListOfMeasurements.size())
            );
        }

        winterListOfMeasurements.clear();
        summerListOfMeasurements.clear();
        winterListOfMeasurements.addAll(baseListOfMeasurements.subList(0, divider + 1));
        summerListOfMeasurements.addAll(baseListOfMeasurements.subList(divider + 1, baseListOfMeasurements.size()));

        if (summerListOfMeasurements.size() == 0) {
            app();
        }

    }
}
