package Week1;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args){
        System.out.println("[입장권 계산]");
        int price = 10000;

        Scanner sc = new Scanner(System.in);
        System.out.print("나이를 입력해 주세요.(숫자):");
        int age = sc.nextInt();
        System.out.print("입장시간을 입력해 주세요.(숫자입력):");
        int time = sc.nextInt();
        sc.nextLine();
        System.out.print("국가유공자 여부를 입력해 주세요.(y/n):");
        String st1 = sc.nextLine();
        System.out.print("복지카드 여부를 입력해 주세요.(y/n):");
        String st2 = sc.nextLine();

        if(st1.equals("y") || st2.equals("y")){
            price = 8000;
        }
        if(time >= 17 || age < 13){
            price = 4000;
        }
        if(age < 3){
            price = 0;
        }
        System.out.printf("입장료: %d",price);
    }
}
