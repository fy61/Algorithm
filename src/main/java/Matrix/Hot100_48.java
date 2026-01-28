package Matrix;
import static Utils.inputUtil.inputTwoDimensionalArray;

/**
 * 旋转图像(翻转法)
 */
public class Hot100_48 {
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

    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        // 1. 水平翻转 (上下交换)
        for (int i = 0; i < n / 2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[n - 1 - i];
            matrix[n - 1 - i] = temp;
        }

        // 2. 主对角线翻转 (matrix[i][j] 与 matrix[j][i] 交换)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) { // 注意 j 从 i+1 开始，只遍历半个三角
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
