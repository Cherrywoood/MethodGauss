package input;

import matrixInfo.MatrixInfo;
import validator.Validator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputFile implements Input {
    private Validator validator;

    public InputFile(Validator validator) {
        this.validator = validator;
    }

    @Override
    public MatrixInfo input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Форма вводе в файле:\n" +
                "n\n" +
                "a[11] a[12] ... a[1n] b[1]\n" +
                "...\n" +
                "a[n1] a[n2] ... a[nn] b[n]\n" +
                "Введите путь к файлу:");
        try {
            scanner = new Scanner(new File(scanner.next()));
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден!");
            System.exit(1);
            scanner.close();
        }
        int n = 0;
        double[][] extendedMatrix = new double[0][];
        while (scanner.hasNext()) {
                n = validator.validateMatrixSize(scanner.nextLine());
                if (n == 0) System.exit(1);
                extendedMatrix = new double[n][n + 1];
                for (int i = 0; i < n; i++) {
                    extendedMatrix[i] = validator.
                            validateExtendedMatrix(scanner.nextLine().split("\\s"), n, i);
                    if (extendedMatrix[i] == null) System.exit(1);
                }
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
