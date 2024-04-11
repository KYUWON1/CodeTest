package Programmers;
/*
    시험에 참가하는 학생 N 명, 시험을 보기 위해서 M 개에 교실에 모든 학생과, 감독관을 한 명씩 배치하여야한다
    교실에 학생이 배치되지않을 수도 있으며, 교실이 비어도 감독관은 교실에 1명은 배치되어야한다.

    각 교실의 수용인원은 capacity배열에 저장되어있다. 수용인원의 총 합은 학생의 수보다 같거나 더 클수도있다
    감독관은 K 명있으며, 감독관수가 부족한 경우는 없다.

    이 때 학생과 감독관을 교실에 배정하는 모든 경우의 수를 구하시오.

    조합과 순열을 사용해서 접근 가능
    학생 > 조합을 통해 교실에 배치, 감독관 순열을 통해 배치

    //무언가 틀림 ..
    교실의 공간이 더 많을 때 계산로직이 잘 못 된듯
 */

public class Programmers12127 {
    public long solution(int N, int M, int K, int[] capacity) {
        long answer = 1;
        // 총 학생수
        int total = N;

        // 5, 3
        for (int j : capacity) {
            // 현재 학생수와 수용량 조합 계산
            answer *= calC(total, j);
            total -= j;
            if (total <= 0) {
                break;
            }
        }

        for (int i = 0; i < M; i++) {
            answer *= (K-i);
        }

        return answer;
    }

    // 교실의 크기와 남은 학생의 수
    public long calC(long num , int size){
        //num은 현재 학생수, size는 교실 수용,
        long answer = 1;
        //학생이 교실수용량보다 많을때,
        if(num >= size){
            for (int i = 0; i < size; i++) {
                answer *= num-i;
                answer /= i+1;
            }
        }else{
            return 1;
        }

        return answer;
    }
}
