package Sequential_structure;

public class B2025 {
    public static void main(String[] args) {
        for (int x = -2; x <= 2; x++) {
            for (int y = -2; y <= 2; y++) {
                if( Math.abs(x) + Math.abs(y) <= 2){
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
