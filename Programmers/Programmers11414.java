package Programmers;
/* 좀 어려웟ㄷ... 문제가 애매해서
정수 배열 arr이 주어진다. arr의 각 요소는 0이상 9이하의 정수로 이루어져있다
이때 정수 배열 arr의 요소중 홀수를 반복하고 나머지 요소를 오른쪽으로 shift한 결과를 출력하는 프로그램을 작성하시오
이 과정에서, 배열의 길이보다 바깥쪽으로 밀려난 숫자들은 제거한다. 즉 출력배열과 입력배열의 길이는 같다

ex) 입력 {0,2,1,4,3,0}
    출력 {0,2,1,1,4,3}
 */

public class Programmers11414 {
    public static int[] solution(int[] arr) {
        //마지막엔 홀수 인거 체크할 필요가없음
        for (int i = 0; i < arr.length-1; i++) {

            if (arr[i] % 2 != 0) { // 홀수를 만난 경우
                int idx = arr.length-1; // 마지막 부분
                while(idx != i){ // 마지막 idx3에서 복사까지됨
                    arr[idx] = arr[idx-1];
                    idx--;
                }
                for (int j = 0; j < arr.length; j++) {
                    System.out.print(arr[j]+" ");
                }
                System.out.println();
                i++;
            }
        }
        return arr;
    }

    public static void main(String[] args){
        int[] arr = {0,2,1,4,3,0};
        solution(arr);
    }
}
