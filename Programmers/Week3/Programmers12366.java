package Programmers.Week3;
/*
    철수와 영희는 눈을 가리고 잡기 놀이를 하기로 했다
    철수는 도망치는 역할을 받았으며, (x1,y1)좌표에서 시작한다

    매 1초 철수는 동서남북 중 한군데를 임의로 선택하여 이동한다

    영희는 x2,y2 좌표에서 출발한다.

    매 1초 영희는 북서/북동/남서/남동 (대각선) 중 한군대를 임의로 선택하여 이동한다

    모든 경우 중에서 영희가 철수를 가장 빨리 잡는 경우 몇 초의 시간이 걸리는지 출력하시오
 */

public class Programmers12366 {
    //중요한 점은 눈을 가리고이고, 서로 최단거리로 이동했을때를 구하면 된다.

    public int solution(int x1, int y1, int x2, int y2) {
        int answer = 0;
        while(true){
            if(y1 > y2){ // 더 위에
                y1--;
                if(x1 > x2){ // 더 오른쪽에 있을때
                    x2++;
                    y2++;
                }else{
                    x2--;
                    y2++;
                }
            }else if(y1 < y2){// 더 아래에 있을때
                y1++;
                if(x1 > x2){ // 더 오른쪽에 있을때
                    x2++;
                    y2--;
                }else{
                    x2--;
                    y2--;
                }
            }else {
                if(x1 > x2){ // 더 오른쪽에 있을때
                    x1--;
                    x2++;
                    y2++;
                }else{
                    x1++;
                    x2--;
                    y2++;
                }
            }
            answer++;
            if(x1 == x2 &&(y1 == y2+1 || y1 == y2-1)){
                answer++;
                break;
            }else if(y1 == y2 &&(x1 == x2+1 || x1 == x2-1)){
                answer++;
                break;
            }
        }
        return answer;
    }
}
