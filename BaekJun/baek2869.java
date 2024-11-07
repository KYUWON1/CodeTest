package BaekJun;

import java.util.Scanner;

/*
    문제
    땅 위에 달팽이가 있다. 이 달팽이는 높이가 V미터인 나무 막대를 올라갈 것이다.

    달팽이는 낮에 A미터 올라갈 수 있다. 하지만, 밤에 잠을 자는 동안 B미터 미끄러진다. 또, 정상에 올라간 후에는 미끄러지지 않는다.

    달팽이가 나무 막대를 모두 올라가려면, 며칠이 걸리는지 구하는 프로그램을 작성하시오.

    입력
    첫째 줄에 세 정수 A, B, V가 공백으로 구분되어서 주어진다. (1 ≤ B < A ≤ V ≤ 1,000,000,000)

    출력
    첫째 줄에 달팽이가 나무 막대를 모두 올라가는데 며칠이 걸리는지 출력한다.

    예제 입력 1
    2 1 5
    예제 출력 1
    4
 */
public class baek2869 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int up = sc.nextInt();
        int down = sc.nextInt();
        int height = sc.nextInt();
        // 계속 미끄러진다는 가정하에, 하루에 up-down 만큼 올라간다고 생각.
        // 그러나 마지막 위치에 도달했을경우 down 발생하지않음으로 전체 길이에서 down을 빼줘야함
        int date = (height - down) / (up - down);
        // 정확히 up - down 값으로 나누어지지않는다는것은, 하루를 더 소모해서 위로 올라가야하는것이기때문이고
        // 도착시 미끄러지지않음으로 하루가 추가된다.
        if( (height - down) % (up - down) != 0 ) {
            date++;
        }
        System.out.println(date);

    }
}
