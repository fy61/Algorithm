package Sequential_structure;

import java.math.BigDecimal;
import java.util.Scanner;

public class P5705_2 {
    public static long reverseInteger(long num) {
        long reversed = 0;
        while (num != 0) {
            long digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }
        return reversed;
    }

    public static double reverseFloatWithModulus(double number) {

        // 1. 处理符号
        boolean isNegative = number < 0;
        double absNum = Math.abs(number);

        // 2. 拆分整数和小数部分
        long integerPart = (long) absNum;

        // 3. 计算小数部分并转化为整数进行反转
        // 确保精度：使用 BigDecimal 获取小数位数
        BigDecimal bd = new BigDecimal(String.valueOf(absNum));
        int scale = bd.scale() > 0 ? bd.scale() : 0; // 获取小数位数 (e.g., 2 for 123.45)

        // 获取小数部分对应的整数 (e.g., 0.45 -> 45)
        long fractionalPartAsInt = bd.subtract(new BigDecimal(integerPart))
                .movePointRight(scale)
                .abs()
                .longValue();

        // 4. 对两部分进行模除反转
        long reversedInt = reverseInteger(integerPart);
        long reversedFractionalInt = reverseInteger(fractionalPartAsInt);

        // 5. 重新组合
        // 将反转后的小数部分 (e.g., 54) 重新除以精度因子 (e.g., 100) -> 0.54
        double reversedFractional = reversedFractionalInt / Math.pow(10, scale);

        // 整数部分 (321) + 小数部分 (0.54)
        double result = reversedInt + reversedFractional;

        // 6. 恢复符号
        return isNegative ? -result : result;
    }

    // 示例调用 (假设输入 123.45)
// double reversed = reverseFloatWithModulus(123.45); // 结果约为 321.54
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double number = scanner.nextDouble();
        scanner.close();
        System.out.println(reverseFloatWithModulus(number));
    }
}
