package Programmers;
/*
문자열을 역으로 출력하는 프로그램을 작성하시오.
 */
public class Programmers12114 {
    public String solution(String s) {
        String answer = "";
        for (int i = s.length()-1; i >= 0; i--) {
            answer += String.valueOf(s.charAt(i));
        }
        return answer;
    }
}
