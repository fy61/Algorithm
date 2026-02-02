package pointers;

import static Utils.InputUtil.getIntArrayFromConsole;

/**
 * 盛最多的水的容器
 */
public class Hot100_11 {
    public static void main(String[] args) {
        int[] height = getIntArrayFromConsole();
        for (int i : height) {
            System.out.print(i + " ");
        }
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            if (area > maxArea) {
                maxArea = area;
            }
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println("盛最多水的容器面积为：" + maxArea);
    }

}
