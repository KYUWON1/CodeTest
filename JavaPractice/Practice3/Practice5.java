package JavaPractice.Practice3;

public class Practice5 {
    public static int solution(int[] height) {
        // 높이의 최대값을 저장할 변수
        int rMax = 0, lMax = 0;
        int right = height.length-1, left = 0; // 오른쪽과 왼쪽의 인덱스
        int result = 0;
        while(left < right){
            if(height[left] < height[right]){
                if(height[left] >= lMax){
                    lMax = height[left];
                }else { //작다면
                    result += lMax - height[left];
                }
                left++;
            } else {
                if(height[right] >= rMax){
                    rMax = height[right];
                }else { //작다면
                    result += rMax - height[right];
                }
                right--;
            }
        }

        return result;
    }
    
    public static void main(String[] args) {
        // Test code
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(solution(height));

        height = new int[]{4, 2, 0, 3, 2, 5};
        System.out.println(solution(height));
    }
}
