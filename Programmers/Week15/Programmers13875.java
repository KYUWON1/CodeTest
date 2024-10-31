package Programmers.Week15;

import java.util.Arrays;
import java.util.List;

/*
    정수로 이루어진 배열 nums가 있다
    이 배열의 길이를 3*n 이라고 하자. 이 때 당신은 배열에서 원하는 위치에서
    연속된 n개의 숫자를 제거할 수 있다.
    이렇게 n개의 숫자를 제거한 후에 남이있는 길이 2*n에서 배열의 첫 n개의 숫자의 합을
    sum_first 다음 n개의 숫자의 합을 sum_second라고 하자 sum_first - sum_second를
    diff 라고 할 떄, 이 값의 최소값을 구하시오

    >> ex) 3*4 에서 4개를 제거하면 2*4, sum_first는 작아야되고, sum_second는 커야한다
    >> 1, 2, 3 파트가있으면, n개를 제거했을때, 2는 커져야하고, 걍 노가다 ?
 */
public class Programmers13875 {
    public int solution(int[] nums) {
        int n = nums.length / 3;
        int minDiff = Integer.MAX_VALUE;

        // 모든 가능한 연속된 n개의 부분 배열 제거 시도
        for (int start = 0; start <= nums.length - n; start++) {
            int first_count = 0;
            int first_sum = 0;
            int second_sum = 0;
            for (int i = 0; i < start; i++) {
                first_sum += nums[i];
                first_count++;
                if (first_count == n) {
                    break;
                }
            }
            for (int i = start + n; i < nums.length; i++) {
                if (first_count < n) {
                    first_sum += nums[i];
                    first_count++;
                } else {
                    second_sum += nums[i];
                }
            }

            // 최소 차이 업데이트
            int diff = first_sum - second_sum;
            if (diff < minDiff) {
                minDiff = diff;
            }
        }
        return minDiff;
    }

    // 성능 개선 코드 슬라이딩 윈도우 사용
    public int solution2(int[] nums) {
        int n = nums.length / 3;
        int minDiff = Integer.MAX_VALUE;

        // 연속된 n개 제거 안 한 경우의 전체 합 배열
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // 첫 n개와 마지막 n개의 합을 먼저 계산
        int sumFirst = 0;
        for (int i = 0; i < n; i++) {
            sumFirst += nums[i];
        }

        int sumLast = 0;
        for (int i = nums.length - n; i < nums.length; i++) {
            sumLast += nums[i];
        }

        // 최소 차이 계산
        minDiff = Math.min(minDiff, sumFirst - sumLast);

        // 슬라이딩 윈도우로 다음 가능한 위치의 합 계산
        for (int start = 1; start <= nums.length - 3 * n; start++) {
            sumFirst = sumFirst - nums[start - 1] + nums[start + n - 1];
            sumLast = sumLast - nums[nums.length - n - start] + nums[nums.length - 2 * n - start];

            int diff = Math.abs(sumFirst - sumLast);
            if (diff < minDiff) {
                minDiff = diff;
            }
        }

        return minDiff;
    }
}
