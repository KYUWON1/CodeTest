package Programmers.Week2;
/*
    복만이의 메신서 서버는 큐를 이용해 메세지를 전달받아 처리하며, 하나의 메시지를 처리하는데 delay ms만큼의 시간이 소요된다
    저장된 큐의 capacity를 넘치는 일이 발생한다.
    메세지는 처리하기 시작하는 순간 큐에서 제거되며, 큐가 꽉차면, 메시지는 손실된다
    또한 큐에 입력과 제거가 동시에 이루어지는경우 제거가 먼저 이루어진다.
    서버의 큐에 이전 메세지가 전달된 후 다음 메세지가 전달될 때 까지 소요된 시간 ms를 모아 times배열에 모았을떄,
    소실되어 전달하지 못한 메세지의 개수를 구하시오

    라우터의 lost 현상
 */

import java.util.LinkedList;
import java.util.Queue;

public class Programmers12196 {
    //delay : 메시지 처리시간, capacity: 큐의 최대용량, times : 이전 메세지가 전달된후 다음 메세지가 전달될떄까지 걸린 시간
    public int solution(int delay, int capacity, int[] times) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        int curTime = 0;  // 현재 시간을 0부터 시작

        for (int i = 0; i < times.length; i++) {
            // 현재 시간에 메시지 간의 간격을 더한다
            curTime += times[i];

            // 큐에서 처리할 수 있는 메시지들을 제거한다
            while (!queue.isEmpty() && queue.peek() <= curTime) {
                queue.poll();
            }

            // 큐에 여유가 있으면 새 메시지 추가
            if (queue.size() < capacity) {
                queue.add(curTime + delay);  // 처리 완료될 시간을 저장
            } else {
                answer++;  // 큐가 가득 차면 메시지 손실
            }
        }

        return answer;
    }
}
