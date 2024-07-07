package Programmers.OtherTest;
/*
문장 sentence에서 word가 몇 번째 단어와 일치하는지 출력하는 프로그램을 작성하시오
sentence는 공백으로 구분되고 ,0부터 시작 word가 없을시 -1 을 반환하시오
 */
public class Programmers12549 {
    public int solution(String sentence, String word) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (word.equals(words[i])) {
                return i; // 단어가 일치하는 경우 해당 인덱스 바로 반환
            }
        }
        return -1; // 단어가 문장에 포함되어 있지 않은 경우 -1 반환
    }
}
