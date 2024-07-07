package Programmers.OtherTest;

import java.util.HashMap;
import java.util.Stack;

public class Programmers11506 {
    public int solution(String S) {
        int answer = 1;
        Stack<String> stack = new Stack<>();
        //맵에 데이터 저장
        HashMap<String,String> map = new HashMap<>();
        map.put("(",")");
        map.put("{","}");
        map.put("[","]");
        map.put("<",">");

        String[] str = S.split("");
        stack.push(str[0]);
        for (int i = 1; i < str.length; i++) {
            if (map.containsKey(str[i])) { // 키값에 존재한다면, ( < 일때
                stack.push(str[i]);
            } else { // 키가 아닌값, ) > 일때
                if (map.get(stack.peek()).equals(str[i])) { // ( ) 짝이맞다면
                    stack.pop(); // 해당 문자 제거
                }else{
                    answer = 0;
                    break;
                }
            }
        }
        if(!stack.isEmpty()){
            answer = 0;
        }
        return answer;
    }
}
