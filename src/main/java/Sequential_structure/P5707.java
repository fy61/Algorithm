package Sequential_structure;

import java.util.Scanner;

public class P5707 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double s = scanner.nextDouble();
        double v = scanner.nextDouble();
        scanner.close();
        int walkTime = (int) Math.ceil(s / v);
        //总耗时
        int totalTime = walkTime + 10;
        //到达时间
        final int ARRIVAL_MINUTES = 480;
        //出发时间
        int departMinutes = ARRIVAL_MINUTES - totalTime;
        if (departMinutes < 0) {
            departMinutes += 24*60;
        }

        int hour = departMinutes / 60;
        int minute = departMinutes % 60;
        String output = String.format("%02d:%02d", hour, minute);
        System.out.println(output);
    }
}
