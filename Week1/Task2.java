package Week1;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int price;
        int cashBack;

        System.out.print("[캐시백 계산]\n");
        System.out.print("결제 금액을 입력해 주세요.(금액):");
        price = sc.nextInt();
        cashBack = (int)(Math.floor(price / 1000) * 100);
        if(cashBack >= 300){
            cashBack = 300;
        }
        System.out.printf("결제 금액은 %d원이고, 캐시백은 %d원 입니다.",price,cashBack);
    }
}
