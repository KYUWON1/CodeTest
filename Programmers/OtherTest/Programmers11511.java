package Programmers.OtherTest;

import java.util.ArrayList;

/* 조세푸스 알고리즘 !!
1번부터 N번 까지의 사람이 동그랗게 모여서 앉습니다.
1번부터 세어 K번째 사람을 모임에서 제외시킵니다.
남은 N-1 명에서 제외된 다음 사람부터 다시 순서를 세서 K번째 사람을 모임에서 제거하는것을 마지막 남을떄까지 반복
마지막에 남은 사람의 번호를 구하시오
 */
public class Programmers11511 {
    public static int solution(int N, int K) {
        int result = josephus(N, K);
        System.out.println("마지막으로 남는 사람의 번호: " + result);
        return result;
    }

    public static int josephus(int n, int k) {
        if (n == 1)
            return 1;
        else
            return (josephus(n - 1, k) + k - 1) % n + 1;
    }

    public static void main(String[] args){
        solution(7,3);
    }
}
