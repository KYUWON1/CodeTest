package Programmers;
/*
포화 이진 트리는 ,리프 노드를 제외한 모든 노드가 2개의 자식노드를 가지는 트리이다
높이가 n인 포화이진 트리의 전체 노드 수를 구하려고한다.
높이 n 이 주어질때, 트리의 모든 노드 갯수를 출력하는 프로그램을 구현하세요
/결과를 1.000.000.007로 나눈 값을 반환


모듈로 사용과 버퍼오버플로우, 연산을 좀더 고민해보자 , 2^(n+1) - 1 해당 방법 고려
 */
public class Programmers11438 {
    //포화이진 트리의 노드수는 2^(n+1) - 1 이다. 0층 1개, 1층 3개 이런식으로
    public int solution(int n) {
        if(n == 1){
            return 1;
        }
        //3이 들어옴 1+ 2+ 4
        long answer = 0;
        for (int i = 0; i < n; i++) {
            answer += ((long)Math.pow(2,i) % 1000000007) %  1000000007;
        }
        return (int)answer;
    }
}
