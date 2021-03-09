package matrixInfo;

import output.Output;

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
                Output.printCoefficient(extendedMatrix[i][j]);
            }
            System.out.print("|");
            Output.printCoefficient(extendedMatrix[i][n]);
            System.out.println();

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
