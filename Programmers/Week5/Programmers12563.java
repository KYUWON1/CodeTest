package Programmers.Week5;
/*
    철수는 N대의 자동 튀김기를 만들어냈다

    각 튀김기는 양산에 들어가기 전, 프로토타입으로 만든 튀김기라 각각 동작의 특성이 다르다
    i 번째 자동 튀김기는 치킨을 한 번 튀기는 데에 fry[i] 만큼의 시간이 걸리며,
    튀김이 끝나면 clean[i] 만큼의 시간동안 자동 세척을 한다

    철수가 M 번 치킨을 튀겨내려고 할 때, 최소한 몇 시간 동안 자동 튀김기를 가동해야하는지 계산해라
 */
import java.util.PriorityQueue;

public class Programmers12563 {
    class Fryer implements Comparable<Fryer> {
        int index; // 튀김기의 인덱스
        int nextAvailableTime; // 다음 사용 가능 시간

        Fryer(int index, int nextAvailableTime) {
            this.index = index;
            this.nextAvailableTime = nextAvailableTime;
        }

        @Override
        public int compareTo(Fryer other) {
            return Integer.compare(this.nextAvailableTime, other.nextAvailableTime);
        }
    }

    public int solution(int N, int M, int[] fry, int[] clean) {
        int answer = 0;
        PriorityQueue<Fryer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.add(new Fryer(i, 0)); // 초기에 모든 튀김기는 사용 가능
        }

        for (int i = 0; i < M; i++) {
            Fryer nextFryer = pq.poll();
            //마지막엔 튀긴 시간만 더하고 break;
            // 튀김기의 개수만큼 빼준다
            if(i > M - N){ //
                nextFryer.nextAvailableTime += fry[nextFryer.index];
                pq.add(nextFryer);
                break;
            }
            int fryTime = fry[nextFryer.index];
            int cleanTime = clean[nextFryer.index];

            nextFryer.nextAvailableTime += fryTime + cleanTime;

            pq.add(nextFryer);
        }
        while (!pq.isEmpty()) {
            answer = Math.max(answer, pq.poll().nextAvailableTime); // 모든 튀김기의 최종 시간 중 최대값
        }

        return answer;
    }

    public int _solution(int N, int M, int[] fry, int[] clean) {
        int answer = 0;
        // 0 : 튀김시간 1: 청소시간 2: 다음가능시간
        int[][] timeArr = new int[fry.length][3];
        for (int i = 0; i < fry.length; i++) {
            timeArr[i][0] = fry[i];
            timeArr[i][1] = clean[i];
            timeArr[i][2] = 0; // 최초에 0으로 초기화
        }

        int time = 0;
        int chickCnt = 0;
        boolean flag = false;
        while(chickCnt != M){
            for (int i = 0; i < timeArr.length; i++) {
                if(timeArr[i][2] == time){
                    timeArr[i][2] += timeArr[i][0] + timeArr[i][1];
                    chickCnt++;
                }
                if(chickCnt == M){
                    time += timeArr[i][0];
                    flag = true;
                    break;
                }
            }
            if(flag){
                answer = time;
                break;
            }
            time++;
        }
        return answer;
    }
}