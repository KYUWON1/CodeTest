package Programmers;

public class Programmers12619 {
    public int solution(int[] arr) {
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if(answer > arr[i]){
                answer = arr[i];
            }
        }
        return answer;
    }
}
