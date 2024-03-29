package Programmers;

//찾아보기
//몇개실패함
import java.util.ArrayList;
import java.util.Stack;

public class Programmers11454 {
    public static String[] solution(String s) {
        Stack<String> stack = new Stack<>();
        ArrayList<String> list = new ArrayList<>();
        // 스택에 차례차례 대입 
        for (int i = 0; i < s.length(); i++) {
            stack.push(String.valueOf(s.charAt(i)));
        }
        // 스택을 비울때까지, 리스트에 꺼꾸로 저장
        while(!stack.isEmpty()){
            if(stack.peek().equals(".") || stack.peek().equals(" ") || stack.peek().equals("!")
                    || stack.peek().equals("?") || stack.peek().equals(",")){
                list.add(" ");
                stack.pop();
            }else{
                list.add(stack.pop());
            }
        }
        // 공백을 기준으로 나눈값을 str에 저장
        String str = "";
        for (int i = 1; i < list.size(); i++) {
            if(!list.get(i).equals(" ") || !list.get(i-1).equals(" ")){
                str += list.get(i);
            }
        }
        String[] tmp = str.split(" ");
        int start = 0;
        int end = tmp.length-1;
        while(start < end){
            String tp = tmp[end];
            tmp[end] = tmp[start];
            tmp[start] = tp;
            start++;
            end--;
        }
        
        return tmp;
    }
    public static void main(String[] args){
        solution("Hello, World!?");
    }
}
