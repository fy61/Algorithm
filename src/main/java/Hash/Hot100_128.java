package Hash;

import java.util.*;

import static Utils.inputUtil.getIntArrayFromConsole;

/**
 * 最长连续序列
 */
public class Hot100_128 {
    public static void main(String[] args) {
        int[] intArray = getIntArrayFromConsole();

        // 处理空数组/空引用
        int result = (intArray == null || intArray.length == 0) ? 0 : longestConsecutive(intArray);

        System.out.println("最长连续序列长度：" + result);
    }

    public static int longestConsecutive(int[] nums) {
        // 步骤1：利用HashSet的「元素唯一性」去重，O(n)
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int maxLength = 0;

        // 步骤2：遍历去重后的集合
        for (int num : numSet) {
            // 步骤2.1：利用HashSet的「O(1)查询」判断是否是起点
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;

                // 步骤2.2：继续用O(1)查询找连续数字
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }

                // 步骤2.3：更新最大长度
                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }

}
