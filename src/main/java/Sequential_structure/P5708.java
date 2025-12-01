package Sequential_structure;
import java.util.Scanner;
public class P5708 {
    public static void main(String[] args) {
        // 创建Scanner对象，用于读取输入
        Scanner scanner = new Scanner(System.in);

        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        scanner.close();

        double p = (a + b + c) / 2.0;

        double areaSquared = p * (p - a) * (p - b) * (p - c);

        double area = Math.sqrt(areaSquared);

        String formattedArea = String.format("%.1f", area);

        System.out.println(formattedArea);
    }
}
