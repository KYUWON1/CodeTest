package Programmers.Week14;

import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;

import java.util.Stack;

/*
    양의 정수가 담긴 문자열 s 가 있다고하자. 이 문자열에서 k개의 숫자를 제거해 가장 작은 숫자를 만들고자한다.
    이렇게 만든 가장작은 숫자를 담은 문자열을 반환하시오
    - k개의 문자열을 제거한 결과에는 불필요한 0이 포함될수있지만, 최종 출력에는 불필요한 0을 제거해서출력하시오
    ex) 105990, 1제거 > 5990

    1. 앞에서 부터 비교하며, 더 큰 숫자가 앞에오면 제거
    2. 스택을 사용해서 해결
 */
public class Programmers13801 {
    public String solution(String s, int k) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            while(!stack.isEmpty() &&  k > 0 && stack.peek() > c){
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        while(k > 0){
            stack.pop();
            k--;
        }

        StringBuffer sb = new StringBuffer();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.reverse();

        while(sb.length() >1 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }


        return sb.toString();
    }
}
