package pointers;

import java.util.Scanner;

public class Hot100_42_1 {
    public static void main(String[] args) {
        int[] height = getIntArrayFromConsole();
        System.out.println(rainwater(height));
    }

    public static int rainwater(int[] height){
        int n = height.length;
        if (n == 0) return 0 ;
        int[] lMax = new int[n];
        lMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            lMax[i] = Math.max(lMax[i-1],height[i]);
        }
        int[] rMax = new int[n];
        rMax[n - 1] = height[n - 1]; // 必须初始化末尾
        for (int i = n - 2; i >= 0; i--) {
            rMax[i] = Math.max(rMax[i + 1], height[i]);
        }
        int sum = 0;
        for (int i = 0; i < n ; i++) {
            sum += Math.min(lMax[i], rMax[i])-height[i];
        }
        return sum;
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
