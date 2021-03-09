package gaussMethod;

import matrixInfo.MatrixInfo;
import matrixInfo.NumberSystemSolutions;
import matrixInfo.determinate.DeterminateCalculator;

public class GaussMethodWithMainElement implements GaussMethod {

    /**
     * Основноый метод, решает СЛАУ методом Гаусса с выбором главного элемента
     * @param matrixInfo - объект, хранит в себе размер матрицы и расширенную матрицу
     * @return возвращает вектор неизвестных
     */
    @Override
    public double[] solveSystem(MatrixInfo matrixInfo) {
        int n = matrixInfo.getN();
        double[][] extendedMatrix = matrixInfo.getExtendedMatrix();
        int count = 0;

        System.out.println("Выолняется метод Гаусса...");
        for (int m = 0; m < n - 1; m++) {
            checkMatrix(n,extendedMatrix);
            System.out.printf("Шаг %d\n", m + 1);
            if (chooseMainElement(extendedMatrix, n, m)) {
                ++count;
            }
            makeTriangularMatrix(extendedMatrix, n, m);
            matrixInfo.showExtendedMatrix();
            System.out.println();
        }

        DeterminateCalculator.calculateDet(count, n, extendedMatrix);
        return getResult(n, extendedMatrix);
    }

    /**
     * Выбирает главный элемент(максимальный по модулю) "по столбцу"
     * @param extendedMatrix - расширенная матрица
     * @param n - размер матрицы
     * @param m - номер шага
     * @return возвращает true, если была перестановка строк и falsе - если нет
     */
    private boolean chooseMainElement(double[][] extendedMatrix, int n, int m) {
        double max = extendedMatrix[m][m];
        int index_max = 0;
        for (int i = m + 1; i < n; i++) {
            if (Math.abs(extendedMatrix[i][m]) > Math.abs(max)) { //ищем максимум по подулю среди m-го столбца
                max = extendedMatrix[i][m];
                index_max = i;
            }
        }
        System.out.printf("Максимальный элемент - %.5f, в строке - %d\n", max, index_max + 1);
        if (max != extendedMatrix[m][m]) { //если максимальный эл. в другой строке, то свопаем с текущей
            extendedMatrix[m] = swap(extendedMatrix[index_max],
                    extendedMatrix[index_max] = extendedMatrix[m]);
            return true;

        }
        if (max == 0) {
            System.out.println("Определитель равен: 0\n" +
                    "Матрица вырожденная");
            System.exit(0);
        }
        return false;
    }

    /**
     * Метод, который исключает неизвестные в матрице
     * @param extendedMatrix - расширенная матрица
     * @param n - размер матрицы
     * @param m - номер шага
     */
    private void makeTriangularMatrix(double[][] extendedMatrix, int n, int m) {
        for (int i = m + 1; i < n; i++) {
            double s = extendedMatrix[i][m];
            for (int j = 0; j < n; j++) {
                extendedMatrix[i][j] += extendedMatrix[m][j] * (-1) * s / extendedMatrix[m][m];
            }
            extendedMatrix[i][n] += extendedMatrix[m][n] * (-1) * s / extendedMatrix[m][m];
        }
    }

    /**
     * Обратный ход
     * Вычисляет вектор неизвестных
     * @param n - размер матрицы
     * @param extendedMatrix - расширенная матрица
     * @return вектор неизвестных
     */
    private double[] getResult(int n, double[][] extendedMatrix) {
        checkMatrix(n,extendedMatrix);
        double[] result = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0;
            for (int j = n - 1; j > i; j--) {
                sum += extendedMatrix[i][j] * result[j];
            }
            result[i] = (extendedMatrix[i][n] - sum) / extendedMatrix[i][i];
        }
        return result;
    }


    private double[] swap(double[] max, double[] current) {
        return max;
    }

    /**
     * Проверяет, имеет матрица бесконечное множество решений или не имеет решений
     * @param n - размер матрицы
     * @param extendedMatrix - расширенная матрица
     */
    private void checkMatrix(int n, double[][] extendedMatrix) {
        int countSolutions = NumberSystemSolutions.calculateNumberSolutes(extendedMatrix, n);
        if (countSolutions == 0) {
            System.out.println("Система не имеет решений!");
            System.out.println("Определитель равен: 0\n" +
                    "Матрица вырожденная");
            System.exit(0);
        } else if (countSolutions == -1) {
            System.out.println("Система имеет бесконечное множество решений!");
            System.out.println("Определитель равен: 0\n" +
                    "Матрица вырожденная");
            System.exit(0);
        }
    }

}
