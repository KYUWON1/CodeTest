package Programmers;

import java.util.Stack;

/*
문자열 S는 숫자와 사칙연산 기초로 이루어진 수식이다 . 해당 수식을 사칙연산 계산 순서에 맞게 계산하는 프로그램을 작성하시오
결과는 double로 소수점 2자리까지 내림해서 출력
 */

public class Programmers11500 {
    public double solution(String S) {
        double answer = 0;
        Stack<String> stack = new Stack<>();
        
        for(String s: S.split("")){
            stack.push(s);
        }

        String num = "";
        while(!stack.isEmpty()){
            String pop = stack.pop();
            if(pop.equals("+")){
                answer += Double.parseDouble(num);
                num = "";
            }else if(pop.equals("-")){
                answer -= Double.parseDouble(num);
                num = "";
            }else if(pop.equals("/")){
                answer /= Double.parseDouble(num);
                num = "";
            }else if(pop.equals("*")){
                answer *= Double.parseDouble(num);
                num = "";
            }else{
                num += pop;
            }
        }

        return answer;
    }
}
