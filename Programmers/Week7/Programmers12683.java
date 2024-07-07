package Programmers.Week7;
/*
    흰색 0 과 검은색 1 로만 이루어진 이진영상은 다양한 방식으로 압축할 수 있다
    여러 압축 방법중에 당신은 쿼드트리 방식으로 압축하고자한다

    쿼드트리 방식이란
    - 압축하려는 영상 전체가 0이면 0 1면 1로 압축한다
    - 영상전체가 같은 값이 아니라면, 영상을 동일한 크기로 4분할하여 부분 영상별로 압축한다
    - 각 부분영상을 압축하는 방법은 전체 영상을 압축하는 방법과 같다
    - 각각의 압축 결과를 (좌상단 우상단 좌하단 우하단) 과 같이 출력한다 문자사이의 공백은 쓰지 않는다

 */
public class Programmers12683 {
    public String solution(int[][] img) {
        return compress(img,0,0,img.length);
    }

    public String compress(int[][] img, int row, int col, int size){
        if(isUniform(img,row,col,size)){
            return String.valueOf(img[row][col]);
        }

        int newSize = size / 2;
        StringBuilder result = new StringBuilder();
        result.append("(");

        //4부분으로 분할 호출
        result.append(compress(img,row,col,newSize)); // 좌상단
        result.append(compress(img,row,col+newSize,newSize)); // 우상단
        result.append(compress(img,row+newSize,col,newSize)); // 좌하단
        result.append(compress(img,row+newSize,col+newSize,newSize)); // 우하단

        // 추가
        result.append(")");
        return result.toString();
    }

    // 0또는 1로 이루어졌는지 확인
    public boolean isUniform(int[][] img,int row, int col, int size){
        int value = img[row][col];
        for (int i = row; i < row+size; i++) {
            for (int j = col; j < col+size; j++) {
                if(img[i][j] != value){
                    return false;
                }
            }
        }
        return true;
    }
}
