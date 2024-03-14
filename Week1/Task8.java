package Week1;
//심규원

import java.util.Scanner;

public class Task8 {
    //세금 계산 함수
    static double calTax(double income,int taxRate){
        double total = (income * taxRate) / 100;
        System.out.printf("\t%10.0f * %%%3d = %10.0f\n",income,taxRate,total);
        return total;
    }

    //세율에 의한 세율 계산
    static double TaxCal2(double income) {
        double totalTax = 0;
        double[] range = {12000000,46000000,88000000,15000000,300000000,500000000,1000000000};
        double[] rangeGap = {12000000,34000000,42000000,62000000,150000000,200000000,500000000};
        int[] taxRate = {6,15,24,35,38,40,42,45};

        for (int i = 0; i < range.length; i++) {
            if(income <= rangeGap[i]){
                totalTax += calTax(income,taxRate[i]);
                break;
            }else{
                totalTax += calTax(rangeGap[i],taxRate[i]);
                income -= rangeGap[i];
                //System.out.printf("    %.0f   \n",income);
            }
            if(i == range.length-1){
                //System.out.println("10억초과루프");
                totalTax += calTax(income,taxRate[i+1]);
                break;
            }
        }
        return totalTax;
    }

    //누진공제를 통한 세율 계산
    static double TaxCal(double income) {
        double totalTax = 0;
        double[] range = {12000000,46000000,88000000,150000000,300000000,500000000,1000000000};
        double[] deduction ={0,1080000,5220000,14900000,19400000,25400000,35400000};
        int[] taxRate = {6,15,24,35,38,40,42};

        //10억 미만 세율 적용
        for (int i = 0; i < range.length; i++) {
            if(income < range[i]){
                System.out.println("i = " + i);
                totalTax += (income * taxRate[i]) / 100;
                return totalTax-deduction[i];
            }
        }
        //10억 초과시
        //System.out.println("10억초과");
        totalTax += (income * 45 / 100) - 65400000f;
        return totalTax;
    }

    public static void main(String[] args){
        System.out.println("[과세금액 계산 프로그램]");
        Scanner sc = new Scanner(System.in);

        System.out.print("연소득을 입력해 주세요:");
        double income = sc.nextDouble();
        sc.nextLine();

        double payTax1 = TaxCal(income);
        double payTax2 = TaxCal2(income);
        System.out.println();
        System.out.printf("[세율에 의한 세금]: %.0f\n",payTax2);
        System.out.printf("[누진공제 계산에 의한 세금]: %.0f\n",payTax1);
    }
}
