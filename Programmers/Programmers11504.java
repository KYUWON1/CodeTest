package Programmers;
/*
주어진 정수 A와 B를 이진수로 표현했을때 ,A를 B로 바꾸기 위하여 뒤집어야하는 비트의 개수를 구하시오
 */

public class Programmers11504 {
    public static int solution(int A, int B) {
        if(A < 0 || A > 100 || B < 0 || B > 100){
            return 0;
        }
        int answer = 0;
        //이진수로 변경
        StringBuilder a = new StringBuilder(Integer.toBinaryString(A));
        StringBuilder b = new StringBuilder(Integer.toBinaryString(B));

        while(a.length() < 7 || b.length() < 7){
            if(a.length() < 7){
                a.insert(0,"0");
            }
            if(b.length() < 7){
                b.insert(0,"0");
            }
        }
        for (int i = 0; i < a.length(); i++) {
            if(a.charAt(i) != b.charAt(i)){
                answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args){
        solution(1,100);
    }
}
