package Programmers.OtherTest;

import java.util.ArrayList;
import java.util.Collections;

public class Programmers11421 {
    public String solution(String[] bj, String[] one, String[] two) {
        String answer = "";
        int price = 450;
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,bj);

        for (int i = 0; i < one.length; i++) {
            list.remove(one[i]);
            price += 150;
        }
        for (int i = 0; i < two.length; i++) {
            list.remove(two[i]);
            price += 300;
        }
        answer = answer + String.valueOf(price) + "만원("+list.get(0)+")";
        return answer;
    }
}
