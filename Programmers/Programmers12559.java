package Programmers;

import java.util.Arrays;

/*
    문자열 s 가 있을떄 문자열을 재배치하여 만든 문자열을 에너그램 이라고 한다
    fine 은 infe의 에너그램이라고 할 수 있다
    문자열 s가 소문자로만 이루어져있다고할대, 문자열 t가 s의 에너그램인지 판단하는 프로그램을 작성하시오.
 */
public class Programmers12559 {
    public boolean solution(String s, String t) {
        boolean answer = true;
        if(s.length() != t.length()){
            return false;
        }

        // 소문자이기 때문에, -'a' 를 통해 인덱스 계산
        int[] check = new int[26]; // 알파벳소문자의 개수
        for(char c : s.toCharArray()){
            check[c-'a']++;
        }
        for(char c : t.toCharArray()){
            check[c-'a']--;
            if(check[c-'a'] < 0){
                return false;
            }
        }

        return answer;
    }
}
