package Programmers;

public class Programmers13283 {
    public String solution(int[] arr) {
        String answer = "";

        // 배열길이 체크 해서 계산해보려했지만, 필요없음 if문이있기 때문에 자식 여부 검사 가능
        for (int i = 1; i < arr.length/2; i++) {
            int left = i * 2;
            int right = i * 2 + 1;
            if(left < arr.length){
                if(arr[i] >= arr[left]){
                    return "NO";
                }
            }
            if(right < arr.length){
                if(arr[i] >= arr[right]){
                    return "NO";
                }
            }
        }
        return "YES";
    }
}
