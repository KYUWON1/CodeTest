package BaekJun;
/*
라면매니아 교준이네 집 주변에는 N개의 라면 공장이 있다. 각 공장은 1번부터 N번까지 차례대로 번호가 부여되어 있다. 교준이는 i번 공장에서 정확하게 Ai개의 라면을 구매하고자 한다(1 ≤ i ≤ N).

교준이는 아래의 세 가지 방법으로 라면을 구매할 수 있다.

i번 공장에서 라면을 하나 구매한다(1 ≤ i ≤ N). 이 경우 비용은 3원이 든다.
i번 공장과 (i+1)번 공장에서 각각 라면을 하나씩 구매한다(1 ≤ i ≤ N-1). 이 경우 비용은 5원이 든다.
i번 공장과 (i+1)번 공장, (i+2)번 공장에서 각각 라면을 하나씩 구매한다(1 ≤ i ≤ N-2). 이 경우 비용은 7원이 든다.
최소의 비용으로 라면을 구매하고자 할 때, 교준이가 필요한 금액을 출력하는 프로그램을 작성하시오.
 */

import java.util.Scanner;

public class Back18185 {
    public static int solution(int size,int[] ramen){
        int answer = 0;
        int start = 0;

        while(start < size){
            int single = ramen[start] * 3;

            int double_buy = Integer.MAX_VALUE;
            if(start < size-1 && ramen[start] > 0 && ramen[start+1] > 0){
                double_buy = 5;
            }

            int triple_buy = Integer.MAX_VALUE;
            if(start < size-2 && ramen[start] > 0 && ramen[start+1] > 0  && ramen[start+2] > 0){
                triple_buy = 7;
            }

            int minCost = Math.min(single,Math.min(double_buy,triple_buy));
            if(minCost == single){
                ramen[start]--;
            }else if(minCost == double_buy){
                ramen[start]--;
                ramen[start+1]--;
            }else{
                ramen[start]--;
                ramen[start+1]--;
                ramen[start+2]--;
            }

            answer += minCost;
            if(ramen[start] == 0){
                start++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.valueOf(sc.nextLine());
        int[] arr = new int[size];
        String str1 = sc.nextLine();
        String[] str = str1.split(" ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.valueOf(str[i]);
        }

        System.out.println(solution(size,arr));
    }
}
