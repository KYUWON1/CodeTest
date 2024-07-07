package Programmers.WeekFree2;

import java.util.HashMap;

/*
낱말 마추기 게임을 구현해라
입력으로 "가가다다" 이런 형식이 들어오면 대답은 "바나나바나나사과사과"
"가나다라" 이면 "사과바나나고래상어" 같이 같은 낱말엔 같은 단어로 같은 패턴으로 대답해야 True이고
"가나가" 인데, "바나나 사과 초콜렛" 이면 초콜렛이 아니라 바나나 가 나와야함으로 false이다
 */

public class Programmers11459 {
    public boolean solution(String p, String s) {

        HashMap<String,String> map = new HashMap<>();
        String[] str1 = p.split(""); // 낱말
        String[] str2 = s.split(" "); // 단어
        //길이가 다르면 false
        if(str1.length != str2.length || p.length() != 4){
            return false;
        }

        //맵에 낱말이 이미 있다면, 해당 낱말에 단어를 가져와서 비교
        //맵에 낱말이 없다면, 해당 낱말과 단어 put
        for (int i = 0; i < str1.length; i++) {
            //이미 해당 낱말이 있고, 해당 낱말의 단어와 현재의 단어가 다를때
            if(map.containsKey(str1[i]) && !map.get(str1[i]).equals(str2[i])){
                    return false;
            }
            // 해당 낱말이 없을때, 그러나 해당 단어가 이미 존재할때,
            else if(!map.containsKey(str1[i]) && map.containsValue(str2[i])){
                    return false;
            }else{
                map.put(str1[i],str2[i]);
            }
        }

        return true;
    }
}
