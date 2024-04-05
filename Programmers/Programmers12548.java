package Programmers;
/*
문자열 배열 array와 문자열 s 가 주어진다
s의 접두사가 되는 array의 요소의 개수를 출력하는 프로그램을 작성하시오
ex) array = { n, nav, nev}
s = naver , n 과 nav 2개
 */

public class Programmers12548 {
    public int solution(String[] array, String s) {
            int answer = 0;

            for (int i = 0; i < array.length; i++) {
                // String의 startsWith로 손쉽게 가능하다 .
                if (s.startsWith(array[i])) {
                    answer++;
                }
            }

            return answer;
    }

}
