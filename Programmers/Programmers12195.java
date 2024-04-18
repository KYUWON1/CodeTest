package Programmers;
/*
    병선이는 압축된 문자열 code의 압축을 해제하는 프로그램을 작성하력한다.
    code는 다음과 같이 압축되어있다.
    n{알파벳_문자열} -> 알파벳문자열을 n번만큼 반복
    ex) f2{a3{bc}}z  -> f2{abcbcbc}z -> fabcbcbcabcbcbcz 완료
    압축된 문자열 code를 해체하는 프로그램을 작성하시오.
 */

import java.util.Stack;

public class Programmers12195 {
    public String solution(String code) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < code.length(); i++) {
            System.out.println(stack);
            char ch = code.charAt(i);
            if(ch == '}'){
                String str = "";
                char cur = stack.pop(); // }을 만나면 숫자하나를 가져옴
                while(cur != '{'){
                    str += String.valueOf(cur);
                    cur = stack.pop();
                }
                int num = Integer.parseInt(String.valueOf(stack.pop()));
                System.out.println(str);
                System.out.println(num);
                for (int j = 0; j < num; j++) {
                    for (int k = str.length()-1; k >= 0; k--) {
                        stack.push(str.charAt(k));
                    }
                }
            }else{
                stack.push(ch);
            }
        }
        System.out.println(stack);
        while(!stack.isEmpty()){
            result.append(String.valueOf(stack.pop()));
        }
        return result.reverse().toString();
    }
}
