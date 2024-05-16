package Programmers;
/*
    고기집에서는 고기의 부위 별로 amount[i] 만큼의 분량을 준비해 두었으며,
    각 부위의 가격은 단위 분량 당 valuse[i] 원 이라고한다.
    이벤트에 참가한 친구들이 먹을 수 있는 고기의 분량읠 stomach[j]라고 하자

    이 때, 친구들과 섭취한 고기의 가치가 최대가 되게 했을 때 그 가치를 구하시오

    단 가장 가치가 높은 고기는 친구들끼리 공평하게 같은 양을 먹어야하며, 고기의 양은
    양의 정수 단위로만 나뉘어진다. 즉1개씩 먹어도 못먹는 친구가 생긴다면 아무도 먹지 않는다.
 */

import java.util.Arrays;

public class Programmers12605 {
    public int solution(int[] amount, int[] value, int[] stomach) {
        int answer = 0;

        int[][] meat = new int[value.length][2]; // 0: 고기가격 1: 고기갯수
        for (int i = 0; i < meat.length; i++) {
            meat[i][0] = value[i];
            meat[i][1] = amount[i];
        }

        //고기 가격순으로 내림 차순 정렬
        Arrays.sort(meat,(a,b) -> b[0] - a[0]);
//        for (int i = 0; i < meat.length; i++) {
//            System.out.println(meat[i][0]+" "+meat[i][1]);
//        }
        //비싼 고기 계산
        int exp = meat[0][1] / stomach.length; // 사람 수로 나눔
        //System.out.println(exp);
        if(exp != 0){
            for (int i = 0; i < exp; i++) {
                answer += meat[0][0] * stomach.length; // 사람 수 만큼 추가
                for (int j = 0; j < stomach.length; j++) {
                    stomach[j]--; // 하나씩 먹었음으로 감소
                }
            }
        }
        //System.out.println(answer);

        //나머지 고기 계산, 비싼 고기 제외하고 계산
        for (int j = 0; j < stomach.length; j++) {
            //고기가 남았고, 먹을수있는 위장도 있다면, 계산하고 변경
            for (int i = 1; i < meat.length; i++) {
                if(meat[i][1] > 0 && stomach[j] > 0){
                    int cnt = Math.min(meat[i][1],stomach[j]);
                    answer += cnt * meat[i][0];
                    meat[i][1] -= cnt;
                    stomach[j] -= cnt;
                    System.out.println(answer);
                }
            }
        }

        return answer;
    }
}
