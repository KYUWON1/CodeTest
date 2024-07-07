package Programmers.Week4;
/*
    시작 가사 일부를 입력받아 해당 가사와 일치하는 모든 노래를 빠르게 찾는 프로그램을 만드려고한다

    -미리선정된 N개의 노래
    -문제로 출제될 노래는 미리 선정된 N개의 노래중에서 출제하기로 하였다
    -길이가 N인 배열 titles에는 각 노래의 제목이 적혀있다.
    -길이가 N인 배열 lyrics에는 각 노래의 가사가 공백없이 적혀있다
    -총 M개의 문제를한번에 해결한다
    -길이가 M인 배열 problems에는 시작 가사 일부가 공백없이 적혀있다

    프로그램을 각 문제에 대한 M개의 답을 배열로 반환한다
    -각 문제에 대한 답은 시작 가사가 일치하는 모든 노래의 제목을 배열로 나열한것이다
    -해당 배열 내 노래 제목의 순서는 titles 배열에 나타난 순서를 따른다
    -최종 출력은 2차원 문자열 배열로 이루어진다.
 */

import java.util.ArrayList;

public class Programmers12443 {
    // problem의 단어가 lyrics에 포함되면, title을 추가 
    public String[][] solution(String[] titles, String[] lyrics, String[] problems) {
        String[][] answer = new String[problems.length][titles.length]; // mxm
        for (int i = 0; i < problems.length; i++) {
            String start = problems[i];
            ArrayList<String> list = new ArrayList<>();
            for (int j = 0; j < lyrics.length; j++) {
                if(lyrics[j].startsWith(start)){ // 해당 단어로 시작한다면
                    list.add(titles[j]);
                }
            }
            answer[i] = list.toArray(new String[0]);

        }
        return answer;
    }

    public static void main(String[] args) {

    }
}
