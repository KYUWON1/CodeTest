package Programmers.Week7;
/*
    부분배열을 찾아라
    - 부분 배열의 총 합과 부분배열의 최소값의 곱을 부분 배열의 점수로 기준하자
    - 이때 가장 높은 점수를 가지는 부분 배열을 찾아라
    - 배열 전체의 원소는 자연수 이다

 */
public class Programmers12690 {
    public int solution(int[] nums) {
        int answer = 0;
        //베열의 처음부터 시작해서 끝까지 계산하고, 처음부터 1개씩 줄이면서 다시 계산하는 방식
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            int min = Integer.MAX_VALUE;

            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                min = Math.min(min,nums[j]);

                int score = sum * min;
                answer = Math.max(answer, score);
            }
        }
        return answer;
    }
}
