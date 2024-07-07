package Programmers.Week6;
/*
    유미는 마트에서 요리 재료를 구매하려고한다
    요리재료는 ingredients 배열에 정리해 두었다

    유미는 여기서부터 저기까지 다 주세요 라고 외치고 싶어졌다

    마트에 진열된 품목은 items[i] 로 주어지며, 유미는 필요한 요리 재료가
    모두 포함되는 가장 최소한이 구간을 선택하려고한다. 이때 유미가 구매할 구간의 길이를 출력해라 
 */
import java.util.HashMap;
import java.util.Map;

public class Programmers12606 {
    public int solution(String[] ingredients, String[] items) {
        int answer = Integer.MAX_VALUE;

        Map<String,Integer> need = new HashMap<>();
        for (String ingredient : ingredients) {
            need.put(ingredient, 1); // 맵에 초기화
        }

        int totalSize = need.size();
        int cnt = 0 ;
        Map<String,Integer> have = new HashMap<>();

        int left = 0;
        int right = 0;

        while(right < items.length){
            String rightItem = items[right];
            //윈도우 확장부분
            if(need.containsKey(rightItem)){
                have.put(rightItem, have.getOrDefault(rightItem,0)+1);
                if(have.get(rightItem).intValue() == need.get(rightItem).intValue()){
                    cnt++;
                }
            }

            //윈도우 축소 부분
            while(cnt == totalSize && left <= right){
                answer  = Math.min(answer, right-left + 1);
                String leftItem = items[left];
                if(need.containsKey(leftItem)){
                    have.put(leftItem,have.get(leftItem)-1);
                    if(have.get(leftItem).intValue() < need.get(leftItem).intValue()){
                        cnt--;
                    }
                }
                left++;
            }
            right++;
        }

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
}
