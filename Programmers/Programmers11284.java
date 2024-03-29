package Programmers;

public class Programmers11284 {
    public static int solution(int n) {
        int answer = 0;
        for (int i = n; i >0; i--) {
            answer += i;
        }
        return answer;
    }
}
