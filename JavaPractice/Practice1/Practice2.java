package JavaPractice.Practice1;

import java.util.Scanner;

public class Practice2 {
    public static void solution() {
        Scanner sc = new Scanner(System.in);
        System.out.print("문자를 하나 입력하세요: ");
        char ch = sc.nextLine().charAt(0);
        int gap = (int)'a' - (int)'A';

        int outCome = 0;

        if( ch >= 'a' && ch <= 'z'){
            outCome = (int)ch - gap;
            System.out.println("대문자로 변환:" + (char)outCome);
        }else if(ch >= 'A' && ch <= 'Z'){
            outCome = (int)ch + gap;
            System.out.println("소문자로 변환: "+(char)outCome);
        }else{
            System.out.println("알파벳이 아닙니다.");
        }
    }

    public static void reference() {
        int a = (int)'a';
        System.out.println("a = " + a);
        int z = (int)'z';
        System.out.println("z = " + z);
        int A = (int)'A';
        System.out.println("A = " + A);
        int Z = (int)'Z';
        System.out.println("Z = " + Z);
        int etc = (int)'%';
        System.out.println("etc = " + etc);
    }

    public static void main(String[] args) {
        reference();    // 아스키 코드 참고
        solution();
    }
}
