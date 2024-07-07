package Programmers.Week7;
/*
    유사 피보나치 수열을 찾아라
    예를 들어 14152944 가 들어오면
    해당 배열을 14 15 29 44 의 피보나치 수열로 볼 수 있다

    단 유사 피보나치 수열로 나눌 수 없는 경우 {} 를 출력하고,
    숫자를 나눌때, 숫자 앞에 앞선 0이 있어서는 안된다. 03, 005 등으로 나눌 수 없다
    각 숫자는 2^31 -1 을 넘지 않아야 한다 .
 */
import java.util.ArrayList;
import java.util.List;

public class Programmers12689 {
    public static int[] solution(String nums) {
        List<String> result = findFibonacci(nums);
        StringBuilder sb = new StringBuilder();
        for(String s : result){
            sb.append(s);
        }
        String[] str = sb.toString().split(" ");
        int[] arr = new int[str.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        return arr;
    }

    public static List<String> findFibonacci(String input){
        List<String> result = new ArrayList<>();
        backtrack(input,new ArrayList<>(), result, 0);
        return result;
    }

    public static void backtrack(String input, List<String> curr,List<String> result, int start){
        if(start == input.length()){
            if(isFibonacciSeq(curr)){
                result.add(String.join(" ",curr));
            }
            return;
        }

        for (int i = start+1; i <= input.length(); i++) {
            String part = input.substring(start,i);
            curr.add(part);
            backtrack(input,curr,result,i);
            curr.remove(curr.size() - 1);
        }
    }

    public static boolean isFibonacciSeq(List<String> seq){
        if(seq.size() < 3){
            return false;
        }

        List<Integer> numbers = new ArrayList<>();
        try {
            for (String s : seq) {
                numbers.add(Integer.parseInt(s));
            }
        } catch (NumberFormatException e) {
            return false; // 숫자가 int 범위를 초과할 경우 유효하지 않은 시퀀스로 간주
        }

        for (int i = 2; i < numbers.size(); i++) {
            if(numbers.get(i) != numbers.get(i-1) + numbers.get(i-2)){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String input = "14152944";
        List<String> result = findFibonacci(input);
        StringBuilder sb = new StringBuilder();
        for(String s : result){
            sb.append(s);
        }
        String[] str = sb.toString().split(" ");
        int[] arr = new int[str.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

    }
}
