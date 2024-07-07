package Programmers.Week1;
/*
    맥주잔은 2x1의 크기로, 세로의 길이가 가로의 길이보다 두배 더 길다.
    하지만 맥주잔을 옆으로 놓으면 1x2의 가로로 배치할 수도 있다.

    맥주잔의 위 아래는 구분하지 않는다. 즉 맥주잔을 거꾸로 놓은것과, 똑바로 놓은것은 동일 취급한다

    이 때, 맥주잔을 높으 N 까지 Nx2의 직사각형 형태로 쌓아 올리는 방법의 수를 구하시오.
 */

// 피보나치로 가능하다
public class Programmers12125 {
    public int solution(int N) {
        if(N == 1){
            return 1;
        }else if(N == 2){
            return 2;
        }

        int[] result = new int[N+1];

        result[1] = 1;
        result[2] = 2;
        for (int i = 3; i <= N; i++) {
            result[i] = result[i-1]+result[i-2];
        }

        return result[N];
    }
}
