package Programmers;
/*
정수값 n 이 주어졌을때, 이 값의 제곱근을 출력하는 프로그램을 구현하세요.
ex) 4가 주어지면 2, 6은 무리수임으로 0
 */
public class Programmers12116 {
    public int solution(int n) {
        double x = Math.sqrt(n); // 6인경우 2.xxx 가 return됨
        int y = (int)x; // 해당 값의 소수점을 제거한 int로 값을 복제하고
        if(x != y){ // 만약 소수점이 있어서 x 와 y가 다르다면 무리수임으로 0을 return
            return 0;
        }
        return (int)Math.sqrt(n);
    }

}
