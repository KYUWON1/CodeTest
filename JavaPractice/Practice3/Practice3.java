package JavaPractice.Practice3;

import com.sun.org.apache.xml.internal.security.algorithms.implementations.IntegrityHmac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Practice3 {
    public static void solution(int[] arr, int k, int x) { // k는 숫자수, x는 기준값

        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int diff = Math.abs(x - arr[i]); //차이 계산

            ArrayList<Integer> curr =map.get(diff);
            if(curr == null) {
                map.put(diff,new ArrayList<>(Arrays.asList(arr[i])));
            } else {
                int idx = curr.size();
                for (int j = 0; j < curr.size(); j++) {
                    if(curr.get(j) > arr[i]) {
                        idx = j;
                        break;
                    }
                }
                curr.add(idx,arr[i]);
            }
        }

        ArrayList<Integer> result =new ArrayList<>();
        int cnt = 0;
        while(map.size() > 0 ){
            int minDiff  =map.keySet().stream().min((a,b) -> a - b).get();
            ArrayList<Integer> cur = map.get(minDiff);
            map.remove(minDiff);
            while(cur.size() > 0 ){
                result.add(cur.get(0));
                cur.remove(0);
                cnt++;

                if(cnt == k){
                    break;
                }
            }
            if(cnt == k){
                break;
            }
        }
        Collections.sort(result);
        System.out.println(result);
    }

    public static void main(String[] args) {
        // Test code
        int[] arr = {1, 2, 3, 4, 5};
        solution(arr, 4, 3);

        arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        solution(arr, 5, 5);

        arr = new int[]{2, 4};
        solution(arr, 1, 3);

        arr = new int[]{2, 4};
        solution(arr, 3, 3);
    }
}
