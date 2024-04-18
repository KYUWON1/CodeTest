package Programmers;
/*
    촘촘이는 연속된 숫자가 무작위 순서로 배치된 배열 numbers를 입력받았다
    이 배열에는 최소한 하나 이상 비어있는 숫자가 있으며, 배열에서 가장 작은 숫자는 알려져있지 않다
    배열에서 비어있는 숫자중 가장 작은 숫자를 출력하는 프로그램을 작성하시오.
 */

import java.util.Arrays;

public class Programmers12192 {
    public int solution(int[] numbers) {
        int answer = 0;
        Arrays.sort(numbers);
        int num = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if(numbers[i] == num+1){
                num = numbers[i];
            }else{
                answer = num+1;
                break;
            }
        }
        return answer;
    }
}
