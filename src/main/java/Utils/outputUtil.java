package Utils;

import java.util.List;

public class outputUtil {
    // 新增：格式化输出结果（匹配要求的输出格式）
    public static void printResult(List<List<String>> result) {
        System.out.print("[");
        for (int i = 0; i < result.size(); i++) {
            List<String> group = result.get(i);
            System.out.print("[");
            for (int j = 0; j < group.size(); j++) {
                System.out.print("\"" + group.get(j) + "\"");
                if (j < group.size() - 1) {
                    System.out.print(",");
                }
            }
            System.out.print("]");
            if (i < result.size() - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }
}
