package BaekJun;

import java.util.Scanner;

/*
    문제
    무한히 큰 배열에 다음과 같이 분수들이 적혀있다.

    1/1	1/2	1/3	1/4	1/5	…
    2/1	2/2	2/3	2/4	…	…
    3/1	3/2	3/3	…	…	…
    4/1	4/2	…	…	…	…
    5/1	…	…	…	…	…
    …	…	…	…	…	…
    이와 같이 나열된 분수들을 1/1 → 1/2 → 2/1 → 3/1 → 2/2 → … 과 같은 지그재그 순서로 차례대로 1번, 2번, 3번, 4번, 5번, … 분수라고 하자.

    X가 주어졌을 때, X번째 분수를 구하는 프로그램을 작성하시오.

    입력
    첫째 줄에 X(1 ≤ X ≤ 10,000,000)가 주어진다.

    출력
    첫째 줄에 분수를 출력한다.

    예제 입력 1
    1
    예제 출력 1
    1/1
 */
public class baek1193 {
    /*
        분자 분모의 합을 T 라고하면, 2부터 쭉 증가하는 패턴
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int count = 1; // 대각선의 개수
        int i = 1; // 현재 속한 대각선의 최대 번호

        while(N > i){
            count++;
            i += count;
        }

        int diff = i - N; //최대해번호에서 원하는 위치까지의 거리
        // 짝수일땐 분모부터 감소
        if(count % 2 == 0){
            System.out.println((count-diff)+"/"+(1+diff));
        }
        // 홀수일땐 분자부터 감소
        else{
            System.out.println((1 + diff) + "/" + (count - diff));
        }

    }
}
