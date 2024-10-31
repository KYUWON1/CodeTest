package BaekJun;

import java.util.Scanner;

/*
    정수 A,B를 입력받고, A+B를 출력하는 프로그램을 작성하시오.
    한줄만 입력받는것이 아니라, 여러 번의 입력을 받을수 있어야함
    
    입력형식
    1 1
    출력
    2

 */
public class baek10951 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String[] input = sc.nextLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            System.out.println(a + b);
        }
    }
}
