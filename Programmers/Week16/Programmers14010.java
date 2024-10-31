package Programmers.Week16;

import java.util.*;

/*
    정수로 이루어진 배열 nums가 있다. 이 배열에서 가장 많이 등장하는 순서대로
    총 k개 순서대로 배열로 출력하려 한다

    해당 프로그램을 작성하시오
    >>
 */
public class Programmers14010 {
    public int[] solution(int[] nums, int k) {
        int max = Arrays.stream(nums).max().orElse(0);
        int[] counts = new int[max+1];
        for (int i = 0; i < nums.length; i++) {
            counts[nums[i]]++;
        }
        List<Integer> sortNums = new ArrayList<>();
        for (int i = 0; i < counts.length; i++) {
            if(counts[i] > 0){
                sortNums.add(i);
            }
        }

        sortNums.sort((a,b) -> counts[b] - counts[a]);

        int[] answer = new int[k];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = sortNums.get(i);
        }

        return answer;
    }
}
