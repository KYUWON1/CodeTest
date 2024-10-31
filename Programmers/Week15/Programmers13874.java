package Programmers.Week15;

import java.util.Arrays;

/*
    정수로 이루어진 배열 numsDivide와 numsDivided가 주어져있다
    당신은 numsDivide에서 원하는 만큼 원소를 제거할수있다
    numsDivide에서 최소한의 원소를 제거한 후에, numsDivide에 남아
    있는 숫자중에 가장 작은수로, numsDivided에 있는 모든 정수가 나누어
    떨어지게 하려고한다. 이떄, 몇개의 원소를 제거해야 하는지 출력하시오

    만약 불가할경우, -1 을 반환하시오
 */
public class Programmers13874 {
    public int solution(int[] numsDivide, int[] numsDivided) {
        int answer = 0;
        // 오름차순으로 정렬
        Arrays.sort(numsDivide);
        for (int i = 0; i < numsDivide.length; i++) {
            int divNum = numsDivide[i];
            boolean isDiv = true;
            for (int j = 0; j < numsDivided.length; j++) {
                if(numsDivided[j] % divNum != 0){
                    isDiv = false;
                    answer++;
                    break;
                }
            }
            if(isDiv){
                return answer;
            }
        }
        return -1;
    }
}
