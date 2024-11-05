package BaekJun;

import java.util.Scanner;

public class baek25083 {
//    public static void main(String[] args) {
//        String s = "         ,r'\"7\n" + 	// \", \n 이 제어문자다.
//                "r`-_   ,'  ,/\n" + 		// \n 이 제어문자다.
//                " \\. \". L_r'\n" + 		// \\, \", \n 이 제어문자다.
//                "   `~\\/\n" + 			// \\, \n 이 제어문자다.
//                "      |\n" + 			// \n 이 제어문자다.
//                "      |";
//
//        System.out.print(s);
//    }
//
//    public static void main(String[] args) {
//        int[] ans = {1,1,2,2,2,8};
//        Scanner sc =new Scanner(System.in);
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < ans.length; i++) {
//            sb.append(ans[i] - sc.nextInt()+" ");
//        }
//        System.out.println(sb);
//
//    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int a = sc.nextInt();
        for (int i = 1; i <= a; i++) {
            for (int j = 0; j < a-i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i*2-1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = a-1; i >= 0; i--) {
            for (int j = 0; j < a-i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i*2-1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
