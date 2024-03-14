package Week1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

//심규원
public class Task7 {
    public static void main(String[] args){
        System.out.println("[로또 당첨 프로그램]");
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();

        System.out.print("로또 개수를 입력해 주세요.(숫자 1 ~ 10):");
        int rottoNum = sc.nextInt();
        sc.nextLine();
        int[][] myNum = new int[rottoNum][6];
        // 내 로또 번호 생성 부분
        for (int i = 0; i < rottoNum; i++) {
            for (int j = 0; j < 6; j++) {
                int rand = rd.nextInt(45) + 1; //1~45까지 랜덤 생성
                if(Arrays.stream(myNum[i]).anyMatch(num -> num == rand)){
                    j--;
                }else{
                    myNum[i][j] = rand;
                }
            }
            Arrays.sort(myNum[i]);
        }
        // 내 로또 번호 출력
        for (int i = 0; i < rottoNum; i++) {
            System.out.printf("%c\t",'A'+i);
            for (int j = 0; j < 6; j++) {
                if(j==5){
                    System.out.printf("%d",myNum[i][j]);
                    break;
                }
                System.out.printf("%d,",myNum[i][j]);
            }
            System.out.println();
        }
        // 정답 로또 생성 및 출력
        int[] ans = new int[6];
        for (int i = 0; i < 6; i++) {
            int num = rd.nextInt(45)+1;
            if(Arrays.stream(ans).anyMatch(n -> n == num)){
                i--;
            }else{
                ans[i] = num;
            }
        }
        Arrays.sort(ans);
        System.out.println();
        System.out.print("[로또 발표]\n\t");
        for (int i = 0; i < ans.length; i++) {
            if(i == ans.length-1){
                System.out.printf("%d\n",ans[i]);
                break;
            }
            System.out.printf("%d,",ans[i]);
        }
        // 결과 체크
        int[] ansCount = new int[rottoNum];
        for (int i = 0; i < myNum.length; i++) {
            for (int j = 0; j < myNum[i].length; j++) {
                if(myNum[i][j] == ans[j]){
                    ansCount[i]++;
                }
            }
        }
        //결과 출력
        System.out.println();
        System.out.println("[내 로또 결과]");
        for (int i = 0; i < rottoNum; i++) {
            System.out.printf("%c\t",'A'+i);
            for (int j = 0; j < 6; j++) {
                if(j==5){
                    System.out.printf("%d => %d개 일치",myNum[i][j],ansCount[i]);
                    break;
                }
                System.out.printf("%d,",myNum[i][j]);
            }
            System.out.println();
        }



    }
}
