package Programmers;

import java.util.ArrayList;

/*
선생님이 조회시간에 출석부를 부르고 있다
학생들의 번호를 호명하여 결석한 학생을 알아내는중 , 실수로 몇명의 번호를 다른 번호로 잘 못 호명했다
선생들은 학생들을 순서대로 호명할 필요는 없으며, 번호가 불린 학생은 재대로 호명했다고 가정
호명을 담은 배열 nums가 주어졌을때, 잘못 호명한 학생들의 원래번호를 배열로 반환하는 프로그램을 작성하시오
출력배열은 오름차순정렬
 */
public class Programmers11458 {
    public int[] solution(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] isCalled = new boolean[nums.length]; // 체크할 배열 디폴트 값 false

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] <= isCalled.length){ // 배열의 길이보다 작을때만
                isCalled[nums[i]-1] = true; //true로 변경 // 1번불리면 0 번째에
            }
        }
        for (int i = 0; i < isCalled.length; i++) {
            if(!isCalled[i]){ // false일때
                list.add(i+1);
            }
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }


        return answer;
    }
}
