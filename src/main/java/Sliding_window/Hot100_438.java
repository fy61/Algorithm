package Sliding_window;

import java.util.*;

/**
 * 找到字符串中所有字母異位詞
 */
public class Hot100_438 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入第一个字符串s：");
        String s = scanner.nextLine();
        System.out.print("请输入第二个字符串p：");
        String p = scanner.nextLine();
        scanner.close();

        List<Integer> result = findAnagrams(s, p);
        for (Integer i : result) {
            System.out.print(i + " ");
        }

    }

    public static List<Integer> findAnagrams(String s, String p) {
        int slen = s.length(), plen = p.length();
        if (slen < plen) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < plen; i++) {
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }
        System.out.println("当前窗口内容频率: " + Arrays.toString(sCount));
        System.out.println("目标标准频率: " + Arrays.toString(pCount));
        if (Arrays.equals(sCount, pCount)) {
            res.add(0);
        }
        for (int i = 0; i < slen - plen; i++) {
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + plen) - 'a'];
            if (Arrays.equals(sCount, pCount)) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
