package JavaPractice.Practice1;

public class Practice1 {
    public static void solution(int num) {
        int reverseNum = 0;
        boolean isMinus = false;
        if(num < 0){
            num *= -1;
            isMinus = true;
        }

        while(num > 0) {
            int n  = num % 10;
            num /= 10;
            reverseNum = reverseNum * 10 + n; // 처음엔 reversenum  은 0
        }
        System.out.println(isMinus ? reverseNum * -1 : reverseNum);
    }

    public static void main(String[] args) {
        // Test code
        solution(12345);
        solution(-12345);
        solution(100);
        solution(0);
    }
}
