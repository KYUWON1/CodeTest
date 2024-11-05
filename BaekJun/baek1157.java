package BaekJun;

import java.util.HashMap;
import java.util.Scanner;

public class baek1157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().toUpperCase();
        // a ~ z
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - (int)'A'; // 0~ z 까지
            System.out.println(c);
            arr[c]++;
        }
        int max = -1;
        char ch = '?';
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max){
                max = arr[i];
                ch = (char)(i + (int)'A');
            }else if(max == arr[i]){
                ch = '?';
            }
        }
        System.out.println(ch);


    }
}
