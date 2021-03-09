package matrixInfo;

public class MatrixInfo {
    private int n;
    private double[][]extendedMatrix;

    public MatrixInfo(int n, double[][] extendedMatrix) {
        this.n = n;
        this.extendedMatrix = extendedMatrix;
    }

    /**
     * Выводит расширенную матрицу
     */
    public void showExtendedMatrix() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("|%10.5f ",extendedMatrix[i][j]);
            }
            System.out.printf("||%10.5f\n",extendedMatrix[i][n]);
        }
    }
    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public double[][] getExtendedMatrix() {
        return extendedMatrix;
    }

    public void setExtendedMatrix(double[][] extended_matrix) {
        this.extendedMatrix = extended_matrix;
    }
}
