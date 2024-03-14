package JavaPractice.Practice1;

public class Practice5 {
    public static int solution(int[] height) {
        int maxWidth = 0;
        for (int i = 0; i < height.length-1; i++) {
            for (int j = i+1; j < height.length; j++) {
                int y = Math.min(height[i], height[j]);
                if(calWidth(j-i,y) > maxWidth){
                    maxWidth = calWidth(j-i,y);
                }
            }
        }
        return maxWidth;
    }

    public static int calWidth(int x, int y){
        //System.out.println(x * y);
        return x * y;
    }

    public static void main(String[] args) {
        // Test code
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(solution(height));

        height = new int[]{5, 3, 9, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2};
        System.out.println(solution(height));

    }
}
