package Programmers.Week7;
/*
    당신은 이미 한번 개표를 마쳐서 과반수 성립한다는 점을 알고 있는 투표를 검수하게 되었다

    공정함을 위해서 당신에게는 누가 투표했는지 승리했는지 알려지지않았고, 모든 투표용지에는 후보의
    기호 숫자만이 기재되어 있다.

    예를 들어 투표 결과가 votes = {1,4,2,2,2,3,2,2,1} 로 주어졌을 떄,
    과반수 투표 결과는 2가 된다 .
 */
import java.util.HashMap;
import java.util.Map;

public class Programmers12685 {
    public int solution(int[] votes) {
        int len = votes.length;
        int limit = len / 2;

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int vote : votes) {
            countMap.put(vote, countMap.getOrDefault(vote, 0) + 1);
            if (countMap.get(vote) >= limit) {
                return vote;
            }
        }

        return -1; // 과반수를 넘는 투표자가 없는 경우 -1 반환 (이 부분은 상황에 따라 조정 가능)
    }
}

