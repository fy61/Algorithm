package Sequential_structure;

import java.util.Scanner;

public class B2005 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        scanner.close();
        for (int x = -2; x <= 0; x++) {
            for (int y = -2; y <= 2; y++) {
                if(Math.abs(x)+Math.abs(y) <= 2){
                    System.out.print(next);
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
