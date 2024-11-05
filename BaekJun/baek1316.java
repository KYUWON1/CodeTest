package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    문제
    그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다. 예를 들면, ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고, kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만, aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.

    단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.

    입력
    첫째 줄에 단어의 개수 N이 들어온다. N은 100보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에 단어가 들어온다. 단어는 알파벳 소문자로만 되어있고 중복되지 않으며, 길이는 최대 100이다.

    출력
    첫째 줄에 그룹 단어의 개수를 출력한다.

    예제 입력 1
    3
    happy
    new
    year
    예제 출력 1
    3

    그룹단어는 a 가나왓으면 그뒤에 a 가 또 나오면 안됨
 */
public class baek1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < N; i++) {
            int[] arr = new int[26];
            boolean isgroup = true;
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                int idx = str.charAt(j) - (int)'a'; // 인덱스
                arr[idx]++; // 등장횟수 추가
                // 2번이상 등장했다면 확인해봐야함
                if(arr[idx] > 1){
                    if(str.charAt(j) != str.charAt(j-1)){
                        isgroup = false;
                        break;
                    }
                }
            }
            if(isgroup)
                count++;
        }
        System.out.println(count);
    }
}
