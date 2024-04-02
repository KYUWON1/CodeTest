package Programmers;
/*
정수로 이루어진 배열 arr1, arr2 가 주어진다.
두 배열에 동시에 존재하는 정수를  모아서 배열로 출력하는 프로그램을 작성하시오.
여러개의 중복 정수가 나오면 하나만 포함
출력 배열은 오름차순으로 정렬 
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Programmers12618 {
    public int[] solution(int[] arr1, int[] arr2) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if(arr1[i] == arr2[j] && !list.contains(arr1[i])){ // 동시에 가지고있고, 리스트에 해당 값이 없다면
                    list.add(arr1[i]); // 리스트에 넣음
                }
            }
        }
        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
}
