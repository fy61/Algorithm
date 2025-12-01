package Sequential_structure;
import java.util.Scanner;
public class P1425 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取输入：a, b, c, d 分别为开始时、开始分、结束时、结束分
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();

        scanner.close();

        // --- 步骤一：计算开始和结束的总分钟数 ---

        int totalMinutesStart = a * 60 + b;

        // 结束时间总分钟数
        int totalMinutesEnd = c * 60 + d;

        // --- 步骤二：计算持续总分钟数 ---

        int totalDurationMinutes = totalMinutesEnd - totalMinutesStart;

        // --- 步骤三：将总分钟数转换为 小时 (e) 和 分钟 (f) ---
        // 持续的小时数 (e)
        int hours = totalDurationMinutes / 60;

        int minutes = totalDurationMinutes % 60;

        // --- 输出结果 ---
        System.out.println(hours + " " + minutes);
    }
}
