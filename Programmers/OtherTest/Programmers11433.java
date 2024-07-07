package Programmers.OtherTest;
/*
양의 정수 n이 주어질 때, n 보다 작거나,같은 양의 정수 중 가장 큰 "세제 곱"을 출력하는 프로그램을 작성하시오
ex) n = 15, 답 2, 2의 세제곱은 8, 3은 27로 초과
 */

public class Programmers11433 {
    public int solution(int n) {
        if(n < 1 || n > 100000000){
            return 0;
        }
        int result = 1;
        for (int i = 1; i <= n; i++) {
            // 1부터 시작해서 세 제곱이 n보다 큰 수를 만나면, 그전의 수는 작을것임으로 작은값 리턴
            if(Math.pow(i,3) <= n){
                result = i;
            }else{
                break;
            }
        }
        return (int)Math.pow(result,3);
    }
}
