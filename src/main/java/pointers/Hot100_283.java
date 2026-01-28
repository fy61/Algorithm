package pointers;

import java.util.Scanner;

import static Utils.inputUtil.getIntArrayFromConsole;

/**
 * 移动零
 */
public class Hot100_283 {
    public static void main(String[] args) {
        int[] nums = getIntArrayFromConsole();
        int len = nums.length;
        int right = 0;
        int left = 0;
        while (right < len) {
            if (nums[right] != 0){
                exchange(nums,right,left);
                left++;
            }
            right++;
        }
        for (int num : nums) {
            System.out.print(num+" ");
        }
    }

    public static void exchange(int[] nums, int right, int left) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }


}
