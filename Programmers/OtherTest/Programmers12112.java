package Programmers.OtherTest;
/*
자연수 n 이 1과 자기 자신으로만 나누어지는 여부를 출력하는 프로그램을 구현하시오.
 */
public class Programmers12112 {
    public boolean solution(int n) {
        boolean answer = true;
        for (int i = n-1; i > 1; i--) {
            if(n % i == 0){
                answer = false;
                break;
            }
        }
        return answer;
    }
}
