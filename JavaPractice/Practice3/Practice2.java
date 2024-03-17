package JavaPractice.Practice3;

import java.util.ArrayList;

public class Practice2 {
    public static ArrayList<Integer> solution(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) -1; // 해당 값의 인덱스로 접근해서 인덱스 값으로 변환
            
            if(nums[idx] < 0) { // 이미 인덱스가 음수였다면 arr에 추가, 2번밖에 안나오기때문에 중복생각 안해도됨
                arr.add(Math.abs(idx + 1)); // 인덱스를 값으로 변환
            }

            nums[idx] = -nums[idx]; // 음수로 변환
        }

        return arr;
    }

    public static void main(String[] args) {
        // Test code
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(solution(nums));

        nums = new int[]{1, 1, 2};
        System.out.println(solution(nums));

        nums = new int[]{1, 3, 1, 3, 5, 5};
        System.out.println(solution(nums));
    }
}
