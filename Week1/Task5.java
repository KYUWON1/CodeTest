package Week1;
//심규원

import java.time.LocalDate;
import java.util.Scanner;

public class Task5 {
    static int[] lastDay = { 0,0,0 }; //이전달의 마지막 날짜를 저장할 배열
    
    public static void main(String[] args) {
        System.out.println("[달력 출력 프로그램]");
        Scanner sc = new Scanner(System.in);
        int[][] set = new int[3][2]; //(년도, 달) 형태의 3쌍의 데이터
        int day = 1;

        System.out.print("달력의 년도를 입력해 주세요.(yyyy):");
        int year = sc.nextInt();
        System.out.print("달력의 월을 입력해 주세요.(mm):");
        int month = sc.nextInt();
        //예외처리 2개씩 3쌍이 필요
        if(month == 1){
            set[0][0] = year-1;
            set[0][1] = 12;
            set[1][0] = year;
            set[1][1] = 1;
            set[2][0] = year;
            set[2][1] = 2;
        }else if(month == 12){
            set[0][0] = year;
            set[0][1] = 11;
            set[1][0] = year;
            set[1][1] = 12;
            set[2][0] = year+1;
            set[2][1] = 1;
        }else{
            set[0][0] = year;
            set[0][1] = month-1;
            set[1][0] = year;
            set[1][1] = month;
            set[2][0] = year;
            set[2][1] = month+1;
        }

        PrintDay(year,set);
        PrintLine1(set,1);
        PrintCenter(set,1);
        PrintCenter(set,1);
        PrintCenter(set,1);
        PrintLine2(set,1);
        PrintLastLine(set,1);

    }

    static void PrintLastLine(int[][] set, int day) {
        //달의 마지막줄 체크
        for(int t=0;t<3;t++){
            LocalDate initDate = LocalDate.of(set[t][0],set[t][1],day); // 날짜 세팅
            int dayNum = initDate.lengthOfMonth(); // 달의 길이
            //System.out.printf("%d, %d ",dayNum,lastDay[t]);
            if(lastDay[t] < dayNum){
                lastDay[t]++;
                System.out.printf("%d",lastDay[t]);
            }else{
                System.out.print("\t\t\t\t\t\t\t\t\t");
            }
        }
        System.out.println();
    }

    static void PrintLine2(int[][] set, int day) {
        for(int t=0;t<3;t++){
            LocalDate initDate = LocalDate.of(set[t][0],set[t][1],day); // 날짜 세팅
            int dayNum = initDate.lengthOfMonth(); // 달의 길이
            int count = 0;
            for(int k=lastDay[t]; k<= dayNum; k++) {
                System.out.printf("%02d\t", k);
                lastDay[t] = k;
                count++;

                if(k == dayNum || count == 7){ // 달의 마지막이되면,
                    for(int j=7;j>count;j--){
                        System.out.print("  \t");
                    }
                    System.out.print("\t\t");
                    break;
                }
            }
        }
        System.out.println();
    }

    static void PrintCenter(int[][] set, int day) {
        for(int t=0;t<3;t++){
            LocalDate initDate = LocalDate.of(set[t][0],set[t][1],day); // 날짜 세팅
            int dayNum = initDate.lengthOfMonth(); // 달의 길이
            int count = 0;
            for(int k=lastDay[t]; k< dayNum; k++) {
                System.out.printf("%02d\t", k);
                count++;
                //k에 마지막 날짜 정보 저장
                if (count == 7) {
                    System.out.print("\t\t");
                    lastDay[t] = k+1;
                    break;
                }
            }
        }
        System.out.println();
    }

    static void PrintLine1(int[][] set,int day){
        //가장 윗줄 출력
        for(int t=0;t<3;t++){
            LocalDate initDate = LocalDate.of(set[t][0],set[t][1],day); // 날짜 세팅
            int dayNum = initDate.lengthOfMonth(); // 달의 길이
            int dow = initDate.getDayOfWeek().getValue(); // 해당 달의 시작 요일을 인덱스로 변환

            //빈칸 출력
            if(dow != 7){
                for(int j=0; j< dow; j++){
                    System.out.print("  \t");
                }
            }
            //날짜 출력후, 마지막 날짜를 lashDay 배열에 저장
            for(int k=1; k< dayNum; k++) {
                System.out.printf("%02d\t", k);
                if ((dow + k) % 7 == 0) {
                    System.out.print("\t\t");
                    lastDay[t] = k+1;
                    break;
                }
            }
        }
        System.out.println();
    };

    static void PrintDay(int year, int[][] set){
        //달력 형식 출력 부분
        for(int i = 0; i < 3; i++){
            System.out.printf("[%d년 %02d월]\t\t\t\t\t\t",set[i][0],set[i][1]);
        }
        System.out.println();
        for (int i = 0; i <3; i++) {
            System.out.print("일\t월\t화\t수\t목\t금\t토\t\t\t");
        }
        System.out.println();
    }
}
