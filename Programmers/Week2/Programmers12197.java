package Programmers.Week2;
/*
    영상처리의 CNN 배열 계산하기
    zero-padding, 평균값으로 계산
    K가 주어지면 해당 인덱스에서 KxK의 CNN값을 계싼
    3 <= K <= 201, K는 홀수

 */
public class Programmers12197 {
    public int[][] solution(int[][] image, int K) {
        int n = image.length;
        int m = image[0].length;
        int[][] output = new int[n][m];

        int pad = K / 2; // 패딩 계산
        int[][] paddedInput = new int[n + 2 * pad][m + 2 * pad]; // 제로 패딩이 적용될 배열

        // 제로 패딩을 입힌 배열 생성
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                paddedInput[i + pad][j + pad] = image[i][j];
            }
        }
        // 확인차 출력 부분
        for (int i = 0; i < paddedInput.length; i++) {
            for (int j = 0; j < paddedInput.length; j++) {
                System.out.print(paddedInput[i][j]);
            }
            System.out.println();
        }

        // 컨볼루션 연산 수행
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int sum = 0;

                // 인덱스 기준 제로패딩 포함 컨볼루션 계산 0,0이면 K가 3x3일때
                // -1,-1 ~ 1, 1 까지
                for (int ki = -pad; ki <= pad; ki++) {
                    for (int kj = -pad; kj <= pad; kj++) {
                        // 기준값은 conv연산하고자 하는 위치 i+pad이고, 연산 범위는 ki와 kj로 조정
                        sum += paddedInput[i + ki + pad][j + kj + pad];
                    }
                }
                output[i][j] = (int)(sum / (float)(K * K));
            }
        }

        return output;
    }
}
