package Programmers.Week6;

import java.util.ArrayList;

/*
    알고리즘 '슬라이딩 윈도우 최대값'으로 연속된 k개의 값의 최대값을 한칸씩 이동하면서 구하는 기법이다

    에를 들어 입력이 arr = [4,2,6,4,2,3] 일때,
    k = 3인 슬라이딩 윈도우와 그 최대값은
    [4,2,6] = 6
        [2,6,4] = 6
            [6,4,2] = 6
                [4,2,3] = 4
    이런식으로 계산 된다.
    따라서 arr에 대한 슬라이딩 윈도우의 최대값은 6,6,6,4 이다.

    슬라이딩 윈도우 알고리즘을 구현하시오.
 */
public class Programmers12607 {
    public int[] solution(int[] arr, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length-k+1; i++) {
            System.out.println(i);
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < k; j++) {
                if(arr[i+j] > max){
                    max = arr[i+j];
                }
            }
            list.add(max);
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
