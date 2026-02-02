package Array;

import java.util.Scanner;

import static Utils.InputUtil.getIntArrayFromConsole;

/**
 * 轮转数组 数组翻转
 */
public class Hot100_189_1 {
    static int temp;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入要轮转的次数");
        int k = scanner.nextInt();
        int[] nums = getIntArrayFromConsole();

        int n = nums.length;
        k %= n;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);

        for (int num : nums) {
            System.out.print(num+" ");
        }
        scanner.close();;
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
