package Sequential_structure;

import java.util.Scanner;

public class P5706 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double t = scanner.nextDouble();

        int n = scanner.nextInt();

        scanner.close();

        double volumePerStudent = t / n;

        String formattedVolume = String.format("%.3f", volumePerStudent);

        int totalCups = n * 2;

        System.out.println(formattedVolume);

        System.out.println(totalCups);
    }
}
