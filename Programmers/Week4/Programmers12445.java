package Programmers.Week4;


import java.util.ArrayList;

/*
    단어 검색엔진 만들기
    - words에 검색 대상이 되는 풀이 배열로 주어진다
    - quries 에 검색하고자하는 검색어들이 배열로 주어진다
    - 배열은 [알파벳][?? 여러개] 의 형태로 주어진다 "hel??"
    - 검색어의 검색 결과는 검색 대상이 되는 모든 단어를 words에 나타난 순서대로 하는 배열이다
    출력은 2차원의 배열로 출력한다
 */

public class Programmers12445 {
    public String[][] solution(String[] words, String[] queries) {
        String[][] answer = new String[queries.length][words.length];
        for (int i = 0; i < queries.length; i++) {
            int len = queries[i].length();
            //?를 ""로 변환
            String word = queries[i].replace("?","");
            ArrayList<String> list = new ArrayList<>();
            for (int j = 0; j < words.length; j++) {
                //길이가 같으면 비교 대상
                if(words[j].length() == len && words[j].startsWith(word)){
                    list.add(words[j]);
                }
            }
            answer[i] = list.toArray(new String[0]);
        }
        return answer;
    }
}
