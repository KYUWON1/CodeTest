package Week1;

import java.util.Random;
import java.util.Scanner;

//심규원
public class Task6 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        int totalVote;
        int totalPer;
        while(true){
            System.out.print("총 진행할 투표수를 입력해 주세요.");
            totalVote = sc.nextInt();
            if(totalVote < 1 || totalVote > 10000){
                System.out.println("투표수 범위초과. 다시 입력하세요.");
                continue;
            }
            sc.nextLine();
            System.out.print("가상 선거를 진행할 후보자 인원을 입력해 주세요.");
            totalPer = sc.nextInt();
            if(totalPer < 2 || totalPer > 10){
                System.out.println("후보자인원 범위초과. 다시 입력하세요.");
                continue;
            }
            sc.nextLine();
            break;
        }


        String[] arr = new String[totalPer]; //후보자 이름 배열
        int[] ticket = new int[totalPer]; // 각 후보자에 대한 투표개수 배열
        double count = 0; //투표를 한 횟수 카운트
        
        for(int i=0;i<totalPer;i++){
            System.out.printf("%d번째 후보자이름을 입력해 주세요.",i+1);
            arr[i] = sc.nextLine();
            if(arr[i].length() >= 10){
                System.out.println("후보자이름 범위초과. 다시 입력하세요.");
                i--;
            }
        }
        System.out.println();
        
        do {
            int randNum = rd.nextInt(totalPer);
            ticket[randNum]++;
            count++;
            System.out.printf("[투표진행률]: %.2f%%, %.0f명 투표 => %s\n", (count / totalVote) *100, count, arr[randNum]);
            for (int i = 0; i < totalPer; i++) {
                System.out.printf("[기호:%d] %s:  %.2f%% (투표수: %d)\n",i+1,arr[i],(ticket[i]/(float)totalVote) *100,ticket[i]);
            }
            System.out.println();
        } while (count != totalVote);

        int maxIndex = 0;
        for (int i = 1; i < ticket.length; i++) {
            if (ticket[i] > ticket[maxIndex]) {
                maxIndex = i;
            }
        }
        System.out.println("[투표결과] 당선인 : "+arr[maxIndex]);

    }
}
