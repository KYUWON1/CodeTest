package Programmers;

import java.util.Arrays;

/*
N개의 방에서 사용한 전기량이 정수배열 usageArr로 주어진다
사용한 전기량 1당 요금이 fee 일때, 사용한 모든 전기의 요금을 구하는 프로그램을 작성하시오
 */
public class Programmers11292 {
    public int solution(int[] useageArr, int fee) {
        int answer = Arrays.stream(useageArr).sum();
        return answer * fee;
    }
}
