package Programmers;

// 다시 풀어보기 중복제거 문제
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Programmers11439 {
    public String solution(String s) {
        String answer = "";
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,s.split(""));

        int idx = 0;
        while(idx < list.size()-1){
            if(list.get(idx).equals(list.get(idx + 1))){
                list.remove(idx);
                list.remove(idx);
            }else{ // 앞뒤가 다르다면
                idx++;
            }
        }
        // 리스트에 남은 문자들을 문자열로 연결하여 반환
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append(str);
        }
        answer = sb.toString();
        return answer;
    }
}
