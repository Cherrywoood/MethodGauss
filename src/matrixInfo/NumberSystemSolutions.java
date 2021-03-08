package matrixInfo;

import java.util.Arrays;

public class NumberSystemSolutions {
    /**
     * Вычисляет количество решений матрицы
     * @param extendedMatrix - расширенная матрица
     * @param n - размер матрицы
     * @return 0 - если нет решений, 1 - одно решение, -1 - бесконечное число решений
     */
    public static int calculateNumberSolutes(double[][] extendedMatrix, int n) {
        double[][] matrix = new double[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i] = Arrays.copyOf(extendedMatrix[i], n);
        }
        if (MatrixRank.calculateRank(extendedMatrix)
                != MatrixRank.calculateRank(matrix)) {
            return 0;
        } else {
            if (MatrixRank.calculateRank(matrix) < n) return -1;
            else return 1;
        }
    }
}
