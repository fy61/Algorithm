package Matrix;
import static Utils.InputUtil.inputTwoDimensionalArray;

/**
 * 旋转图像(四角循环)
 */
public class Hot100_48_1 {
    public static void main(String[] args) {
        int[][] matrix = inputTwoDimensionalArray();

        rotate(matrix);

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.printf(anInt+" ");
            }
            System.out.println();
        }
    }

    public static void rotate(int[][] matrix) {int n = matrix.length;

        // 只需要遍历矩阵的左上角四分之一部分
        // n / 2 决定了行数（行数取半）
        // (n + 1) / 2 决定了列数（列数取半，针对奇数矩阵中心列的处理）
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {

                // 暂存左上角的值
                int temp = matrix[i][j];

                // 1. 将左下角移到左上角
                matrix[i][j] = matrix[n - 1 - j][i];

                // 2. 将右下角移到左下角
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];

                // 3. 将右上角移到右下角
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];

                // 4. 将暂存的左上角（旧值）移到右上角
                matrix[j][n - 1 - i] = temp;
            }
        }
    }
}
