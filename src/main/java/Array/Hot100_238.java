package Array;

import static Utils.InputUtil.getIntArrayFromConsole;

public class Hot100_238 {
    public static void main(String[] args) {
        int[] nums = getIntArrayFromConsole();
        int[] result = productExceptSelf(nums);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        // L[i] 存储索引 i 左侧所有元素的乘积
        int[] L = new int[n];
        // R[i] 存储索引 i 右侧所有元素的乘积
        int[] R = new int[n];
        int[] ans = new int[n];

        // 1. 计算左侧乘积
        L[0] = 1; // 0左边没元素，初始为1
        for (int i = 1; i < n; i++) {
            L[i] = L[i - 1] * nums[i - 1];
        }

        // 2. 计算右侧乘积
        R[n - 1] = 1; // 最后一个元素右边没元素，初始为1
        for (int i = n - 2; i >= 0; i--) {
            R[i] = R[i + 1] * nums[i + 1];
        }

        // 3. 结果即为左右两侧乘积相乘
        for (int i = 0; i < n; i++) {
            ans[i] = L[i] * R[i];
        }

        return ans;
    }
}
