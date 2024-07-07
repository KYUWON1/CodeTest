package Programmers.WeekFree1;

import java.util.ArrayList;

public class Programmers11436 {
    // 몇개 실패함
    //주문번호는 1 씩 올라가고, n은 취소된 주문 번호의 위치, ex) 3번쨰 취소된 주문번호
    public static int solution(int[] orders, int n) {
        if (orders.length == 0) {
            return 0; // 주문이 없는 경우 0을 반환하거나 예외 처리를 수행할 수 있습니다.
        }

        // 1 10 13  5번째를 찾는다. 답은 6,
        int max = orders[orders.length-1];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            list.add(i+1);
        }
        //list에서 객체해당 객체 삭제
        for (int order : orders) {
            list.remove(Integer.valueOf(order)); // 주문 번호를 Integer 객체로 변환하여 삭제
        }

        if(n > list.size()){
            return 0;
        }
        return list.get(n-1);
    }

    public static void main(String[] args){
        int[] orders = {2,4,6,8,10};
        int n = 6;
        System.out.println(solution(orders,n));
    }
}
