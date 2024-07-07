package Programmers.Week1;
/*
    민서는 회사에서 종일 일정으로 진행된 체육 행사를 주관하게 되었다.
    즐겁게 행사를 마치고 경품 추천 시간이 되었다

    경품 추천은 추첨함에 이름을 적어 넣은 사람들만이 추첨 대상이 된다.
    그런데, 민서는 추첨함에 동일 이름을 여러번 넣은 사람들이 있다는 첩보를 전달 받았다

    추첨함에 담긴 이름이 names 배열에 담겨있다고 할 때, 이 중 총 4명의 순위 구분이 없는 당첨자를 뽑는 경우의 수를 구하시오
    단, 동일 이름을 여러번 넣은 경우에는 한 번만 넣은것으로 하며, 동명이인은 없다고 가정한다
 */

// 시간 초과
// 스트림으로 중복을 제거하는것보다, 그냥 set으로 중복을 제거한 사이즈를 찾는게 훨씬 빨랐다 !

import java.util.HashSet;
import java.util.Set;

// 확률 문제 조합 사용
public class Programmers12124 {
    public int solution(String[] names) {
        int answer = 1;

        Set<String> uniqueNames = new HashSet<>();
        for (String name : names) {
            uniqueNames.add(name);
        }
        int len = uniqueNames.size();

        if(len < 4){
            return 0;
        }

        for (int i = 0; i < 4; i++) {
            if(len-i != i+1){
                answer *= len-i;
                answer /= i+1;
            }
        }


        return answer;
    }
}
