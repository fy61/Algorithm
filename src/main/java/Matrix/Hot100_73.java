package Matrix;

import static Utils.InputUtil.inputTwoDimensionalArray;

/**
 * 矩阵置零
 */
public class Hot100_73 {
    public static void main(String[] args) {
        int[][] matrix = inputTwoDimensionalArray();
        setZeroes(matrix);
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.printf(anInt + " ");
            }
            System.out.println();
        }
    }

    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean[] rowFlags = new boolean[m];
        boolean[] colFlags = new boolean[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rowFlags[i] = colFlags[j] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rowFlags[i] || colFlags[j]) {
                    matrix[i][j] = 0;
                }
            }
        }


    }
}
