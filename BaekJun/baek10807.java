package BaekJun;
/*
    총 N개의 정수가 주어졌을 때, 정수 v가 몇 개인지 구하는 프로그램을 작성하시오.

    입력
    첫째 줄에 정수의 개수 N(1 ≤ N ≤ 100)이 주어진다. 둘째 줄에는 정수가 공백으로 구분되어져있다. 셋째 줄에는 찾으려고 하는 정수 v가 주어진다. 입력으로 주어지는 정수와 v는 -100보다 크거나 같으며, 100보다 작거나 같다.

    출력
    첫째 줄에 입력으로 주어진 N개의 정수 중에 v가 몇 개인지 출력한다.

    예제 입력 1
    11
    1 4 1 2 4 2 4 2 3 4 4
    2
    예제 출력 1
    3


    nextInt() ! 공백을 기준으로 숫자를 하나씩 읽음 해당 함수를 사용해도될듯!
 */


import java.util.Scanner;

public class baek10807 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 정수의 갯수
        int size = Integer.parseInt(sc.nextLine());
        int[] arr1 = new int[size]; // size개수만큼의 정수배열 생성
        /*
            굳이 문자열로 split 하지않아도, nextint()로 해결할 수 있음
         */
        String[] arr2 = sc.nextLine().split(" "); // 공백으로 정수 구분
        // 정수배열에 한개씩 대입
        for (int i = 0; i < arr2.length; i++) {
            arr1[i] = Integer.parseInt(arr2[i]);
        }
        // 타겟 정수
        int tar = Integer.parseInt(sc.nextLine());
        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i] == tar){
                count++;
            }
        }
        System.out.println(count);
    }
}
