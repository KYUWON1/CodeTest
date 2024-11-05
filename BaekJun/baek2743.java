package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek2743 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br =
//                new BufferedReader(new InputStreamReader(System.in));
//        String s = br.readLine();
//        System.out.println(s.length());
//    }

    public static void main(String[] args) throws IOException {
        // 9086 번
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            sb.append(s.charAt(0)).append(s.charAt(s.length()-1)).append("\n");
        }
        System.out.println(sb);
    }

}
