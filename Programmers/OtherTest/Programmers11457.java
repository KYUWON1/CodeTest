package Programmers.OtherTest;

public class Programmers11457 {
    public boolean solution(int num) {
        //num은 모래성의 무게, 가져갈수있는 무게는 1, 2, 3 이길려면, 마지막에 1KG가 남도록 흥민이가 가져야함
        // 흥민이한테 모래의 무게가 4KG가 되서는 안됨
        boolean answer = true;
        boolean mytrun = true;
        while(num > 1){ // 1Kg보다 클때까지
           if(mytrun){ // 내턴이라면
               if(num == 4 || num == 3 || num == 2){
                   answer = true;
                   break;
               }
               mytrun = false;
           }else{ //내턴이 아니라면
               if(num == 4 || num == 3 || num == 2){
                   answer = false;
                   break;
               }
               mytrun = true;
           }
           num -= 3;
        }

        return answer;
    }
}
