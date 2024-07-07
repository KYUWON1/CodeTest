package Programmers.OtherTest;
/*
16진수 s 가 주어질 때, s 를 이진수로 변환하여 출력하는 프로그램을 구현하시오
 */

public class Programmers12107 {
    public String solution(String s) {
        String result = "";
        int num = Integer.parseInt(s,16); // 16진수를 10 진수로
        return result = Integer.toBinaryString(num);
    }
}
