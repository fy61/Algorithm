package Sequential_structure;

import java.util.Scanner;

public class P5705 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float number = scanner.nextFloat();
        scanner.close();
        String value = String.valueOf(number);
        StringBuilder stringBuilder = new StringBuilder(value);
        String string = stringBuilder.reverse().toString();
        System.out.println(string);
    }
}
