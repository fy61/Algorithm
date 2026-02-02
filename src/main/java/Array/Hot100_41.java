package Array;

import static Utils.InputUtil.getIntArrayFromConsole;

/**
 * 缺失的第一个正数
 */
public class Hot100_41 {
    public static void main(String[] args) {
        int[] nums = getIntArrayFromConsole();
        int result = firstMissingPositive(nums);

            System.out.print(result + " ");

    }

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; ++i) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;

    }
}
