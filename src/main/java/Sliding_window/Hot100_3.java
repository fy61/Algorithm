package Sliding_window;

import java.util.HashSet;
import java.util.Scanner;

import static Utils.inputUtil.getCharArrayFromConsole;

/**
 * 无重复字符的最长子串
 */

public class Hot100_3 {
    public static void main(String[] args) {
        char[] ss = getCharArrayFromConsole();

        // 调用核心算法并输出
        System.out.println("最长无重复子串长度为：" + lengthOfLongestSubstring(ss));
    }

    public static int lengthOfLongestSubstring(char[] ss) {
        if(ss.length == 0) return  0;
        HashSet<Character> charSet = new HashSet<>();
        int left = 0;
        int max = 0;
        for (int right = 0; right < ss.length; right++) {
            while (charSet.contains(ss[right])) {
                // 移除左指针指向的字符，然后左指针右移
                charSet.remove(ss[left]);
                left++;
            }
            charSet.add(ss[right]);

            max = Math.max(max, right - left + 1);
        }
        return max;
    }

}
