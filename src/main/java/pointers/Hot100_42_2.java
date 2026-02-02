package pointers;

import static Utils.InputUtil.getIntArrayFromConsole;

/**
 * 接雨水
 */
public class Hot100_42_2 {
    public static void main(String[] args) {
        int[] height = getIntArrayFromConsole();
        int max = rainwater(height);
        System.out.println(max);
    }

    public static int rainwater(int[] height) {

        if (height == null || height.length == 0) return 0;

        int l = 0, r = height.length - 1;
        int lower = -1;     //当前移动指针指向的柱子高度。
        int waterLine = 0;  //当前处理侧的历史最高水位线（决定了当前位置能接多少水）。
        int sum = 0;        //累计接到的总雨水量。
        while (l < r) {
            if (height[l] <= height[r]) {
                lower = height[l];
                l++;
            } else {
                lower = height[r];
                r--;
            }
            waterLine = Math.max(waterLine, lower);
            sum += waterLine - lower;
        }
        return sum;
    }

}
