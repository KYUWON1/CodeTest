package Week1;
//심규원

public class Task1 {
    public static void main(String[] args) {
        System.out.println("[구구단 출력]");
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                System.out.print(String.format("%02d * %02d = %02d\t",j,i,i*j));
            }
            System.out.println();
        }
    }
}
