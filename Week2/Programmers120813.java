package Week2;

public class Programmers120813 {

    public static int[] solution(int n) {
        int size = 0;
        if(n%2 == 0){
            size = n / 2;
        }else{
            size = n / 2 +1;
        }
        int[] answer = new int[size];
        int idx= 0;
        for(int i =1;i <= n;i++){
            if((i % 2) != 0){
                answer[idx++] = i;
            }
        }
        return answer;
    }


    public static void main(String[]args){
        int[] arr = solution(5);
    }
}
