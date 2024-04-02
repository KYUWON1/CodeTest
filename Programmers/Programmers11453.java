package Programmers;

import java.util.Arrays;

/*
주어진 정수 num의 자릿수를 거꾸로 뒤집어 반환해라, num이 음수인 경우 - 부호는 그대로 유지
ex) n = 340 , 출력 43
ex) n = -587, 출력 -785
 */
public class Programmers11453 {
    public int solution(int num) {
        int answer = 0;
        char[] cArr = Integer.toString(num).toCharArray(); // char어레이로 쪼갬

        int Idx = 0;
        int lastIdx = cArr.length-1;
        if(num < 0){
            Idx = 1;
        }
        while(Idx < lastIdx){
            char tmp = cArr[Idx];
            cArr[Idx++] = cArr[lastIdx];
            cArr[lastIdx--] = tmp;
        }
        answer = Integer.parseInt(String.copyValueOf(cArr));
        if(answer >99999 || answer < -99999){
            return 0;
        }

        return answer;
    }
}
