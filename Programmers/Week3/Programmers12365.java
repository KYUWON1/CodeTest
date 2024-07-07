package Programmers.Week3;
/*
    종찬이는 아메바를 분열 시키는 악취미가있다
    - 아메바가 분열하여 두 개체로 나뉘는데는 1분이 걸린다
    - 분열한 아메바 중 하나는 곧바로 분열을 시작하고, 다른 하나는 delay를 가지고 분열을시작한다
    - 분열하면 기존개체는 사라지고, 다른 두 개체가 생겨난것으로 본다
    - 분열 도중에는 기존개체는 남아있는것이다

    분열시작후 N분 후 까지 생긴 아메바 개체에대한 준비해야 하는 이름의 총 갯수는 ?
 */
public class Programmers12365 {
    public int solution(int delay, int N) {
        if (N == 0) return 1; // 0분 후에는 아메바가 1개 있습니다.

        // 분마다 아메바 개체수를 저장하는 배열
        int[] amoebas = new int[N + 1];
        amoebas[0] = 1; // 초기 아메바 1개로 시작

        for (int i = 0; i < N; i++) {
            // 바로 분열하는 아메바 처리
            amoebas[i + 1] += amoebas[i];
            // 지연된 분열 시작을 처리할 시간이 충분한 경우
            if (i + delay <= N) {
                amoebas[i + delay] += amoebas[i];
            }
        }

        // N분 후의 아메바 총 개체 수를 계산
        int answer = 0;
        for (int i = 0; i <= N; i++) {
            answer += amoebas[i];
        }

        return answer;
    }

}
