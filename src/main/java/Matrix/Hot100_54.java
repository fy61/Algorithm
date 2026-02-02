package Matrix;

import java.util.ArrayList;
import java.util.List;

import static Utils.InputUtil.inputTwoDimensionalArray;

/**
 * 螺旋矩阵
 */
public class Hot100_54 {
    //方二：削皮法(略)
    public static void main(String[] args) {
        int[][] matrix = inputTwoDimensionalArray();
        List<Integer> result = spiralOrder(matrix);
        for (Integer i : result) {
            System.out.printf(i + " ");
        }
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int t = 0, b = matrix.length - 1;
        int l = 0, r = matrix[0].length - 1;
        while (true) {
            for (int i = l; i <= r; i++) res.add(matrix[t][i]);
            if (++t > b) break;
            for (int i = t; i <= b; i++) res.add(matrix[i][r]);
            if (--r < l) break;
            for (int i = r; i >= l; i--) res.add(matrix[b][i]);
            if (--b < t) break;
            for (int i = b; i >= t; i--) res.add(matrix[i][l]);
            if (++l > r) break;
        }
        return res;
    }
}
