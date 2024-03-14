package Week1;

import java.util.Random;
import java.util.Scanner;
//심규원

public class Task4 {
    public static void main(String[] args){
        System.out.println("[주민등록번호 계산]");
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();

        System.out.print("출생년도를 입력해 주세요.(yyyy):");
        int year = sc.nextInt() % 100;
        sc.nextLine();
        System.out.print("출생월을 입력해 주세요.(mm):");
        String month = sc.nextLine();
        System.out.print("출생일을 입력해 주세요.(dd):");
        String day = sc.nextLine();
        System.out.print("성별을 입력해 주세요.(m/f):");
        String gender = sc.nextLine().equals("m") ? "3" : "4";
        int randN = rd.nextInt(99999) + 1;
        String randNum = String.format("%05d",randN);

        String number = Integer.toString(year) + month + day + "-" +gender+randNum;
        System.out.println("number = " + number);
    }
}
