import gaussMethod.GaussMethod;
import gaussMethod.GaussMethodWithMainElement;
import input.Input;
import input.InputConsole;
import input.InputFile;
import matrixInfo.MatrixInfo;
import output.Output;
import validator.IValidator;
import validator.Validator;

import java.io.File;
import java.util.*;

public class Main {
    public static void main(String... arg) {
        Scanner scanner = new Scanner(System.in);
        Validator validator = new IValidator();
        Input input;
        
        System.out.println("Решение СЛАУ методом Гаусса с выбором главного элемента");
       while(true) {
           System.out.println("f - ввод из файла\n" +
                   "w - ввод с клавиатуры");
           String key = scanner.nextLine();
           if(key.equals("f")) {
               input = new InputFile(validator);
               break;
           }
           else if (key.equals("w")) {
               input = new InputConsole(validator);
               break;
           }
           else {
               System.err.println("Неверный ключ!");
           }
       }
       // Ввод
        MatrixInfo matrixInfo = input.input();
        System.out.println("Полученная матрица...");
        matrixInfo.showExtendedMatrix();

        GaussMethod gaussMethod = new GaussMethodWithMainElement();
        double[] result = gaussMethod.solveSystem(matrixInfo);

        // Выводит вектор неизвестных
        System.out.println("\nОТВЕТ:");
        for (int i = 0; i < result.length; i++) {
            Output.printVectorX(result[i], i+1);
        }

        // Считает и выводит вектор невязок
        System.out.println("\nВектор невязок:");
        int n = matrixInfo.getN();
        for (int i = 0; i < n; i++) {
            double sum = 0;
            for (int j = 0; j < n; j++) {
               sum+=matrixInfo.getExtendedMatrix()[i][j]*result[j];
            }
            Output.printVectorR(matrixInfo.getExtendedMatrix()[i][n], i+1);
        }
        scanner.close();
    }
}

