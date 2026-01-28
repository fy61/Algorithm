package Matrix;
import java.util.Scanner;

import static Utils.inputUtil.inputTwoDimensionalArray;
public class Hot100_240 {
    public static void main(String[] args) {
        System.out.println("请输入要查询的数：");
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        int[][] matrix = inputTwoDimensionalArray();
        boolean result = searchMatrix(matrix,target);
        System.out.println(result);
        scanner.close();
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        // 从右上角出发 (Top-Right)
        int row = 0;
        int col = n - 1;

        while (row < m && col >= 0) {
            int current = matrix[row][col];
            if(current == target){
                return true;
            } else if (current > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
