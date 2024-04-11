// 심규원
package JavaPractice.EventTask1;

import java.util.Scanner;

public class MinXY {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        sc.nextLine();

        double minLen = Double.MAX_VALUE;
        int minx=0, miny=0;
        for (int i = 0; i < 10; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            double leng = Math.sqrt(Math.pow(x1-x,2)+Math.pow(y1-y,2));
            if(minLen > leng){
                minLen =leng;
                minx = x1;
                miny = y1;
            }
        }
        System.out.println("가장 가까운 좌표값:"+"("+minx+","+miny+")");
    }
}
