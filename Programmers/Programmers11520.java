package Programmers;
//다시 봐보기 !!
/*
정수 배열 A 에는 0~9 까지의 숫자가 랜덤하게 들어있다.
해당 배열에서 2개를 뽑아, 만들수 있는 두 자리 정수중 , K번째로 큰 숫자를 출력하는 프로그램을 작성하시오
A = {1,2,3,4,5}
K = 1, 출력 54
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Programmers11520 {
    public static int solution(int[] A, int K) {
        // 해당 방법으로도해보자.. 뒤에서 구해기 시간단축가능
//        Arrays.sort(A);
//        int answer = 0;
//
//        int Cnt = 0;
//        int idx = 1;
//        while(Cnt < K){
//            int lastIdx = A.length-idx;
//            answer = A[lastIdx] * 10;
//            for (int i = A.length-1; i > 0; i--) {
//                //중복 인덱스 방지
//                if(i != lastIdx){
//                    answer += A[i];
//                    Cnt++;
//                    if(Cnt >= K){
//                        break;
//                    }
//                }
//            }
//            idx++;
//        }
//        return answer;

        HashSet<Integer> numbers = new HashSet<>();

        // 가능한 모든 두 자리 수의 조합을 생성
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (i != j) { // 중복 인덱스 방지
                    int number = A[i] * 10 + A[j];
                    numbers.add(number);
                }
            }
        }

        // HashSet을 배열로 변환 후 내림차순 정렬
        Integer[] sortedNumbers = numbers.toArray(new Integer[0]);
        Arrays.sort(sortedNumbers, Collections.reverseOrder());

        // K번째로 큰 수를 찾음
        if (K <= sortedNumbers.length) {
            return sortedNumbers[K - 1];
        } else {
            // 가능한 조합의 수보다 K가 클 경우 오류 처리
            return -1;
        }
    }
    public static void main(String[]args){
        int[] arr = {1,2,3,4,5};
        int K = 4;
        System.out.println(solution(arr,K));
    }
}
