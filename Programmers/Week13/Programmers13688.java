package Programmers.Week13;

/*
    준식이는 자신을 포함하여 n 명의 친구들과 함께 둥글게 둘러앉아 죽음의 게임을 하고있다. 룰은 다음과 같다
    - 게임은 1명의 호스트와 나머지 참가자로 이루어진다.
    - 게임을 시작할 때, 모든 참가자는 각자 자신을 제외한 한명을 지목한다
    - 게임의 호스트는 한 명을 지목함과 함께 숫자 m을 외친다
    - 호스트를 시작으로 총 m 번 지목한 사람을 따라 이동한다
    - m 번째로 선택된 사람이 죽음의 대상이 된다
    >> 술자리 더게임오브데스 게임

    너무 크면 100007로 나눈 나머지를 반환하시오
 */

public class Programmers13688 {
    public static int solution(int n, int m) {
        // 최대 루프를 돌릴 수 있는 횟수
        int maxDiv = m / 2 + 1;
        int answer = 0;
        // div는 루프를 도는 횟수
        for (int div = 1; div < maxDiv; div++) {
            int q = m / div; // q는 루프의 길이가 된다.
            int r = m % div;
            if (r == 0 && q <= n) { // 나머지가 0이어야 '나'로 끝난다.
                answer += (int)(perm(n-1, q-1) % 100007);
            }
        }
        return answer % 100007;
    }

    public static long perm(int n, int k) {
        long res = 1;
        for (long i = n; i > n-k; i--) {
            res *= i;
            res %= 100007;
        }
        return res;
    }


    public static void main(String[] args) {
        int n = 39;
        int m = 148;
        System.out.println(solution(n, m));
    }

}


