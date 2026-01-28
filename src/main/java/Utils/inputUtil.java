package Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 从控制台读取用户输入并转换成指定的数据类型
 */
public class inputUtil {
//    public static void main(String[] args) {
//        int[][] dynamicArray = inputTwoDimensionalArray();
//
//        // 打印结果，展示每行的列数和元素
//        System.out.println("\n你输入的二维数组为：");
//        for (int i = 0; i < dynamicArray.length; i++) {
//            int[] row = dynamicArray[i];
//            for (int num : row) {
//                System.out.print(num + " ");
//            }
//            System.out.println();
//        }
//    }


    /**
     * 从控制台读取数字并转换为整形数组
     *
     * @return 整形数组
     */
    public static int[] getIntArrayFromConsole() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("请输入以逗号分隔的数字（回车结束）：");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("提示：输入为空，返回空数组");
                return new int[0]; // 返回空数组而非null，避免NPE
            }

            String[] strArr = input.split("\\s*,\\s*");
            int[] resultArray = new int[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                try {
                    resultArray[i] = Integer.parseInt(strArr[i]);
                } catch (NumberFormatException e) {
                    System.out.println("错误：'" + strArr[i] + "' 不是有效的整数！");
                    return new int[0];
                }
            }

            return resultArray;
        } catch (Exception e) {
            System.out.println("读取输入时发生异常：" + e.getMessage());
            return new int[0];
        }
    }

    /**
     * 从控制台读取字符串并转换为String数组
     *
     * @return String 数组
     */
    public static String[] getInputFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入字符串数组（格式示例：eat,tea,tan,ate,nat,bat，多个字符串用英文逗号分隔）：");
        String input = scanner.nextLine().trim();
        // 处理空输入
        if (input.isEmpty()) {
            return new String[0];
        }
        // 按英文逗号分割为数组
        String[] strs = input.split(",");
        // 去除每个字符串的首尾空格（兼容用户输入时的空格）
        for (int i = 0; i < strs.length; i++) {
            strs[i] = strs[i].trim();
        }
        scanner.close();
        return strs;
    }

    /**
     * 封装方法：从控制台读取字符串并转换为字符数组
     *
     * @return 转换后的字符数组，如果输入异常或为空，返回空字符数组
     */
    public static char[] getCharArrayFromConsole() {
        // 1. 创建Scanner对象，用于读取控制台输入

        try (Scanner scanner = new Scanner(System.in)) {
            // 2. 提示用户输入
            System.out.println("请输入一个字符串：");
            // 3. 获取用户输入的完整字符串（包含空格，若用next()会以空格为分隔符截断）
            String inputStr = scanner.nextLine();

            // 4. 将字符串转换为字符数组，使用String的toCharArray()方法

            return inputStr.toCharArray();
        }
        // 5. 关闭Scanner，释放资源，放在finally中确保无论是否异常都会执行
    }

    /**
     * 从控制台输入二维数组并返回
     *
     * @return 整形数组
     */
    public static int[][] inputTwoDimensionalArray() {
        Scanner scanner = new Scanner(System.in);

        // 1. 获取行数 (逻辑保持不变)
        int rows = 0;
        while (true) {
            System.out.print("请输入区间的个数（正整数）：");
            if (scanner.hasNextInt()) {
                rows = scanner.nextInt();
                if (rows > 0) {
                    scanner.nextLine(); // 消耗多余换行符
                    break;
                }
            }
            System.out.println("输入错误，请输入正整数！");
            scanner.next();
        }

        // 2. 核心修改：一行输入所有区间，例如 "1,3 2,4 8,10"
        System.out.println("请在一行内输入所有区间，格式为 '起点,终点'，区间间用空格隔开（如 1,3 2,6）：");
        String fullLine = scanner.nextLine().trim();

        // 按照空格切分出每一个区间字符串 ["1,3", "2,6", "8,10"]
        String[] intervalStrings = fullLine.split("\\s+");

        // 为了防止输入的区间个数与 rows 不符，我们以实际输入的数量为准或进行截取
        int actualSize = Math.min(rows, intervalStrings.length);
        int[][] resultArray = new int[actualSize][2];

        for (int i = 0; i < actualSize; i++) {
            // 针对每个 "1,3" 进行逗号切分
            String[] parts = intervalStrings[i].split(",");
            if (parts.length == 2) {
                try {
                    resultArray[i][0] = Integer.parseInt(parts[0].trim());
                    resultArray[i][1] = Integer.parseInt(parts[1].trim());
                } catch (NumberFormatException e) {
                    System.out.println("区间 " + intervalStrings[i] + " 格式有误，已跳过。");
                }
            } else {
                System.out.println("无效区间格式: " + intervalStrings[i]);
            }
        }

        // 注意：不要在这里 close scanner，否则后续无法再次输入
        return resultArray;
    }

}