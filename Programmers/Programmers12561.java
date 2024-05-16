package Programmers;
/*
    정수로 이루어진 리스트 arr에서 피크의 인덱스 peak를 다음과 같이 정의하자

    0 < peak < arr.length -1
    x[peak-1] < x[peak]
    x[peak+1] < x[peak]

    주어진 배열에서 피크가 최대 한 개 존재할 때, 피크의 인덱스를 출력하시오 
 */
public class Programmers12561 {
    public int solution(int[] arr){
        //배열의 양끝은 제외됨
        int left = 1;
        int right = arr.length - 2; // 끝 제외 다음

        while (left <= right) {
            //오버플로우 방지
            //처음 + 끝 / 2 보단 ,  처음 + 차이의 /2를 더해서 평균을 구할 수 있음 
            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid; // 피크를 찾은 경우
            } else if (arr[mid] < arr[mid + 1]) {
                left = mid + 1; // 오름차순 구간이므로 피크가 mid 오른쪽에 있을 수 있음
            } else {
                right = mid - 1; // 내림차순 구간이므로 피크가 mid 왼쪽에 있을 수 있음
            }
        }

        return -1; // 피크가 없는 경우
    }

    public int solution_(int[] arr) {
        int lastidx = arr.length - 1;

        // 배열의 전체를 순회하며 피크를 찾습니다.
        for (int i = 1; i <= lastidx; i++) {
            if (arr[i] < arr[i - 1]) { // 피크를 발견한 경우
                return i - 1;
            }
        }

        // 마지막 요소를 처리합니다.
        if (lastidx > 0 && arr[lastidx] > arr[lastidx - 1]) {
            if(lastidx != arr.length-1){
                return lastidx;
            }
        }

        return -1; // 피크가 없는 경우
    }
}
