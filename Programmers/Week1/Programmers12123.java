package Programmers.Week1;
/*
    소수란 자기 자신과 1만을 약수로 가지는 자연수를 말한다.
    수학 영재 민준이는 n 보다 작은 소수의 개수를 세 주는 프로그램을 개발하고자한다.
    n보다 작은 소수의 갯수를출력하는 프로그램을 작성하시오.
 */

public class Programmers12123 {
    public int solution(int n) {
        int answer = 0;
        for (int i = 2; i < n; i++) {
            boolean isSo = true;
            for (int j = 2; j < i; j++) {
                if(i % j == 0){
                    isSo = false;
                    break;
                }
            }
            if(isSo){
                answer++;
            }
        }
        return answer;
    }
}
