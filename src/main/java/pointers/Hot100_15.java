package pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static Utils.inputUtil.getIntArrayFromConsole;

/**
 * 三数之和
 */
public class Hot100_15 {
    public static void main(String[] args) {
        int[] nums = getIntArrayFromConsole();
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int first = 0; first < nums.length; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int third = nums.length - 1;
            int target = -nums[first];
            for (int second = first + 1; second < nums.length; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                while (second < third && nums[second] + nums[third] > target) {
                    third--;
                }
                if (second == third) {
                    break;
                }

                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        for (List<Integer> an : ans) {
            for (Integer i : an) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
//        for (int num : nums) {
//            System.out.print(num + " ");
//        }
    }

}
