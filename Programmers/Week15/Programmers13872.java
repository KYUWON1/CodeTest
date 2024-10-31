package Programmers.Week15;

/*
    체육관에 농구공을 1개씩 담을수있는 통이 일렬로 배치되어있다.
    통의 위치는 buckets로 주어지며, 농구공 총 m개를 통안에 넣으려고한다.
    i번째 통에 들어있는 농구공과 j번째 통에 들어있는 농구공 사이의 거리를
    | bucket[i]  - bucket[j]| 라고하자
    이때 농구공 사이의 거리 중 가장 가까운 거리가 최대가 되도록 배치하려한다.

    가장 가까운 거리가 최대? -> 간격을 최대로 해서 배치 하기
    ex ) 1,2,3,4,7이 있고 농구공이 3개면 1 4 7 에 넣어야 가장 가까운 거리가 3으로 최대
    ex ) 1,2,3,4,19999고 농구공이 2개면 1, 199999에 넣어야 가장 가가운 거리가 최대
    위 조건에 맞게 배치했을때, 농구공 사이의 최소 거리를 구하시오

    이진탐색으로 해결
 */

public class Programmers13872 {
    public int solution(int[] buckets, int m) {
        // 농구공이 2개 일때는 처음과 끝에 넣는게 가장 크다
        if(m == 2){
            return buckets[buckets.length-1] - buckets[0];
        }
        int left = 1;
        int right = buckets[buckets.length-1] - buckets[0];
        int result = 0;
        while(left <= right){
            int mid = left + (right - left) / 2;

            if(canPlace(buckets,m,mid)){
                result = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return result;
    }
    public static boolean canPlace(int[] buckets, int m,int distance){
        int count = 1;
        int lastPosition = buckets[0];

        for (int i = 1; i < buckets.length; i++) {
            if(buckets[i] - lastPosition >= distance){
                count++;
                lastPosition = buckets[i];
                if(count == m ){
                    return true;
                }
            }
        }

        return false;
    }
}
