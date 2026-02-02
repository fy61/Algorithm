package Array;

import java.util.Scanner;

import static Utils.InputUtil.getIntArrayFromConsole;

/**
 * 轮转数组
 */
public class Hot100_189 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入要轮转的次数");
        int k = scanner.nextInt();
        int[] nums = getIntArrayFromConsole();
        rotate(nums, k);
        for (int num : nums) {
            System.out.print(num+" ");
        }
        scanner.close();;
    }

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        if (k==0) return;
        int count = 0;
        for (int start = 0; count < n; start++) {
            int current = start;
            int prevValue = nums[current];
            do{
                int next = (current + k) % n;
                int temp =nums[next];
                nums[next] = prevValue;
                prevValue = temp;
                current =next;
                count++;
            }while (start !=current);
        }
    }
}
