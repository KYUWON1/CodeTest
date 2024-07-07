package Programmers.Week3;
/*
    게임 '제로링'은 게임을 클리어하기위해, 반드시 처리해야하는 보스와 그렇지 않는 보스가 있다
    선택형 보스를 클리어해서 강화하면 더 빨리 깰 수도 있다

    제로링의 규칙은
    - 캐릭터의 초기 공격력은 1이며 물리치면 reward만큼 강화된다
    - 보스의 체력은 health 배열에 주어진다
    - 공격시 보스의 체력은 공격력만큼 감소하며 0이하가 되면 처리한다
    - 선택형 보스인경우 1 필수 보수인 경우 0으로 주어진다
    - 보스는 총 N개 있으며, 반드시 순서대로 처리해야한다
    - 공격횟수 1회당 1초의 시간이 요소되고 다른 소요시간은 없다

    최단 클리어 시간으로 클리어시, 시간을 구하시오
 */

public class Programmers12367 {
    public int solution(int[] reward, int[] health, int[] optional) {
        // 리워드가 있는녀석만 계산 하면 되는데
        int time = 0;
        int damage = 1;
        int[] resultTime = new int[health.length];

        for (int i = 0; i < health.length; i++) {
            //필수 보스 일때
            if(optional[i] == 0){
                while(health[i] >=0){
                    health[i] -= damage;
                    time++;
                }
                damage += reward[i];
                resultTime[i] = time;
            }else { // 선택 보스 일때
                while(health[i] >=0){
                    health[i] -= damage;
                    time++;
                }
                damage += reward[i];
            }

        }



        return time;
    }
}
