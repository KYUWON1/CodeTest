package Programmers.Week14;

/*
    강선이는 정사각형이 빼곡하게 채워진 종이를 가지고 있다. 이 종이는
    가로로 N개의 정사각형이 배치되어있고, 세로로 M개의 정사각형이 배치되어있다

    이 종이의 좌측 상단점부터 우측 하단점까지 직선을 그렷다
    직선에 의해서 내부에 그려진 사각형의 수를 출력하는 프로그램을 작성해여라

    >> 대각선에 색칠되는 모든 사각형을 벽쪽으로 밀면은 ㄱ 또는 ㄴ 자가 되기 마련이다
    그래서 M+N -1 을 하면 되지않을까 싶지만, 변의 길이가 서로소가 아니면, 중간지점을 지나기 때문에
    공식은 M+N - 최대공약수이다.
    유클리드 호제법 사용
 */

public class Programmers13800 {
    public int solution(int N, int M) {
        int minDiv = gcd(N, M);  // 최대공약수를 계산
        return N + M - minDiv;   // 문제 요구사항에 맞게 값을 계산
    }

    public int gcd(int N, int M) {
        while (M != 0) {
            int temp = M;
            M = N % M;
            N = temp;
        }
        return N;
    }
}
