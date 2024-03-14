package JavaPractice.Practice2;

import java.util.Arrays;
import java.util.HashMap;

public class Practice1 {
    public static void solution(String s) {
        HashMap<Character,Integer> romeMap = new HashMap<>();
        romeMap.put('I',1);
        romeMap.put('V',5);
        romeMap.put('X',10);
        romeMap.put('L',50);
        romeMap.put('C',100);
        romeMap.put('D',500);
        romeMap.put('M',1000);
        int sum = 0;
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length-1; i++) {
            if(romeMap.get(arr[i]) < romeMap.get(arr[i+1])){
                sum -= romeMap.get(arr[i]);
            }else{
                sum += romeMap.get(arr[i]);
            }
        }
        sum += romeMap.get(arr[arr.length-1]);
        System.out.println(sum);
    }

    public static void main(String[] args) {
        // Test code
        solution("III");
        solution("IV");
        solution("VI");
        solution("XIII");
        solution("XXVI");
        solution("MCMXCIV");
    }
}
