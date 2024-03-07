package Week1;
//심규원

import java.time.LocalDate;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        System.out.println("[달력 출력 프로그램]");
        Scanner sc = new Scanner(System.in);

        System.out.print("달력의 년도를 입력해 주세요.(yyyy):");
        int year = sc.nextInt();
        System.out.print("달력의 월을 입력해 주세요.(mm):");
        int month = sc.nextInt();
        int day = 1;

        //달력 형식 출력 부분
        for(int i = 0; i < 3; i++){
            System.out.printf("[%d년 %02d월]\t\t\t\t\t\t",year,month-1+i);
        }
        System.out.println();
        for (int i = 0; i <3; i++) {
            System.out.print("일\t월\t화\t수\t목\t금\t토\t\t\t");
        }
        System.out.println();
        //

        //가장 윗줄 출력
        for(int t=0;t<3;t++){
            LocalDate initDate = LocalDate.of(year,month+t-1,day); // 날짜 세팅
            int dayNum = initDate.lengthOfMonth(); // 달의 길이
            int dow = initDate.getDayOfWeek().getValue(); // 해당 달의 시작 요일

            for(int j=0; j< dow; j++){
                System.out.print("1 \t");
            }

            for(int k=1; k< dayNum; k++) {
                System.out.printf("%02d\t", k);
                if ((dow + k) % 7 == 0) {
                    System.out.print("\t\t");
                    break;
                }
            }
        }
        System.out.println();
        for(int t=-1;t<2;t++){
            LocalDate initDate = LocalDate.of(year,month+t,day); // 날짜 세팅
            int dayNum = initDate.lengthOfMonth(); // 달의 길이
            int dow = initDate.getDayOfWeek().getValue(); // 해당 달의 시작 요일 인덱스

            int week2 = 7 - dow;
            int count = 0;
            for(int k=week2+1; k< dayNum; k++) {
                System.out.printf("%02d\t", k);
                count++;
                if ( count == 7) {
                    System.out.print("\t\t");
                    break;
                }
            }
        }
        System.out.println();
        for(int t=-1;t<2;t++){
            LocalDate initDate = LocalDate.of(year,month+t,day); // 날짜 세팅
            int dayNum = initDate.lengthOfMonth(); // 달의 길이
            int dow = initDate.getDayOfWeek().getValue(); // 해당 달의 시작 요일 인덱스

            int week2 = 14 - dow;
            int count = 0;
            for(int k=week2+1; k< dayNum; k++) {
                System.out.printf("%02d\t", k);
                count++;
                if ( count == 7) {
                    System.out.print("\t\t");
                    break;
                }
            }
        }
        System.out.println();
        for(int t=-1;t<2;t++){
            LocalDate initDate = LocalDate.of(year,month+t,day); // 날짜 세팅
            int dayNum = initDate.lengthOfMonth(); // 달의 길이
            int dow = initDate.getDayOfWeek().getValue(); // 해당 달의 시작 요일 인덱스

            int week2 = 21 - dow;
            int count = 0;
            for(int k=week2+1; k< dayNum; k++) {
                System.out.printf("%02d\t", k);
                count++;
                if ( count == 7) {
                    System.out.print("\t\t");
                    break;
                }
            }
        }
        System.out.println();
        for(int t=-1;t<2;t++){
            LocalDate initDate = LocalDate.of(year,month+t,day); // 날짜 세팅
            int dayNum = initDate.lengthOfMonth(); // 달의 길이
            int dow = initDate.getDayOfWeek().getValue(); // 해당 달의 시작 요일 인덱스

            int week2 = 28 - dow;
            int empty = 31 - dayNum;
            int count = 0;
            for(int k=week2+1; k<= dayNum; k++) {
                System.out.printf("%02d\t", k);
                count++;
                if(count == 7){
                    break;
                }
            }
            for (int i = 0; i < empty; i++) {
                System.out.print("  \t");
            }
            System.out.print("\t\t");
        }
        System.out.println();
        for(int t=-1;t<2;t++){
            LocalDate initDate = LocalDate.of(year,month+t,day); // 날짜 세팅
            int dayNum = initDate.lengthOfMonth(); // 달의 길이
            int dow = initDate.getDayOfWeek().getValue(); // 해당 달의 시작 요일 인덱스

            int week2 = 35 - dow; //
            int empty = 31 - dayNum;
            int count = 0;
            if(week2 >= dayNum){ //30 31
                System.out.print("\t\t\t\t\t\t\t\t\t");
            }
            for(int k=week2+1; k<= dayNum; k++) {
                System.out.printf("%02d\t", k);
            }


        }












    }
}
