package pointers;

import static Utils.InputUtil.getIntArrayFromConsole;

/**
 * 接雨水
 */
public class Hot100_42_1 {
    public static void main(String[] args) {
        int[] height = getIntArrayFromConsole();
        System.out.println(rainwater(height));
    }

    public static int rainwater(int[] height){
        int n = height.length;
        if (n == 0) return 0 ;
        int[] lMax = new int[n];
        lMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            lMax[i] = Math.max(lMax[i-1],height[i]);
        }
        int[] rMax = new int[n];
        rMax[n - 1] = height[n - 1]; // 必须初始化末尾
        for (int i = n - 2; i >= 0; i--) {
            rMax[i] = Math.max(rMax[i + 1], height[i]);
        }
        int sum = 0;
        for (int i = 0; i < n ; i++) {
            sum += Math.min(lMax[i], rMax[i])-height[i];
        }
        return sum;
    }

}
