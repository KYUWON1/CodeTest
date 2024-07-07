package Programmers.OtherTest;
/*
    어떤 문자열을 둘로 나누고 , 두 부분 문자열의 순서를 바꾸는 것을 문자열을 회전시킨다고한다.
    예를 들어 "helloworld" 라는 문자열을 Hello, World 두 부분을 나누어 회전시키면 worldhello가 된다

    S1 과 S2 두 가지 문자열이 주어졌을때, S2가 S1 을 회전시켜 나온 결과인지 판단해 맞으면 1아니면 0을 반환해라
 */

public class Programmers11530 {
    public int solution(String S1, String S2) {
        // 길이가 다르다면 끝
        if (S1.length() != S2.length()) {
            return 0;
        }

        // S2에 S1을 회저시킨 문자열이있는지 확인해본다
        // helloworldhelloworld 라면, 중간에 worldhello가 나와 포함되어있는것을 확인할 수 있다.
        String concatenated = S1 + S1; // S1을 두 번 연결

        // 연결된 문자열이 S2를 포함면 회전성공
        if (concatenated.contains(S2)) {
            return 1;
        } else {
            return 0;
        }
    }
}

