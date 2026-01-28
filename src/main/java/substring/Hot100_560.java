package substring;

import java.util.Scanner;

import static Utils.inputUtil.getIntArrayFromConsole;

/**
 * 和为k的子数组
 */
public class Hot100_560 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入整数K");
        int k = scanner.nextInt();
        int[] nums = getIntArrayFromConsole();
        int result = subarraySum(nums,k);
        System.out.println("和为K的子数组有: " + result + "个");
        scanner.close();
    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end >= 0; end--) {
                sum+=nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
