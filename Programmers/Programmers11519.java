package Programmers;
/*
0~N 까지 수를 나열했을때, 숫자 K가 몇 번이나 자릿수로 등장하는지 확인하는 프로그램을 구현하시오
K의 등장횟수이기떄문에, K가 1인 경우 111에서는 1이 3번증가 결과에 3추가해야함
ex) N = 25 ,K = 2  0 ~ 25는 2,12,20,21,22,23,24,25로 9번 등장한다
 */
public class Programmers11519 {
    public int solution(int N, int K) {
        int answer = 0;
        String k = String.valueOf(K);
        for (int i = 0; i <= N; i++) {
            String[] temp = String.valueOf(i).split("");
            for (int j = 0; j < temp.length; j++) {
                if(k.equals(temp[j])){
                    answer++;
                }
            }
        }
        return answer;
    }
}
