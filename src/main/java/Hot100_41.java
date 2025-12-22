import java.util.*;

public class Hot100_41 {
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

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key,list);
        }
        return  new ArrayList<List<String>>(map.values());
    }

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

    public static void main(String[] args) {
        // 直接通过类名调用静态方法，无需创建。
        String[] inputStrs = Hot100_41.getInputFromConsole();
        List<List<String>> result = Hot100_41.groupAnagrams(inputStrs);
        System.out.println("\n字母异位词分组结果：");
        Hot100_41.printResult(result);

        // 甚至可以省略类名（因为 main 属于同一个类），直接写：
        // String[] inputStrs = getInputFromConsole();
        // List<List<String>> result = groupAnagrams(inputStrs);
        // printResult(result);
    }
}
