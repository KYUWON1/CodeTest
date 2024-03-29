package Programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Programmers11285 {
    // n 전광판에 크기, s 는 흘러갈 문자, t는 t초후에 전광판의 상태
    public static String solution(int n, String s, int t) {
        String answer = "";
        Queue<String> que = new LinkedList<>();
        String str= "";
        // str에 .....과 s 를 삽입
        for (int i = 0; i < n; i++) {
            que.add(".");
            str += ".";
        }
        for (int i = 0; i < s.length(); i++) {
            str += String.valueOf(s.charAt(i));
        }
        // str을 배열로 전환하고, t만큼 회전하면서, que에 poll과 삽입을 반복
        String[] tmp = str.split(""); //.....snowball
        for (int i = 0; i < t; i++) {
            que.poll();
            //System.out.print(tmp[i % tmp.length]+" ");
            // 이미 .....이 들어가있으므로 사이즈를 더하고 반복
            que.add(tmp[(i + n)% tmp.length]); // s n o w b a l l
        }

        while(!que.isEmpty()){
            answer += que.poll();
        }
        
        return answer;
    }
    public static void main(String[] args){
        solution(5,"snowball",18);
    }
}
