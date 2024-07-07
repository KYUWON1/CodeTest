package Programmers.OtherTest;
/*
n개의 아스키코드로 이루어진 배열 arr이 있다
아스키 코드를 문자로 치환한후 출력하는 프로그램 작성
 */

public class Programmers12090 {
    public String solution(int[] arr) {
        String answer = "";
        for (int i = 0; i < arr.length; i++) {
            char ch = (char)arr[i];
            answer += String.valueOf(ch);
        }
        return answer;
    }
}
