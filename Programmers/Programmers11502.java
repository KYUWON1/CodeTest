package Programmers;

public class Programmers11502 {
    public static int solution(String S) {
        int answer = 0;
        int num = Integer.parseInt(S,2); // 이진 문자열을 10진으로 반환
        while(num != 0){
            if(num % 2 == 0 ){
                num /= 2;
            }else{
                num -= 1;
            }
            answer++;
        }
        return answer;
    }

    public static void main(String[] args){
        System.out.println(solution("1101"));
    }
}
