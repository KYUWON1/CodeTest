package Programmers;

/*
    수업에 필요한 나뭇가지의 갯수는 N개이다.

    가지고있는 나뭇가지의 길이는 branches 배열에 저장되어있다

    N개의 교보재를 만들수있는 나뭇가지의 최대길이를 정수로 반환하시오
    N개의 교보재를 못 만들경우 -1 반환
 */
public class Programmers12562 {
    // 짜투리는 사용못한다 .
    public int solution(int N, int[] branches) {
        int answer = 0;
        int sum = 0;
        for (int i = 0; i < branches.length; i++) {
            sum += branches[i];
        }
        // 길이 1짜리의 교보재도 못 만들때
        if(sum < N ){
            return -1;
        }

        // 총 길이가 50이고 필요한개 5개라면 10으로 10개니까. 해당 길이 부터 시작해서 길이를 감소
        int start = sum / N;

        for (int i = start; i >= 2; i--) {
            int cnt = 0;
            for (int j = 0; j < branches.length; j++) {
                cnt += branches[j] / i;
            }
            if (cnt >= N) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}
