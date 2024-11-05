package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    학점 계산하는 법 (등급 * 학점 / 총학점)
 */
public class baek25206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        double scores = 0.0;
        double total = 0.0;
        for (int i = 0; i < 20; i++) {
            // 과목명 학점 등급
            String[] str = br.readLine().split(" ");
            if(str[2].equals("P")){
                continue;
            }else if(str[2].equals("F")){
                total += Double.parseDouble(str[1]);
            }else if(str[2].equals("A+")){
                total += Double.parseDouble(str[1]);
                scores += (4.5 * Double.parseDouble(str[1]));
            }else if(str[2].equals("A0")){
                total += Double.parseDouble(str[1]);
                scores += (4.0 * Double.parseDouble(str[1]));
            }else if(str[2].equals("B+")){
                total += Double.parseDouble(str[1]);
                scores += (3.5 * Double.parseDouble(str[1]));
            }else if(str[2].equals("B0")){
                total += Double.parseDouble(str[1]);
                scores += (3.0 * Double.parseDouble(str[1]));
            }else if(str[2].equals("C+")){
                total += Double.parseDouble(str[1]);
                scores += (2.5 * Double.parseDouble(str[1]));
            }else if(str[2].equals("C0")){
                total += Double.parseDouble(str[1]);
                scores += (2.0 * Double.parseDouble(str[1]));
            }else if(str[2].equals("D+")){
                total += Double.parseDouble(str[1]);
                scores += (1.5 * Double.parseDouble(str[1]));
            }else if(str[2].equals("D0")){
                total += Double.parseDouble(str[1]);
                scores += (1.0 * Double.parseDouble(str[1]));
            }
        }
        System.out.println(scores/total);
    }
}
