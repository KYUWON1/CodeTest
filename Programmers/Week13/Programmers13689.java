package Programmers.Week13;

/*
    N개의 노드와 edges[i] ={ 이전노드, 다음노드} 로 이루어진 윷놀이 판에서, 1번 노드에서 시작해서 N번 노드로
    도착하는 최소 윷놀이 횟수를 구해라
    - 모(0) : 5칸이동후 한번더 던짐
    - 도(1) : 1칸 이동
    - 개(2) : 2칸 이동
    - 걸(3) : 3칸 이동
    - 윷(4) : 4칸 이동후 한번 더 던짐
    - 모나 윷이 여러번나와도 총 던지는 횟수는 2회로 제한
    이전 노드에서 다음 노드로는 이동 가능하나 다음 노드에서 이전노드로는 불가능
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Programmers13689 {
    public static class GameState {
        int node;
        int counts;
        int extraThrows;

        public GameState(int node, int counts, int extraThrows) {
            this.node = node;
            this.counts = counts;
            this.extraThrows = extraThrows;
        }
    }

    public int solution(int N, int[][] edges) {
        // 그래프 구성
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
        }

        // BFS를 위한 큐
        Queue<GameState> queue = new LinkedList<>();
        queue.add(new GameState(1, 0, 0)); // 시작 노드, 던진 횟수, 추가 던질 수 있는 횟수

        // 방문한 노드와 던진 횟수를 기록
        Map<Integer, Integer> visited = new HashMap<>();
        visited.put(1, 0);

        while (!queue.isEmpty()) {
            GameState current = queue.poll();

            // 목표 노드에 도달했을 경우
            if (current.node == N) {
                return current.counts;
            }

            // 다음 노드로 이동
            if (graph.containsKey(current.node)) {
                for (int next : graph.get(current.node)) {
                    int[] results = {1, 1, 2, 3, 4}; // 도, 개, 걸, 윷, 모의 이동 칸 수
                    for (int i = 0; i < results.length; i++) {
                        int nextNode = current.node + results[i];
                        int extra = (i == 0 || i == 4) && current.extraThrows < 2 ? 1 : 0; // "모"와 "윷"일 때만 추가
                        int newThrows = current.counts + 1;
                        GameState newState = new GameState(nextNode, newThrows, current.extraThrows + extra);

                        // 최소 던지기 횟수로 업데이트
                        if (!visited.containsKey(nextNode) || visited.get(nextNode) > newThrows) {
                            visited.put(nextNode, newThrows);
                            queue.add(newState);
                        }
                    }
                }
            }
        }

        return -1; // 목표 노드에 도달할 수 없는 경우
    }


}
