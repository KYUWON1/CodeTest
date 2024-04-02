package Programmers;

import java.util.HashMap;

/*
민규와 지수는 구술 맞추기 게임을 하려고한다. 게임의 방식은
1. 숫자가 적힌 구술이 한 쌍씩 들어있는 주머니가 있다.
2. 각 구술 쌍에는 같은 숫자가 적혀있다. 즉, 주머니에는 같은 숫자를 가진 구슬은 2개씩 들어있다.
3. 술래는 주머니에서 상대가 알지 못하게, 구슬을 빼거나, 빼지 않는다
4. 그후 상대는 주머니를 살펴보고 ,구술을 빼냇는지 여부와, 빼냇다면 그 숫자를 맞추는 게임이다.

구술에 적힌 숫자 배열 arr이 주어질때, 술래가 빼낸 구술의 번호를 출력하는 프로그램을 작성하시오
빼내지 않았다면 0 을 반환하시오
ex) {1 ,2 ,1}
return 2;

ex) {11,22,33,33,22,11}
return 0;
 */
public class Programmers11437 {
    public int solution(int[] arr) {
        int answer = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            // 맵에 해당 숫자를 넣고, 카운트를 0부터 증가
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }
        for (int i = 0; i < arr.length; i++) {
            if(map.get(arr[i]) == 1){ // 한개만 존재한다면,
                answer = arr[i];
            }
        }
        return answer;
    }
}
