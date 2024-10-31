package Programmers.Week16;

import java.util.PriorityQueue;
import java.util.Collections;

public class Programmers14011 {
    public int solution(int[] nums) {
        int n = nums.length / 3;
        int[] leftSum = new int[nums.length];
        int[] rightSum = new int[nums.length];

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int sum = 0;
        // Compute the maximum sum for the first part
        for (int i = 0; i < 2 * n; i++) {
            maxHeap.offer(nums[i]);
            sum += nums[i];
            if (maxHeap.size() > n) {
                sum -= maxHeap.poll();
            }
            leftSum[i] = sum;
        }

        sum = 0;
        // Compute the minimum sum for the second part
        for (int i = nums.length - 1; i >= n; i--) {
            minHeap.offer(nums[i]);
            sum += nums[i];
            if (minHeap.size() > n) {
                sum -= minHeap.poll();
            }
            rightSum[i] = sum;
        }

        int minDiff = Integer.MAX_VALUE;
        for (int i = n - 1; i < 2 * n; i++) {
            int diff = leftSum[i] - rightSum[i + 1];
            minDiff = Math.min(minDiff, diff);
        }

        return minDiff;
    }

    public static void main(String[] args) {
        Programmers14011 solver = new Programmers14011();
        int[] nums1 = {10, 4, 9, 6, 8, 1, 9, 4, 10, 4, 5, 8};
        int[] nums2 = {7, 9, 1, 5, 8, 3};
        System.out.println(solver.solution(nums1)); // 예상 결과: -13
        System.out.println(solver.solution(nums2)); // 예상 결과: -5
    }
}
