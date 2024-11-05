package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
   문자열 S와 정수 t 가 주어졌을떄, S의 t번쨰 문자를 출력하는 프로그램을 작성하시오.
 */
public class baek27866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int i = Integer.parseInt(br.readLine());
        System.out.println(s.charAt(i-1));

    }
}
