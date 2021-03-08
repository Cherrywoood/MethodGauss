package input;
import matrixInfo.MatrixInfo;
import validator.Validator;
import java.util.Scanner;

public class InputConsole implements Input {
    private Validator validator;

    public InputConsole(Validator validator) {
        this.validator = validator;
    }

    @Override
    public MatrixInfo input() {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        do {
            System.out.println("Введите размер(n) матрицы:");
            n = validator.validateMatrixSize(scanner.nextLine());
        }
        while (n == 0);

        double[][]extendedMatrix = new double[n][n+1];
        System.out.println("Введите расширенную матрицу:\n" +
                "a[11] a[12] ... a[1n] b[1]\n" +
                "...\n" +
                "a[n1] a[n2] ... a[nn] b[n]");
        for (int i = 0; i < n; i++) {
            do {
                extendedMatrix[i] = validator.validateExtendedMatrix(scanner.nextLine().split("\\s"),n,i);
            }
            while (extendedMatrix[i] == null);
        }
        scanner.close();
        return new MatrixInfo(n, extendedMatrix);
    }

    public Validator getValidator() {
        return validator;
    }

    public void setValidator(Validator validator) {
        this.validator = validator;
    }
}
