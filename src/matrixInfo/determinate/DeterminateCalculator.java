package matrixInfo.determinate;

public class DeterminateCalculator{

    /**
     * Вычисляет определитель матрицы
     * @param k - количество перестановок
     * @param n - размер матрицы
     * @param extendedMatrix - расширенная матрица
     */
    static public void calculateDet(int k, int n, double[][] extendedMatrix) {
        System.out.printf("Количество перестановок: %d\n", k);
        double det = 1;
        for (int i = 0; i < n; i++) {
            det *= Math.pow(-1, k) * extendedMatrix[i][i];
        }
        System.out.print("Определитель равен: ");
        System.out.println(det);
        if (det == 0) {
            det = 0;
            System.out.println("Матрица вырожденная");
        }
    }

}
