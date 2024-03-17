package JavaPractice.Practice3;

public class Practice1 {
    public static void solution(int[] nums) {
        int idx = 0;
        for(int num: nums){ //오름 차순 정렬이기 때문에 이전 값보다 작을때만 배열에 하나씩 추가
            if(idx == 0 || num > nums[idx-1]){
                nums[idx++] = num;
            }
        }
        for (int i = 0; i < idx; i++) {
            System.out.print(nums[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test code
        solution(new int[] {1, 1, 2});
        solution(new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
    }
}
