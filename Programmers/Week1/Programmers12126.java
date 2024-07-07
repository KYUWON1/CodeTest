package Programmers.Week1;
/*
    P12126 그림 참조
 */
// 문제는 맞았으나, 성능에서 안좋음
public class Programmers12126 {
    //2의 제곱수인 nxn의 행렬이 주어진다
    //ㄷ 자로 순서대로 값을 채우는 재귀 코드 작성

    //카운트는 전역변수로 사용
    int count = 1;

    public int solution(int n, int i, int j) {
        int[][] result = new int[n][n];
        // 배열, 좌측 상단의 좌표, 사이즈, 증가시킬 count 넘김
        fillMat(result,result[0].length-1,0,n,i,j);

        return result[i][j];
    }

    public void fillMat(int[][] arr,int startX,int startY,int size,int i,int j){
        if(arr[i][j] != 0 ){
            return;
        }
        //사이즈가 2일때 채우기 시작 ㄷ 자 모양으로, count 증가
        if(size == 2){
            arr[startY][startX] =count++;
            arr[startY][startX-1] =count++;
            arr[startY+1][startX-1] =count++;
            arr[startY+1][startX] =count++;
            return;
        }

        //size를 감소시키고, 4개로 분할한뒤, 좌표값 설정
        int newSize = size / 2;
        //왼쪽위
        fillMat(arr,startX,startY,newSize,i,j);
        //오른쪽위
        fillMat(arr,startX-newSize,startY,newSize,i,j);
        //오른쪽 아래
        fillMat(arr,startX-newSize,startY+newSize,newSize,i,j);
        //왼쪽 아래
        fillMat(arr,startX,startY+newSize,newSize,i,j);
    }
}
