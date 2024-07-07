package Programmers.Week7;
/*
    IP주소를 복구하는 프로그램을 작성하여라

    프로그램 입력은 숫자만으로 이루어진 문자열이며, 출력은 문자열에 . 을 3개 끼워넣어 가능한 모든
    IP 주소를 나열한 배열이다

    IP주소의 각 숫자는 0이상 255 이하의 숫자로만 이루어지며, 숫자 앞에 붙는 0은 허용되지 않는다

    결과 배열은 오름차순으로 정렬하여 출력하시오
 */

import java.util.ArrayList;
import java.util.List;

public class Programmers12686 {
    public String[] solution(String s) {
        List<String> answer = new ArrayList<>();
        //4보다 작거나 12보다 크면 범위 초과
        if(s.length() < 4 || s.length() > 12){
            return new String[0];
        }
        // 각 부분의 세그먼트를 3중 루프로 나눔
        for (int i = 1; i < 4 && i < s.length() - 2; i++) {
            for (int j = i + 1; j < i + 4 && j < s.length() - 1; j++) {
                for (int k = j + 1; k < j + 4 && k < s.length(); k++) {
                    String part1 = s.substring(0, i);
                    String part2 = s.substring(i, j);
                    String part3 = s.substring(j, k);
                    String part4 = s.substring(k);

                    if (isValid(part1) && isValid(part2) && isValid(part3) && isValid(part4)) {
                        answer.add(part1 + "." + part2 + "." + part3 + "." + part4);
                    }
                }
            }
        }
        String[] result = new String[answer.size()];
        result = answer.toArray(result);

        return result;
    }

    public boolean isValid(String part){
        int len = part.length();
        if(len > 3 || len == 0 || (len > 1 && part.charAt(0) == '0') || Integer.parseInt(part) > 255){
            return false;
        }
        return true;
    }
}
