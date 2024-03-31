package Programmers;

import java.util.HashMap;

/*
문자열 s 가 주어진다
문자열에서 가장 많이 등장하는 문자를 출력하는 프로그램을 구현해라
등장 숫자가 같다면, 사전 정렬순 앞에 문자를 출력
 */
public class Programmers12111 {
    public String solution(String s) {
        String answer = "";
        HashMap<String,Integer> map = new HashMap<>();
        for(String str: s.split("")){
            map.put(str,map.getOrDefault(str,0)+1);
        }
        int max = 0;
        for(String str: s.split("")){
            if(map.get(str) != 0 && map.get(str) > max){
                max = map.get(str);
                answer = str;
            }

        }
        return answer;
    }
}
