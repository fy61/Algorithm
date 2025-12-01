package Sequential_structure;

import java.util.Scanner;

public class B2029 {
    private static final double PI = 3.14;

    private static final double TOTAL_VOLUME_CM3 = 20000.0; // 20 升 * 1000

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int h = scanner.nextInt();
        int r = scanner.nextInt();

        scanner.close();

        // --- 步骤一：计算小圆桶的体积 (V_桶) ---
        double bucketVolume = PI * r * r * h;

        // --- 步骤二：计算所需桶数（原始浮点数） ---
        double rawBuckets = TOTAL_VOLUME_CM3 / bucketVolume;

        // --- 步骤三：向上取整（确保解渴） ---
        int requiredBuckets = (int) Math.ceil(rawBuckets);

        System.out.println(requiredBuckets);
    }
}
