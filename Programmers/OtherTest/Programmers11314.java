package Programmers.OtherTest;

import java.util.Stack;

public class Programmers11314 {
    public static int solution(String s) {
        int answer = 0;

        String[] nums = s.split("");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            stack.push(nums[i]);
        }

        String str = "";
        while(!stack.isEmpty()){
            String element = stack.pop();
            if(element.equals("+")){
                answer += Integer.parseInt(str);
                System.out.println(answer);
                str = "";
            }else if(element.equals("-")){
                answer -= Integer.parseInt(str);
                System.out.println(answer);
                str = "";
            }else{
                str = element + str; // 숫자면 계속 더함
            }
        }
        if(str.length() != 0){
            answer += Integer.parseInt(str);
        }

        return answer;
    }
    public static void main (String[] args) {
        solution("-3+26-7");
    }
}
