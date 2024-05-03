package Programmers;
/*
    뉴욕의 건물들이 어떤 실루엣으로 나타나는지 분석하는 알고리즘을 제작하고자 한다

    건물의 특징은 아래와 같이 buildings 배열로 주어진다
    - buildings 배열은 2차원 배열로, 각 건물의 위치와 높이를 나타낸다
    - 배열의 각 요소는 buildings[i] = left right height 로 건물의 좌우측의 x 좌표와 높이르 나타낸다
    - 총 N개의 건물은 서로 겹처있을수도 , 아닐수더있다
    - 건물의 각 끝점 left와 right 는 유일하다

    출력은
    -실루엣을 표현할수있는 키포인트를 모은 배열을 출력한다
    - x,y 다음 x,y의 형태로 표시한다
    - x 값이 작은순부터 오름추산으로 정렬한다

 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class Programmers12448 {
    public int[][] solution(int[][] buildings) {
        List<int[]> events = new ArrayList<>();
        for (int[] building : buildings) {
            int left = building[0];
            int right = building[1];
            int height = building[2];
            events.add(new int[]{left, -height}); // 시작 이벤트, 높이를 음수로 표시
            events.add(new int[]{right, height}); // 종료 이벤트
        }

        // 이벤트를 x좌표, 높이 순으로 정렬 (높이는 절대값 기준 내림차순)
        events.sort((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return b[1] - a[1]; // 높이가 같다면 종료 이벤트 우선
        });

        // 최대 힙을 사용하여 현재 활성화된 건물들의 높이를 관리
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        map.put(0, 1); // ground level
        int prevMaxHeight = 0;
        List<int[]> result = new ArrayList<>();

        for (int[] event : events) {
            int x = event[0];
            int height = event[1];
            if (height < 0) { // 건물 시작
                map.put(-height, map.getOrDefault(-height, 0) + 1);
            } else { // 건물 끝
                int cnt = map.get(height);
                if (cnt == 1) map.remove(height);
                else map.put(height, cnt - 1);
            }

            int currentMaxHeight = map.firstKey();
            if (currentMaxHeight != prevMaxHeight) {
                result.add(new int[]{x, currentMaxHeight});
                prevMaxHeight = currentMaxHeight;
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
