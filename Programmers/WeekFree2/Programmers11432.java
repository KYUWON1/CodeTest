package Programmers.WeekFree2;
/*
N개의 정수가 배열 arr 로 주어졌을때, 이중 3개의 숫자를 골라 변의 길이로 삼각형을 만들고자 한다
이때 삼각형의 둘레가 가장 긴 삼각형을 찾아 이 삼각형의 둘레를 구하려고한다.
해당 프로그램을 구현하시오.
 */

import java.util.Arrays;

/*
삼각형이 되기 위해서는 가장 긴 대변의 길이가 두 변의 길이의 합보다 작아야 한다.
 */
public class Programmers11432 {
    public int solution(int[] arr) {
        int answer = 0;
        //우선 배열을 오름차순으로 정렬
        Arrays.sort(arr);
        for (int i = arr.length-1; i > 2; i--) {
            if(arr[i] < arr[i-1] + arr[i-2]){
                answer = answer + arr[i] + arr[i-1] + arr[i-2];
                break;
            }
        }

        
        return answer;
    }
}
