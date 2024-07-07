package Programmers.Week13;

/*
    기존 서버의 코드를 효율적으로 바꾸고자 함수를 구현하려고한다. 문자열을 정수로 반환하는 함수이다
    - 문자열의 앞쪽에 붙어있는 공백은 무시한다
    - 숫자보다 앞에 -나 + 가 나올 경우, 이것을 부호로 한다. 부호가 없으면 +로 가정한다
    - 숫자가 시작되면, 연속으로 붙어있는 모든 숫자를 읽어 정수로 변환한다. 그 이후 문자열의 나머지 부분은 무시한다
    - 정수가 범위 -2^31 ~ 2^31-1 을 벗어나면 정수 범위 내로 클리핑한다.
 */

public class Programmers13686 {
    public int solution(String s) {
        if (s == null || s.trim().isEmpty()) {
            return 0;
        }

        s = s.trim();  // 앞뒤 공백 제거
        int sign = 1;  // 부호 (+ 기본)
        int index = 0;

        // 첫 문자가 부호인지 확인
        if (s.charAt(0) == '-') {
            sign = -1;
            index++;
        } else if (s.charAt(0) == '+') {
            index++;
        }

        long result = 0;  // long 타입으로 오버플로우 검사

        //최초의 숫자가 나올때까지 루프순환
        while(index < s.length()){
            if(Character.isDigit(s.charAt(index))){
                break;
            }
            index++;
        }

        // 각각 자리수에 숫자 삽입
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            result = result * 10 + (s.charAt(index) - '0');
            index++;

            // 범위 클리핑
            if (sign == 1 && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (sign == -1 && -result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }

        result *= sign;

        // 최종 범위 확인
        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        return (int) result;
    }

    public static void main(String[] args) {
        Programmers13686 p = new Programmers13686();
        System.out.println(p.solution("   -42")); // -42
        System.out.println(p.solution("4193 with words")); // 4193
        System.out.println(p.solution("words and 987")); // 0
        System.out.println(p.solution("-91283472332")); // -2147483648 (clipped to Integer.MIN_VALUE)
    }
}
