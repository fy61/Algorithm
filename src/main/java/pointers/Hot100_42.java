package pointers;

import java.util.Scanner;

/**
 * 接雨水
 */
public class Hot100_42 {
    public static void main(String[] args) {
        int[] height = getIntArrayFromConsole();
        int[] value = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            int MaxLeft = 0;
            int MaxRight = 0;
            int j = i - 1;
            if (j < 0) {
                continue;
            }
            for (j = i - 1; j >= 0; j--) {
                MaxLeft = Math.max(height[j], MaxLeft);
            }
            for (int t = i + 1; t < height.length; t++) {
                MaxRight = Math.max(height[t], MaxRight);
            }
            int Min = Math.min(MaxLeft, MaxRight);
            int result = Math.max(Min - height[i], 0);
            value[i] = result;
        }
        int result = 0;
        for (int i : value) {
            result += i;
        }
        System.out.println(result);

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
