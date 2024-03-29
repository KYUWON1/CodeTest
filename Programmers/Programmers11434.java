package Programmers;

import java.util.HashMap;

public class Programmers11434 {
    public int solution(String s) {
        int[] cntArr = new int[10]; // 0~9의 인덱스를 가진 배열
        int answer = 0;

        String[] str = s.split(""); // 쪼개서 넣음
        for (int i = 0; i < str.length; i++) {
            int idx = Integer.parseInt(str[i]); // 1이면 해당 인덱스에 cnt증가
            cntArr[idx]++;
        }

        int minCnt = 0;
        for (int i = 0; i < cntArr.length; i++) {
            // cntArr엔 해당 숫자의 등장갯수가 적혀있음, i =7 에는 3 이런식으로
            if(cntArr[i] != 0 && minCnt < cntArr[i]){ // 카운트가 큰값 비교
                minCnt = cntArr[i]; // 큰값으로 변경
                answer = i;
            }
        }
        return answer;
    }
}
