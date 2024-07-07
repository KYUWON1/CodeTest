package Programmers.Week3;
/*
    마을에 1부터 N의 고유번호를 가진 사람들이 있다. 소문으로는 마을 사람 중에 마을 판사가 있다고한다.
    마을 판사가 실제로 존재한다면
    - 마을 판사는 아무것도 믿지 않는다
    - 다른 모든 사람들은 마을 판사를 믿는다
    - 마을 판사가 있다면 오직 1명 뿐이다.

    2차원 배열 trust가 주어졌을때, trust[i] = {a,b}는 고유번호 a가 b를 믿는다는것을 의미한다
    마을 판사가 존재한다면, 판사의 고유번호를 아니면 -1을 을 출력하는 프로그램을 작성하시오
 */

public class Programmers12363 {
    public int solution(int N, int[][] trust) {
        int answer = -1;
        int[] trustByOther = new int[N+1];
        int[] myTrust = new int[N+1];

        for(int[] pan : trust){
            trustByOther[pan[1]]++; // 내가 신뢰를 받는 횟수.
            myTrust[pan[0]]++; // 내가 다른 사람을 믿는 횟수
        }

        for (int i = 1; i < trustByOther.length; i++) {
           if(trustByOther[i] == N-1 && myTrust[i] == 0){
               return i;
           }
        }


        return answer;
    }
}
