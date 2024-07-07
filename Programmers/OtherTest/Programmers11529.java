package Programmers.OtherTest;

import java.util.Arrays;

public class Programmers11529 {
    public static int solution(int[] A) {
        int answer = 0;
        int minIdx = -1;
        int min = Integer.MAX_VALUE;
        int maxBenf = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            if(A[i] < min){
                min = A[i];
                for (int j = i; j < A.length; j++) {
                    if(min < A[j] || A[j] - min > maxBenf){ // 수익이 발생한고, 최대 이익보다 크다면
                        maxBenf = A[j] - min;
                    }
                }
            }
        }

        return answer+maxBenf;
    }
}
