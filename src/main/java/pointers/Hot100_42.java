package pointers;

import static Utils.InputUtil.getIntArrayFromConsole;

/**
 * 接雨水
 */
public class Hot100_42 {
    public static void main(String[] args) {
        int[] height = getIntArrayFromConsole();
        int[] value = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            int MaxLeft = 0;
            int MaxRight = 0;
            int j = i - 1;
            if (j < 0) {
                continue;
            }
            for (j = i - 1; j >= 0; j--) {
                MaxLeft = Math.max(height[j], MaxLeft);
            }
            for (int t = i + 1; t < height.length; t++) {
                MaxRight = Math.max(height[t], MaxRight);
            }
            int Min = Math.min(MaxLeft, MaxRight);
            int result = Math.max(Min - height[i], 0);
            value[i] = result;
        }
        int result = 0;
        for (int i : value) {
            result += i;
        }
        System.out.println(result);

    }


}
