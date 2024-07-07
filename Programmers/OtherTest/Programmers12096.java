package Programmers.OtherTest;
/*
두 자연수 a,b 에 대하여 b = a * c 를 만족하는 자연수 c 가 존재한다면,
a 를 b의 약수라고한다. 자연수 n 이 주어졌을떄, n의 양의 약수의 갯수를 출력하는 프로그램을 작성하시오
 */
public class Programmers12096 {
    public int solution(int n) {
        int answer = 0;
        for (int i = n; i > 0; i--) {
            if((n % i) == 0){
                answer++;
            }
        }
        return answer;
    }
}
