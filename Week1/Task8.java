package Week1;
//심규원

import java.util.Scanner;

public class Task8 {
    static int TaxCal(int n){
        int income = n;
        int totalTax = 0;
        //여기를 재귀함수 형태로 작성해야할듯
        if(income <= 12000000){
            totalTax += (income * 6) / 100;
        }else if(income > 12000000){
            totalTax += (income * 6) / 100;
            income -= 12000000;
        }

        return totalTax;
    }

    public static void main(String[] args){
        System.out.println("[과세금액 계산 프로그램]");
        Scanner sc = new Scanner(System.in);

        System.out.print("연소득을 입력해 주세요:");
        int income = sc.nextInt();
        sc.nextLine();

        System.out.println(TaxCal(income));


    }
}
