package substring;

import java.util.*;

import static Utils.inputUtil.getIntArrayFromConsole;

/**
 * 最小覆蓋子串
 */
public class Hot100_76 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入字符串S");
        String s = scanner.next();
        System.out.println("请输入字符串T");
        String t = scanner.next();
        String result = minWindow(s, t);
        scanner.close();
        System.out.println("最小子串長度為: " + result.length());
    }

    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        // need 记录目标字符串 t 的字符频率
        int[] need = new int[128];
        // window 记录当前窗口内各字符的频率
        int[] window = new int[128];
        for (char c : t.toCharArray()) {
            need[c]++;
        }
        //統計t中有多少种不同的字符
        int needTypeCount = 0;
        for (int i = 0; i < 128; i++) {
            if (need[i] > 0) needTypeCount++;
        }
        // 左右指针及辅助变量
        int left = 0, right = 0;
        int matchCount = 0; // 当前窗口内满足 need 条件的字符种类数
        int start = 0;      // 记录最小子串的起始位置
        int minLen = Integer.MAX_VALUE; // 记录最小长度

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need[c] > 0) {
                window[c]++;
                // 当窗口内该字符数量达到目标要求时，达标种类数 +1
                if (window[c] == need[c]) {
                    matchCount++;
                }
            }
            while (matchCount == needTypeCount) {
                if (right - left < minLen) {
                    start = left;
                    minLen = right - left;
                }
                char d = s.charAt(left);
                left++;
                // 如果移出的是目标字符，更新窗口数据
                if (need[d] > 0) {
                    // 如果移出后该字符数量不再满足目标要求，达标种类数 -1
                    if (window[d] == need[d]) {
                        matchCount--;
                    }
                    window[d]--;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}

