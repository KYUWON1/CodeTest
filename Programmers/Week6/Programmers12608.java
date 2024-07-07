package Programmers.Week6;
/*
    학생들에게 퀴즈를 풀게 하여 각 학생의 점수를 scores[i]에 기록하였다.
    학생들을 인덱스 순서대로 일렬로 세운후 학생의 점수에 따라 초콜렛을 나누어주려고한다
    예산이 부족한 바람에 초콜렛을 최대한 아껴야하지만, 아래 조건 처럼 주려고한다

    - 최소 1개 이상의 초콜릿은 각 학생에게 나누어주어야한다
    - 바로 인접한 친구보다 점수가 높다면, 더 많은 초콜렛을 받아야한다.
    - 위 조건을 만족하면서, 최소로 초콜렛을 나누어 줄 때, 각 학생이 받는 초콜렛의 갯수를 출력하시오

 */

public class Programmers12608 {
    public int[] solution(int[] scores) {
        int[] answer = new int[scores.length];
        //우선 1로 모두 초기화
        for (int i = 0; i < answer.length; i++) {
            answer[i] = 1;
        }
        //오른쪽으로 이동하면서, 더 큰 점수를 받았다면 +1해서 줌 
        for (int i = 1; i < answer.length; i++) {
            if(scores[i] > scores[i-1]){
                answer[i] = answer[i-1]+1;
            }
        }
        //다시 왼쪽으로 이동하면서, 더 큰 점수를 받았다면, 기존의 값과 +1한 값의 크기를 비교해서 더 큰값으로 줌
        for (int i = answer.length-2; i >= 0; i--) {
            if(scores[i] > scores[i+1]){
                answer[i] = Math.max(answer[i],answer[i+1]+1);
            }
        }
        return answer;
    }
}
