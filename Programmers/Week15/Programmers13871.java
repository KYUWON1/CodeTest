package Programmers.Week15;

import java.util.HashMap;
import java.util.Map;

/*
    입력 받은 문자열 s가 아래 조건을 만족하는지 확인해야 한다.
    - 비밀번호는 6자 이상 , 20자 이하로 이루어진다
    - 비밀번호는 최소 하나 이상의 영어 소문자, 대문자, 숫자,그리고 특수문자( !@#$%^&*() )로 이루어진다
    - 비밀번호는 똑같은 문자가 세번 반복되지않는다
    - 대소문자 구분없이 셋 이상 연속된 영문자 또는 숫자가 존재하지않는다
 */
public class Programmers13871 {
    public boolean solution(String s) {
        Map<Character, Integer> map = new HashMap<>();
        // 6자 이상 20자 이하
        if(s.length() < 6 || s.length() > 20){
            return false;
        }
        // 최소 하나 이상의 영어 소문자, 대문자, 숫자 ,그리고 툭수문자
        boolean lower = false,upper = false,digit = false,special = false;
        for(char c: s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
            // 3번이상 등장시
            if(map.get(c) > 3){
                return false;
            }
            // 1번 이상 등장하나 체크
            if (Character.isLowerCase(c)) {
                lower = true;
            } else if (Character.isUpperCase(c)) {
                upper = true;
            } else if (Character.isDigit(c)) {
                digit = true;
            } else if ("!@#$%^&*()".indexOf(c) >= 0) {
                special = true;
            }
        }
        // 하나라도 true가 아니면 false
        if(!lower || !upper || !digit || !special) {
            return false;
        }
        String low = s.toLowerCase();
        for (int i = 0; i < s.length()-2; i++) {
            char c = low.charAt(i);
            char c1 = low.charAt(i+1);
            char c2 = low.charAt(i+2);
            if(c+1 == c1 && c+2 == c2){
                return false;
            }
        }

        return true;
    }
}
