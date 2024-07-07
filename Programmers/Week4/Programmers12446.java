package Programmers.Week4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
    CPU의 작업 스케줄러를 구현하려고한다

    -CPU가 처리할 작업이 없으면 IDLE 상태를 유지한다
    -CPU가 처리할 작업이 있는 경우 가장 처리 시간이 짧은 작업을 선택하여 처리한다
    -CPU는 하나의 작업이 끝날 때 까지 멈추지 않고 처리한다
    -CPU가 하나의 작업을 모두 마친 후에 다른 작업을 수행할 수 있다

    start 배열에는 처리할 작업이 CPU에 주어진 시간이고
    time 배열은 각 작업을 처리하는데 걸리는 시간이 담긴 배열이다

    처리시간이 동일하고, 동시에 처리 가능할 경우 낮은 인덱스의 작업을 먼저 수행한다
 */
public class Programmers12446 {
    public int[] solution(int[] start, int[] time) {
        ArrayList<Integer> answer= new ArrayList<>();
        int startidx = -1;
        int starttime = Integer.MAX_VALUE;
        int timer = 0;
        //최소 도착시간을 찾아야함
        for (int i = 0; i < start.length; i++) {
            if (start[i] < starttime) {
                // 새로운 최소 시작 시간 발견, 시작 시간과 처리 시간 모두 업데이트
                starttime = start[i];
                startidx = i;
                timer = time[i];
            } else if (start[i] == starttime && time[i] < timer) {
                // 동일한 최소 시작 시간에 대해 더 작은 처리 시간 발견
                starttime = start[i];
                startidx = i;
                timer = time[i];
            }
        }
        answer.add(startidx);
        start[startidx] = -1;

        while(answer.size() < start.length){
            Map<Integer,Integer> map = new HashMap<>();
            // 다음 실행가능한 job들 map에 삽입
            for (int i = 0; i <start.length; i++) {
                if(start[i] != -1 && start[i] <= timer){
                    map.put(i,time[i]);
                }
            }
            //들어와있는 가능한 job들의 idx
            int minidx = -1;
            int mintime = Integer.MAX_VALUE;
            // 맵을 순환하면서 인덱스랑 시간 받아옴
            for (int idx : map.keySet()){
                if(map.get(idx) < mintime){
                    mintime = map.get(idx);
                    minidx = idx;
                }
            }
            if(minidx == -1){
                break;
            }
            start[minidx] = -1;
            answer.add(minidx);
            timer += mintime;
        }
        int[] result = new int[answer.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = answer.get(i);
        }

        return result;
    }
}
