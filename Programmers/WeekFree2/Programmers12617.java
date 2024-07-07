package Programmers.WeekFree2;


import java.util.Arrays;


/*
문자열 s 가있는데, 해당 문자열엔 여러개의 단어가 공백으로 구분되어 적혀져있다.
이 문자열에서 중복된 단어를 제외한 단어의 수를 출력하는 프로그램을 작성하시오.
ex) "Hello world bye world"  ==  3
 */
public class Programmers12617 {
    public int solution(String s) {
        //s를 공백으로 분리한 array를 만들고, distinct()를 통해, 중복을 제거하고,
        //스트림을 toArray로 다시 String[]로 반환
        String[] resultSize = Arrays.stream(s.split(" "))
                .distinct()
                .toArray(String[]::new);
        return resultSize.length;
    }
}
