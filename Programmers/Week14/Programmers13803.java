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

    DP 방식으로 접근, 따져야할 모든 경우의 수
    * 1. 시작점에서 출발하여 도개걸
    * 2. 숏컷을 타고 도개걸
    * 3. 시작점에서 출발하여 윷모 + 도개걸윷모
    * 4. 숏컷을 타고 윷모 + 도개걸윷모
    * 5. 시작점에서 출발할아여 윷모 + 숏컷을 타고 도개걸윷모
    * 6. 숏컷을 타고 윷모 + 숏컷을 타고 도개걸윷모
 */

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Programmers13803 {
    public int solution(int N, int[][] edges) {
        int[] dp = new int[N+1];
        Arrays.fill(dp,N);
        dp[0] = 0;

        // 0 : 1번 던졌을때  4 : 윳으로 2번 던짐   5 : 모로 2번 던짐
        List<Integer> firstMove = Arrays.asList(0,4,5);
        // 1번 던졌을때는 도 개 걸 중에만 가능
        List<Integer> secondMove1 = Arrays.asList(1,2,3);
        // 2번 던졌을때는 도 개 걸 윷 모 다 가능
        List<Integer> secondMove2 = Arrays.asList(1,2,3,4,5);

        for (int i = 0; i < N; i++) {
            int finalI = i;
            // 현재 위치의 지름길 추가. 지름길 사용시 -1 됨으로 -1
            List<Integer> shortcuts = new ArrayList<>(Arrays.stream(edges)
                    .filter(x -> x[0] == finalI)
                    .mapToInt(x -> x[1] - 1)
                    .boxed()
                    .collect(Collectors.toList()));

            shortcuts.add(i);

            for (int start : shortcuts) {
                for (int move1 : firstMove) {
                    int j = start + move1;
                    List<Integer> shortcuts2 = new ArrayList<>();
                    if (move1 > 0) { // 1번 던지는 경우, 숏컷을 2번 탈 수 없다.
                        // 윷모 이후에 2번째 던질 때 타고 갈 수 있는 숏컷을 모두 찾는다.
                        shortcuts2.addAll(Arrays.stream(edges)
                                .filter(x -> x[0] == j)
                                .mapToInt(x -> x[1] - 1) // 숏컷으로 이동하는 데에 1회 이동하므로 -1
                                .boxed()
                                .collect(Collectors.toList()));
                    }
                    // 숏컷을 쓰지 않는 경우도 추가
                    shortcuts2.add(j);

                    for (int start2: shortcuts2) {
                        // 1번 던지는 경우 도개걸만 가능 (만약 윷모가 나온다면, 1번 던지는 것이 모순)
                        // 2번 던지는 경우 도개걸윷모 모두 가능
                        List<Integer> secondMoves = move1 == 0 ? secondMove1 : secondMove2;
                        for (int move2: secondMoves) {
                            int k = start2 + move2;
                            if (k <= N) {
                                dp[k] = Math.min(dp[k], dp[i] + 1);
                            }
                        }
                    }
                }
            }


        }
        return dp[N];
    }

    public static void main(String[] args) {
        int N = 34;
        int[][] edges = {{1, 4}, {6, 12}, {15, 24}};
        System.out.println(new Programmers13803().solution(N, edges));
    }
}
