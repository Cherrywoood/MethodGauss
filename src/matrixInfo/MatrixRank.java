package matrixInfo;

public class MatrixRank {
    /**
     * Вычисляет ранг матрицы
     * @param matrix - матрицы
     * @return ранг матрицы
     */
    static public int calculateRank(double[][] matrix) {
        int rank = 0;
        for (double[] row : matrix) {
            int count = 0;
            for (double element : row) {
                if (element == 0) ++count;
            }
            if (count != matrix[0].length) ++rank;
        }
        return rank;
    }
}
