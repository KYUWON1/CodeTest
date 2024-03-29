package BaekJun;

import java.util.Scanner;
import java.util.Stack;

public class baek9012 {
    public static void solution(String[] str){

        for (int i = 0; i < str.length; i++) {
            Stack<Character> stack = new Stack<>();
            boolean isCan =true;
            for (int j = 0; j < str[i].length(); j++) {
                char ch = str[i].charAt(j);
                if(ch == '('){
                    stack.push(ch);
                }else if(ch == ')'){
                    if(stack.isEmpty()){
                        isCan = false;
                        break;
                    }
                    stack.pop();
                }
            }
            if(!stack.isEmpty()){
                isCan = false;
            }
            if(isCan){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        sc.nextLine();

        String[] str = new String[size];
        for (int i = 0; i < size; i++) {
            str[i] = sc.nextLine();
        }
        solution(str);


    }

}
