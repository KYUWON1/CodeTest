package Programmers.Week5;
/*
    제로 지니어스 프로그램에서는 주어진 숫자를 이어붙여 가장 큰 수를 만드는 프로그램을 작성하는 미션이 주어졌다

    문제의 조건은
    - 0또는 양의 정수가 numbers배열로 주어진다
    - numbers 배열에 주어진 정수를 이어붙여 만들 수 있는 가장 큰 정수를 출력한다
    예를 들어 배열에 5 10 2 가 있다면 가장 큰수는 5210 이다

    최대값을 문자열로 출력하시오 .
 */

import java.util.Arrays;
import java.util.Comparator;
public class Programmers12560 {
    //앞자리가 큰것부터 하면 되지않을까?
    public String solution(int[] numbers) {
        // 숫자를 문자열로 변환
        String[] nums = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }

        // 문자열을 비교하여 정렬 예를 들어 30 2 가 있다면 302 와 230을 비교해서 더 큰 숫자가 나오는 방식으로 저장
        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String ab = a + b;
                String ba = b + a;
                return ba.compareTo(ab); // 내림차순 정렬
            }
        });
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+ " ");
        }

        // 배열의 첫 번째 원소가 0인 경우 모든 원소가 0임을 의미
        if (nums[0].equals("0")) {
            return "0";
        }

        // 정렬된 문자열을 하나로 합치기
        StringBuilder answer = new StringBuilder();
        for (String num : nums) {
            answer.append(num);
        }

        return answer.toString();
    }
}
