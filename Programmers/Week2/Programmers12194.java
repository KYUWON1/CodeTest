package Programmers.Week2;
/*
    컴퓨터는 정수로 표현할 때, 자료형에 따라 표현 가능한 숫자의 범위가 정해져있다.
    기산이는 이러한 한계를 해결하고자, 숫자를 배열로 표현하기로했다.
    - 양수인 경우 숫자의 각 자리를 큰 자릿수부터 순서대로 배열에 저장한다
    - 음수는 사용하지 않는다
    - 0의 경우, 빈 배열로 표현한다
    ex) 1523 -> {1, 5 ,2 ,3}
    ex) 0 -> {}
    기산이는 이 표현법을 이용하는 덧셈기를 구현하고자한다
    배열 a, b 를 더한값을 배열로 표한한것을 프로그래밍하시오
 */

import java.util.Stack;

public class Programmers12194 {
    public int[] solution(int[] a, int[] b) {
        if(a.length == 0){
            return b;
        }else if(b.length == 0){
            return a;
        }
        Stack<Integer> stack = new Stack<>();
        boolean isAdd = false;
        int i = a.length-1; // a의 맨끝
        int j = b.length-1; // b의 맨끝
        int sum = 0;
        while(i >= 0 || j >= 0){ //두배열에 끝에 도달할때까지
            sum = 0;
            if(i >= 0){
                sum += a[i];
                i--;
            }
            if(j >= 0){
                sum += b[j];
                j--;
            }
            if(isAdd){
                sum++;
                isAdd=false;
            }
            if(sum >= 10){
                stack.add(sum % 10);
                isAdd = true;
            }else{
                stack.add(sum);
            }
        }

        if(isAdd){
            stack.push(1);
        }
        int[] answer = new int[stack.size()];
        for (int k = 0; k < answer.length; k++) {
            answer[k] = stack.pop();
        }
        return answer;
    }

}
