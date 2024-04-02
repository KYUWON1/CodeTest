package Programmers;
/*
당신은 회사의 전직원을 대상으로 재난지원금을 지급하기 위해, 직원들의 평균 소득액을 계산하는 프로그램을 개발해달라는
의뢰를 받앗다.  이떄 공등하게 계산하기 위해, 최상위 1건과 최하위 1건을 제외하고 평균을 계산해야한다. 해당 프로그램을 개발하시오

Input : 소득이 담긴 arr , output : 최상 최하를 제외한 평균 금액
 */

import java.util.Arrays;

public class Programmers11412 {
    public int solution(int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        for (int i = 1; i < arr.length-1; i++) {
            answer += arr[i];
        }
        return answer/(arr.length-2);
    }
}
