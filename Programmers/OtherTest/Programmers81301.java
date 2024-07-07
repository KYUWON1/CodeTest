package Programmers.OtherTest;

public class Programmers81301 {

    public int solution(String s) {
        String[] str = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        String[] num = {"0","1","2","3","4","5","6","7","8","9"};

        //s에서 str에 일치하는 문자열이 있다면, 해당 숫자로 변경
        for (int i = 0; i < str.length; i++) {
            s = s.replace(str[i],num[i]);
        }

        //마지막에 int로 변환해서 전달
        return Integer.parseInt(s);
    }
}
