package Programmers;

import java.util.Arrays;

public class Programmers11509 {
    public int solution(int[] A) {
        int answer = 0;
        int[] div = new int[100]; // 최대값으로 배열 하나 생성

        // A 안에 있는 모든 숫자에 대해서
        for (int i = 0; i < A.length; i++) {
            // 2부터 A 까지 0으로 나누어 떨어지면 해당 j에 ++;
            for (int j = 1; j <= A[i]; j++) {
                if(A[i] % j == 0){
                    div[j]++;
                }
            }
        }
        for (int i = 0; i < div.length; i++) {
            if(div[i] != 0 && div[i] == A.length){
                answer = i;
            }
        }
        return answer;
    }
}
