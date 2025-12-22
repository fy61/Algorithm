package Sliding_window;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 无重复字符的最长子串
 */

public class Hot100_3 {
    public static void main(String[] args) {
        char[] value = getCharArrayFromConsole();

        // 调用核心算法并输出
        System.out.println("最长无重复子串长度为：" + lengthOfLongestSubstring(value));
    }

    public static int lengthOfLongestSubstring(char[] value) {
        if(value.length == 0) return  0;
        HashSet<Character> charSet = new HashSet<>();
        int left = 0;
        int max = 0;
        for (int right = 0; right < value.length; right++) {
            if (charSet.contains(value[right])) {
                left++;
                charSet.remove(value[left]);
            }
            charSet.add(value[right]);

            max = Math.max(max, right - left + 1);
        }
        return max;
    }
    /**
     * 封装方法：从控制台读取字符串并转换为字符数组
     *
     * @return 转换后的字符数组，如果输入异常或为空，返回空字符数组
     */
    public static char[] getCharArrayFromConsole() {
        // 1. 创建Scanner对象，用于读取控制台输入
        Scanner scanner = new Scanner(System.in);

        try {
            // 2. 提示用户输入
            System.out.println("请输入一个字符串：");
            // 3. 获取用户输入的完整字符串（包含空格，若用next()会以空格为分隔符截断）
            String inputStr = scanner.nextLine();

            // 4. 将字符串转换为字符数组，使用String的toCharArray()方法
            char[] charArray = inputStr.toCharArray();

            return charArray;
        } finally {
            // 5. 关闭Scanner，释放资源，放在finally中确保无论是否异常都会执行
            scanner.close();
        }
    }
}
