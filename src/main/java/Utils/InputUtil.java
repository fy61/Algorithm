package Utils;

import Linked.ListNode;


import java.util.Scanner;

/**
 * 从控制台读取用户输入并转换成指定的数据类型
 */
public class InputUtil {
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
    public static int[][] inputTwoDimensionalArray() {Scanner scanner = new Scanner(System.in);

        // 1. 获取行数 (逻辑保持不变)
        int rows = 0;
        while (true) {
            System.out.print("请输入数组的行数（正整数）：");
            if (scanner.hasNextInt()) {
                rows = scanner.nextInt();
                if (rows > 0) {
                    scanner.nextLine();
                    break;
                }
            }
            System.out.println("输入错误，请输入正整数！");
            scanner.next();
        }

        // 2. 核心修改：动态列解析
        System.out.println("请在一行内输入，行与行用空格隔开，行内元素用逗号隔开（如 1,2,3 4,5 6）：");
        String fullLine = scanner.nextLine().trim();
        String[] rowStrings = fullLine.split("\\s+");

        int actualRows = Math.min(rows, rowStrings.length);
        // 只初始化行数，不初始化列数
        int[][] resultArray = new int[actualRows][];

        for (int i = 0; i < actualRows; i++) {
            // 对当前行进行逗号拆分
            String[] elements = rowStrings[i].split(",");

            // 【关键点】：根据当前行拆分出的元素个数，动态创建该行数组
            resultArray[i] = new int[elements.length];

            for (int j = 0; j < elements.length; j++) {
                try {
                    resultArray[i][j] = Integer.parseInt(elements[j].trim());
                } catch (NumberFormatException e) {
                    System.out.println("元素 '" + elements[j] + "' 格式有误，默认设为 0");
                    resultArray[i][j] = 0;
                }
            }
        }

        return resultArray;
    }

    /**
     * 从控制台获取用户输入的数字并构建成链表
     * 输入示例: "1,2,3,4,5" 或 "1 2 3 4 5"
     */
    public static ListNode createListFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入链表节点值（用逗号或空格隔开，按回车结束）：");

        String input = scanner.nextLine().trim();
        if (input.isEmpty()) return null;

        // 支持多种分隔符：逗号、一个或多个空格
        String[] parts = input.split("[,\\s+]+");

        // 使用哨兵节点简化构建过程
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (String part : parts) {
            try {
                int val = Integer.parseInt(part.trim());
                current.next = new ListNode(val);
                current = current.next;
            } catch (NumberFormatException e) {
                System.out.println("跳过非法输入: " + part);
            }
        }

        return dummy.next; // 返回真实的头节点
    }
}