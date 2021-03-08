package validator;

import validator.Validator;

public class IValidator implements Validator {
    /**
     * Осуществляет валидацию размера матрицы
     * @param str - ввод пользователя
     * @return возвращает размер матрицы или 0, если ввод некотоктный
     */
    public int validateMatrixSize(String str) {
        try {
            int n = Integer.parseInt(str);
            if (n > 20 || n < 2) {
                System.err.println("n ∈ [2,20]");
                return 0;
            }
            return n;
        } catch (NumberFormatException e) {
            System.err.println("n - целое число!");
            return 0;
        }
    }

    /**
     *
     * @param str - ввод пользователя
     * @param n - размер матрицы
     * @param i - номер строки
     * @return возвращает i строку расширенной матрицы
     */
    public double[] validateExtendedMatrix(String[] str, int n, int i) {
        double[] row = new double[n+1];
        try {
            if (str.length != n + 1) {
                System.err.printf("В строке %d пропущен свободный член или введено" +
                        " неверное количество коэффициентов!\n", i + 1);
                return null;
            }
            for (int j = 0; j < n; j++) {
                row[j] = Double.parseDouble(str[j].replace(',','.'));
            }
            row[n] = Double.parseDouble(str[str.length - 1].replace(',','.'));
            return row;
        } catch (NumberFormatException e) {
            System.err.printf("В строке %d есть не числовые значения!", i + 1);
            return null;
        }
    }
}
