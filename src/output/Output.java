package output;

public class Output {
    public static void printCoefficient(double num) {
        if (num == 0) num = 0;
        System.out.printf("|%10.5f ", num);

    }

    public static void printVectorR(double num, int i) {
        if (num == 0) num = 0;
        else System.out.printf("R[%d] = %f\n",i, num);
    }

    public static void printVectorX(double num, int i) {
        if (num == 0) num = 0;
        else System.out.printf("X[%d] = %.5f\n", i, num);

    }
}
