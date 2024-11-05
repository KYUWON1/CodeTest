package BaekJun;
/*
    문제
    알파벳 소문자로만 이루어진 단어가 주어진다. 이때, 이 단어가 팰린드롬인지 아닌지 확인하는 프로그램을 작성하시오.

    팰린드롬이란 앞으로 읽을 때와 거꾸로 읽을 때 똑같은 단어를 말한다.

    level, noon은 팰린드롬이고, baekjoon, online, judge는 팰린드롬이 아니다.

    입력
    첫째 줄에 단어가 주어진다. 단어의 길이는 1보다 크거나 같고, 100보다 작거나 같으며, 알파벳 소문자로만 이루어져 있다.

    출력
    첫째 줄에 팰린드롬이면 1, 아니면 0을 출력한다.

    예제 입력 1
    level
    예제 출력 1
    1
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class baek10988 {
    // 스택으로 너무 과하게 접근했다..
//    public static void main(String[] args) throws IOException {
//        Stack<Character> stack = new Stack<>();
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = br.readLine();
//        boolean isPell = true;
//        //짝수일때
//        if(str.length() % 2 == 0){
//            for (int i = 0; i < str.length()/2; i++) {
//                stack.push(str.charAt(i));
//            }
//            for (int i = str.length()/2; i < str.length(); i++) {
//                if(!stack.pop().equals(str.charAt(i))){
//                    isPell = false;
//                }
//            }
//        }else{
//            for (int i = 0; i < str.length()/2+1; i++) {
//                stack.push(str.charAt(i));
//            }
//            stack.pop();
//            for (int i = str.length()/2+1; i < str.length(); i++) {
//                if(!stack.pop().equals(str.charAt(i))){
//                    isPell = false;
//                }
//            }
//        }
//        if(isPell){
//            System.out.println(1);
//        }else{
//            System.out.println(0);
//        }
//    }
    
    // 이전에 사용한 reverse 사용
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String reverse = new StringBuilder(str).reverse().toString();
        int len = str.length()/2;
        if(str.substring(0,len).equals(reverse.substring(0,len))){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}
