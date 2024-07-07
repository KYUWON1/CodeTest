package Programmers.OtherTest;

import java.util.Arrays;

/*
내용이 정수로 이루어진 문자열 s가 있다. 이때 문자열을 더 많이 포함된 순서대로 숫자를 출력하는 프로그램을 작성하시오
출력시 숫자는 공백으로 구분하고, 등장하지않은 숫자로 0번 등장한것으로 가정해서 출력
ex) "221123" = > "2 1 3 0 4 5 6 7 8 9"
 */
public class Programmers11455 {
    public String solution(String s) {
            String answer = "";
            StringBuilder output = new StringBuilder();

            int[] arr = new int[10];
            for(String str: s.split("")){
                arr[Integer.parseInt(str)]++;
            }

            while(true){
                //가장 많이 나온 값의 Idx를 찾음
                int max = 0;
                int maxIdx = 0;
                boolean isAll = true;
                for (int i = 0; i < arr.length; i++) {
                    if(arr[i] > max){
                        max = arr[i];
                        maxIdx = i;
                    }
                    if(arr[i] > -1){
                        isAll = false;
                    }
                }
                if(isAll){
                    break;
                }
                if(arr[maxIdx] == 0){ // 값이 0이면 루프 탈출
                    break;
                }
                //여기서 맥스값이랑 맥스 인덱스 찾으면 출력하고 해당 값 -1로 변경
                answer += String.valueOf(maxIdx);
                arr[maxIdx] = -1;
            }

            for (int i = 0; i < arr.length; i++) {
                if(arr[i] == 0){
                    answer += String.valueOf(i);
                }
            }

            // 문자열을 순회하면서 각 문자 뒤에 공백을 추가하여 StringBuilder에 추가
            for (int i = 0; i < answer.length(); i++) {
                output.append(answer.charAt(i));
                // 문자열의 마지막 문자가 아닌 경우에만 공백 추가
                if (i < answer.length() - 1) {
                    output.append(" ");
                }
            }

            return output.toString();
    }
}
