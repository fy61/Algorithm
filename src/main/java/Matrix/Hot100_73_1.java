package Matrix;

import static Utils.InputUtil.inputTwoDimensionalArray;

/**
 * 矩阵置零
 */
public class Hot100_73_1 {
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

    public static void setZeroes(int[][] matrix) {int m = matrix.length;
        int n = matrix[0].length;

        // 1. 记录第一行和第一列原本是否含有 0
        boolean row0Flag = false;
        boolean col0Flag = false;

        // 检查第一行
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                row0Flag = true;
                break;
            }
        }
        // 检查第一列
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                col0Flag = true;
                break;
            }
        }

        // 2. 使用第一行和第一列来存储其余位置的 0 标记
        // 注意：从下标 1 开始遍历，避免污染我们要用的“标记位”
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0; // 在该行首位打标
                    matrix[0][j] = 0; // 在该列首位打标
                }
            }
        }

        // 3. 根据第一行和第一列的标记，将对应的内部元素置零
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 4. 最后单独处理第一行和第一列（补漏）
        if (row0Flag) {
            for (int j = 0; j < n; j++) matrix[0][j] = 0;
        }
        if (col0Flag) {
            for (int i = 0; i < m; i++) matrix[i][0] = 0;
        }
    }
}
