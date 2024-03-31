package Programmers;

import java.util.ArrayList;
import java.util.Collections;

public class Programmers11525 {
    public static int solution(String S) {
        //초기화
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, S.split(""));
        while(true){
            for (int i = 0; i < list.size()-1; i++) {
                if(list.get(i).equals(list.get(i+1))){ // 연속으로 등장한 문자가 있다면
                    list.remove(i);
                    list.remove(i); // 첫번째 중복 문자 제거
                }
            }
            boolean check = true;
            for (int i = 0; i < list.size()-1; i++) {
                if(list.get(i).equals(list.get(i+1))){ // 중복이 존재한다면,
                    check = false;
                    break;
                }
            }
            if(check){ // 중복을 다 제거하고 break
                break;
            }
        }
        if(list.size() == 0){
            return 1;
        }
        
        return 0;
    }

    public static void main(String[] args){
        solution("ABBA");
    }
}
