package BaekJun;

import java.util.Scanner;

public class baek2941 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        // replace 와 조건식 잘 활용하기 dz= 가 뒤로가면 z=에 의해 먼저 변환될수도있음!
        String[] cro = {"c=","c-","dz=","d-","lj","nj","s=","z="};

        for(String croA : cro){
            s = s.replace(croA,"A");
        }
        System.out.println(s.length());
    }
}
