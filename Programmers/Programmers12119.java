package Programmers;
/*
    영문자 대/소문자로 이루어진 문자 s 가 주어진다
    이 문자의 대/소문자를 서로 뒤집는 프로그램을 구현하시오.
 */
public class Programmers12119 {
    public String solution(String s) {
        String answer = "";
        int gap = (int)'a' - (int)'A';
        for (int i = 0; i < s.length(); i++) {
            int ch = (int)s.charAt(i);
            if(ch >= (int)'a' && ch <= (int)'z'){
                answer += String.valueOf((char)(ch-gap));
            }else if(ch >= (int)'A' && ch <= (int)'Z'){
                answer += String.valueOf((char)(ch+gap));
            }

        }
        return answer;
    }
}
