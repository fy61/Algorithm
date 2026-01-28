package Array;

import static Utils.inputUtil.getIntArrayFromConsole;

/**
 * 最大子數和
 */
public class Hot100_53 {
    public static void main(String[] args) {
        int[] nums = getIntArrayFromConsole();
        int Max = maxSubArray(nums);
        System.out.println("最大值為: "+ Max);
    }

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        //1.初始化變量
        int currentSum = 0;
        int maxSum = nums[0];

        int tempStart = 0; // 临时起始指针
        int bestStart = 0; // 全局最优起始指针
        int bestEnd = 0;   // 全局最优结束指针

        for (int i = 0; i < nums.length; i++) {
            if (currentSum < 0) {
                currentSum = nums[i];
                tempStart = i;
            }else {
                currentSum +=nums[i];
            }

            if (maxSum < currentSum) {
                maxSum = currentSum;
                bestStart = tempStart;
                bestEnd = i;
            }
        }

        return maxSum;
    }
}
