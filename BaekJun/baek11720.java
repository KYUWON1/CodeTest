package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class baek11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String nums = br.readLine();
        int count = 0;
        for (int i = 0; i < nums.length(); i++) {
            count += Integer.parseInt(String.valueOf(nums.charAt(i)));
        }
        System.out.println(count);
    }
}
