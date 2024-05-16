package Programmers;
/*
    시간순으로 나열된 주가 데이터 values 배열에서 가장 오랫동안 단조 증가가 이루어진
    구간을 찾아 {시작인덱스, 끝인덱스} 의 형식으로 출력하시오

    동일 길이의 구간이 여러번 나타날 경우 가아 먼저 나온 구간으로 출력하시오

    단조증가하는 구간이 없는 경우 {0,0}으로 출력
    
 */

public class Programmers12604 {
    public int[] solution(int[] values) {
        if (values == null || values.length == 0) {
            return new int[] {-1, -1};
        }

        int[] answer = new int[2];
        int leftidx = 0;
        int rightidx = 0;
        int maxGap = 0;
        int curr = 0; // 시작인덱스

        for (int i = 1; i < values.length; i++) {
            //단조 증가가 깨진다면,
            if(values[i] <= values[i-1]){
                int currentGap = i - curr;
                if(currentGap > maxGap){
                    maxGap = currentGap;
                    leftidx = curr;
                    rightidx = i - 1;
                }
                //깨진 구간 다음부터 다시 조사시작
                curr = i;
            }
        }

        // 마지막 구간 검사, 마지막까지 증가하는 경우 길이 +1
        int currentGap = values.length - curr;
        if (currentGap > maxGap) {
            maxGap = currentGap;
            leftidx = curr;
            rightidx = values.length - 1;
        }

        answer[0] = leftidx;
        answer[1] = rightidx;
        return answer;
    }
}
