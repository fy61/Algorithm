package pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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

    public static int[] getIntArrayFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入整型数组（格式示例：1,2,3,4,5，多个数字用英文逗号分隔）：");
        String input = scanner.nextLine().trim();

        // 处理空输入
        if (input.isEmpty()) {
            scanner.close();
            return new int[0];
        }

        // 按英文逗号分割为字符串数组
        String[] strArray = input.split(",");
        int[] intArray = new int[strArray.length];

        // 遍历转换为整型，同时去除每个元素的首尾空格
        for (int i = 0; i < strArray.length; i++) {
            String numStr = strArray[i].trim();
            try {
                // 将字符串转换为整数
                intArray[i] = Integer.parseInt(numStr);
            } catch (NumberFormatException e) {
                // 处理非数字输入的情况
                System.err.println("输入错误：'" + numStr + "' 不是有效的整数，请重新输入！");
                scanner.close();
                // 可选择返回空数组或抛出异常，这里返回空数组
                return new int[0];
            }
        }

        scanner.close();
        return intArray;
    }
}
