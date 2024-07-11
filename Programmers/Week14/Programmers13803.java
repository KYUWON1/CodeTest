package Programmers.Week14;

/*
    윷놀이를 진행하는데, 도착지에 도착하는 가장 적은 턴 수를 알아내려고 한다.

    앞면의 횟수를 가지고,아래와 같이 말을 진행시킨다
    0개 (모) : 5칸 이동후 한번 더 던짐
    1개 (도) : 1칸 이동
    2개 (개) : 2칸 이동
    3개 (걸) : 3칸 이동
    4개 (윷) : 4칸 이동후 한번 더
    총 던지는 횟수는 2회로 제한

    윷놀이 판은 N개의 노드로 이루어져있고, 각 노드간의 기본 연결을 1번 -> 2번 -> 3번 .. 이런식이다
    1번 노드가 출발점, N번 노드가 도착점이다

    기본 연결 외에도 지름길이 있다. 지름길은 edges[i] = {시작 노드, 끝 노드} 로 주어진다
    지름길을 이용하려면 반드시 시작 노드에 멈추어야하고, 사용시 1칸 이동을 사용한것으로 간주한다.

    ex) N = 34, edges = {{1,4},{6,12},{15,24]} 이면
    3번이면 도착할수있다. 모+모, 윷+모, 모+도 로 가능하다
    1-> 6 -> 11 -> 15 -> 28 -> 33 -> 34 도착
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Programmers13803 {
    static class State {
        int position;
        int count;

        State(int position,int count){
            this.position = position;
            this.count = count;
        }
    }
    public int solution(int N, int[][] edges) {
        // 지름길 경로 추가
        Map<Integer, Integer> shortcuts = new HashMap<>();
        for(int[] edge: edges) {
            shortcuts.put(edge[0],edge[1]);
        }

        Queue<State> que = new LinkedList<>();
        que.offer(new State(1,0));

        // 현재 위치 추가
        Map<Integer, Integer> ThrowsPosition = new HashMap<>();
        ThrowsPosition.put(1, 0);

        while(!que.isEmpty()){
            State curr = que.poll();

            if(curr.position >= N){
                return curr.count;
            }

            // Simulate all possible moves
            int[][] moves = {{1, 0}, {2, 0}, {3, 0}, {4, 1}, {5, 1}};
            for (int[] move : moves) {
                //현재위치와 카운트 증가
                int newPosition;
                int newThrowsCount = curr.count + 1;

                // 지름길에 서있다면, 이동ㅌ`
                if(shortcuts.containsKey(curr.position)){
                    newPosition = shortcuts.get(curr.position) + move[0] -1;
                }else{
                    newPosition = curr.position + move[0];
                }

                //모나 윷이면 한번더
                if (move[1] == 1) {
                    // 지름길에 서있다면, 이동
                    if (shortcuts.containsKey(curr.position)) {
                        newPosition = shortcuts.get(curr.position) + move[0] - 1;
                    } else {
                        newPosition = curr.position + move[1];
                    }
                }

                if (!ThrowsPosition.containsKey(newPosition)) {
                    ThrowsPosition.put(newPosition, move[0]);
                    que.add(new State(newPosition, newThrowsCount));
                }

                if (newPosition > N) {
                    continue; // Skip if the position exceeds the last node
                }

            }
        }
        return -1;
    }
}
