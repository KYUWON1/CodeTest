package Programmers;
/*
라이프 수치가 적혀있는 카드 뭉치로 게임을 하려고 한다
각 라이프 수치는 cards에 정수배열로 주어진다.
규칙은
1. 두 선수가 라이프가 높은 카드를 하나 고른다
2. 서로 뽑은 카드를 가지고 겨룬다
3. x==y 이면 서로 소멸, x > y 이면 x-y를 x에 넣고, y는 소멸
마지막에 남은 카드뭉치의 라이프 수치를 출력하는 프로그램을 작성하시오.
모든 카드가 소멸되는 경우에는 0 반환
 */

import java.util.PriorityQueue;

public class Programmers11396 {
    public int solution(int[] cards) {
        //pq를 사용해 내림차순으로 정렬후(우선순위가 큰수기준)
        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y)-> y - x);
        for (int i = 0; i < cards.length; i++) {
            pq.offer(cards[i]);
        }
        while(pq.size() >1){
            int num1 = pq.poll();
            int num2 = pq.poll();
            int diff = num1 >= num2 ? num1 - num2 : num2 - num1;
            if(diff != 0){
                pq.offer(diff);
            }
        }
        if(pq.isEmpty()){
            return 0;
        }
        return pq.poll();
    }
}
