package Programmers.Week15;
/*
    정수로 이루어진 배열 arr 에는 각 인덱스에 위치했을때, 얻을 수 있는 점수가 적혀있다
    당신은 0번 에서 시작해서 한번에 최대 k 씩 우측으로 이동할수있다
    이 과정을 걸처 마지막 위치에 도달햇을때, 얻을수 있는 최대 점수를 출력하시오

    >> dp 사용, 단순하게 k범위 내에 +가 나오면 이동하면되고, k범위 내에
    +가 없다면 최소 -값을 찾아서 이동하도록 구현하면됨
 */

public class Programmers13873 {
    public int solution(int[] arr, int k) {
        int[] dp = new int[arr.length];

        // 초기 값 설정
        dp[0] = arr[0];
        // 배열의 첫번째 값 저장
        int answer = dp[0];

        // 각 단계에서 k 거리내의 최대값을 계산 dp 갱신
        for (int i = 1; i < arr.length; i++) {
            int max = Integer.MIN_VALUE;
            // 이전 인덱스에서 k 범위내의 최대값 계산
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    max = Math.max(max, dp[i - j]);
                }
            }
            // max값에 현재배열값을 더함
            dp[i] = max + arr[i];
            // 정답값 갱신
            answer = Math.max(answer, dp[i]);
        }

        return answer;
    }
}
