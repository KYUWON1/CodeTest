package JavaPractice.Practice2;

public class Practice2 {

    public static String solution(int num){
        String result = "";
        //while문으로 더 빠르게 작성 가능
        String[] str = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        int[] numArr = {1,4,5,9,10,40,50,90,100,400,500,900,1000};

        int idx = numArr.length -1; //가장 큰값부터 시작
        while(num >= 0){
            int sub = numArr[idx];
            if(num - sub >= 0){ // 가장 큰값을 뺄수있으면 해당 넘에서 빼고, idx값 string에 추가
                num -= sub;
                result += str[idx];
            }else{
                idx -= 1;
                if(num ==0){
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(solution(3));
        System.out.println(solution(4));
        System.out.println(solution(6));
        System.out.println(solution(13));
        System.out.println(solution(26));
        System.out.println(solution(1994));
    }
}
