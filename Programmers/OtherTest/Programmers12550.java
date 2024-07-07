package Programmers.OtherTest;
/*
정수 배열 nums 정수 n 이 주어집니다.nums 에서 n 과 동일한 숫자중 가장 작은
인덱스를 출력하는 프로그램을 작성하시오, 인덱스는 0 부터 시작 없으면 -1 반환
 */
public class Programmers12550 {
    public int solution(int[] nums, int n) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == n){
                return i;
            }
        }
        return -1;
    }
}
