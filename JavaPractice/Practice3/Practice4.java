package JavaPractice.Practice3;

import java.util.ArrayList;

public class Practice4 {
    public static ArrayList<Integer> solution(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        int rowEnd = matrix.length-1; // 행 인덱스 int[1][2] 행 열
        int colEnd = matrix[0].length-1; // 열 인덱스의 마지막 index

        int rowStart = 0,colStart = 0; // 행 열
        while(rowStart <= rowEnd && colStart <= colEnd){
            for (int i = colStart; i <= colEnd; i++) {
                result.add(matrix[rowStart][i]);
            }
            rowStart++;

            for (int i = rowStart; i <= rowEnd; i++) {
                result.add(matrix[i][colEnd]);
            }
            colEnd--;

            if(rowStart <= rowEnd){
                for (int i = colEnd; i >= colStart ; i--) {
                    result.add(matrix[rowEnd][i]);
                }
            }
            rowEnd --;

            if(colStart <= colEnd){
                for (int i = rowEnd; i >= rowStart; i--) {
                    result.add(matrix[i][colStart]);
                }
            }
            colStart++;
        }

        return result;
    }
    
    public static void main(String[] args) {
        // Test code
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println((solution(matrix)));

        matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10 ,11 ,12}};
        System.out.println((solution(matrix)));
    }
}
