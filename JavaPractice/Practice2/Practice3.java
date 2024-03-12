package JavaPractice.Practice2;

import java.util.ArrayList;


public class Practice3 {
    public static String solution(String input, String cmd) {
        StringBuffer sb =new StringBuffer(input);
        ArrayList<String> cmdArr = new ArrayList<>();

        for(String s: cmd.split(" ")){
            cmdArr.add(s);
        }

        int idx = sb.length(); //문자열의 맨뒤
        int cmdIdx = 0;
        
        while(cmdIdx != cmdArr.size()){
            String cur = cmdArr.get(cmdIdx);

            if(cur.equals("L")){
                idx = Math.max(0,idx-1);
            }else if(cur.equals("D")){
                idx = Math.min(sb.length(),idx+1);
            }else if(cur.equals("B")){
                if(idx == 0){
                    cmdIdx++;
                    continue;
                }
                sb.delete(idx -1,idx);
                idx = Math.max(0,idx-1); //커서 왼쪽으로 따라옴
            }else if(cur.equals("P")){
                String s = cmdArr.get(++cmdIdx);
                sb.insert(idx,s); //위치에 삽입하고 커서 오른쪽 한칸
                idx++;
            }
            cmdIdx++;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        // test code
        System.out.println(solution("aba", "L B"));
        System.out.println(solution("abcd", "P x L P y"));
        System.out.println(solution("abc", "L L L P x L B P y"));
        System.out.println(solution("a", "B B L L D D P a P b P c"));
    }
}
