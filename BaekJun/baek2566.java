package BaekJun;

import java.util.Scanner;

public class baek2566 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = -1;
        int x=0;
        int y=0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int tar = sc.nextInt();
                if(tar > max){
                    max = tar;
                    x = i+1;
                    y = j+1;
                }
            }
        }
        System.out.println(max);
        System.out.println(x+" "+y);
    }
}
