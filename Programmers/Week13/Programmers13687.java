package Programmers.Week13;

import java.util.Arrays;

import static java.lang.Math.abs;

/*
    중복된 수가 허용되는 정수로 이루어진 배열 arr 가있다
    이 배열에서 중복되지않게 3개 수를 골라 더해서 정수 target과 가장 가까운 숫자를 만들고자한다.
    이때 만들수있는 가장 가까운 숫자를 출력하시오. 거리가 같은 숫자가 2개일 경우 더 작은 숫자를 반환하시오
    
    정렬 및 투포인터 사용
 */
public class Programmers13687 {
    public int solution(int[] arr, int target) {
        Arrays.sort(arr);
        int answer = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length-2; i++) {
            int left = i+1;
            int right = arr.length-1;
            while(left < right){
                int currSum = arr[i]+arr[left]+arr[right];
                int currDiff = abs(target - currSum);

                if(currDiff < minDiff || (currDiff == minDiff && currSum < answer)){
                    answer = currSum;
                    minDiff = currDiff;
                }

                //합을 증가, 감소
                if(currSum < target){
                    left++;
                }else{
                    right--;
                }
            }
        }

        return answer;
    }
}
