package Programmers;
/*
n개의 이진수로 구성된 배열 arr로 주어질 때 ,이를 모두 xor 연산한 결과를
십진수로 변환해서 출력하는 프로그램을 작성하시오
 */

public class Programmers12094 {
    public int solution(String[] arr) {
        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            int num = Integer.parseInt(arr[i],2); // 2진수로 표현된 값을 10진수로 저장
            //xor 연산 진행
            answer = answer^num;
        }
        return answer;
    }
}
