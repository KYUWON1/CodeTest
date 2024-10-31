package Programmers.Week16;

/*
    양의 정수로 이루어진 배열 nums가 있다
    이 정수 배열에서 당신은 조건에 맞는 i와 j만 선택할 수 있다.
    - nums[i]의 모든 자릿수의 합이 nums[j]의 모든 자릿수의 합과 같다
    이 조건에 맞는 모든 i,j 중에서 가장 큰 nums[i]+nums[j] 를 구하시오
    만족하는 쌍이 없으면 -1을 반환하시오
 */
public class Programmers14012 {
    public int solution(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length-1; i++) {
            int a = nums[i];
            int sum1 = sum(a);
            for (int j = i+1; j < nums.length; j++) {
                int b = nums[j];
                int sum2 = sum(b);
                if(sum1 == sum2){
                    max = Math.max(max,a+b);
                }
            }
        }
        return max == Integer.MIN_VALUE ? -1 : max;
    }

    public int sum(int num){
        int sum = 0;
        while(num > 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
