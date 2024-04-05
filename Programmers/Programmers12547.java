package Programmers;
/*
0 <= a < b < nums.length 이면서 nums[a] == nums[b] 를 만족하는
a, b의 쌍의 갯수를 출력하는 프로그램을 작성하시오
 */

// 배열의 값은 같지만 index는 다른 a,b 쌍, a< b
public class Programmers12547 {
    public int solution(int[] nums) {
        int answer = 0;
        for (int i = 0; i < nums.length-1; i++) {
            int a = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                int b = nums[j];
                if(a == b){
                    answer++;
                }
            }
        }
        return answer;
    }
}
