package Programmers;
/*
    단어 검색 프로그램
    -단어의 검색은 words 배열 내에서 수행한다
    -검색하고자 하는 단어들은 queries 배열로 주어진다
    -각 검색 단어는 단어의 앞부분 또는 뒷부분 일부만으로 구성되어있다
    -앞부분 일부만으로 구성된 경우 단어 마지막에 * 을 붙인다
    -뒷부분 일부만으로 구성된경우 단어 시작에 * 을 붙인다
    -*의 위치에는 길이와 내용이 상관 없이 어떤 문자열이 와도 매칭 대상이된다

    출력은 각 검색 결과에 해당하는 단어의 개수를 배열로 반환한다
 */

public class Programmers12444 {
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int idx = queries[i].indexOf("*");
            // * 없는 문자로 변환
            String word = queries[i].replace("*","");
            for (int j = 0; j < words.length; j++) {
                if(idx == 0){ // 시작지점에 *이라면 뒤에서부터 비교
                    if(words[j].endsWith(word)){
                        answer[i]++;
                    }
                }else { // 앞이라면 앞에서부터 비교
                    if(words[j].startsWith(word)){
                        answer[i]++;
                    }
                }
            }
        }
        return answer;
    }
}
