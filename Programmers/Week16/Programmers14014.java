package Programmers.Week16;

/*
    수영장 건설 전문가로써, 구조물의 높이지도 를 보고 수영장을 채우는데 필요한 물의
    양을 구하는 프로그램을 만들고자 한다. 2차원 정수 배열 heights 에는 숫자가 기록되어
    있으며, 각 위치에는 정육면체 상자가 해당 숫자만큼 쌓여있다
    부피를 1이라고 할때, 해당 구조물에 물을 가둘수 있는 공간의 부피를 구하시오.
    
    >> 가장자리의 최소 높이를 구하고, 테두리를 제외한 값에서 최소높이를 뺀값을 모두 더한다 x
    >> 내부에 구조에서도 물이 고일수있음 pq와 BFS 를 통해서 해결
 */

import java.util.*;

public class Programmers14014 {
    public int solution(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        if (rows <= 2 || cols <= 2) return 0;

        boolean[][] visited = new boolean[rows][cols];
        // 높이가 낮은 cell 기준으로 탐색하도록
        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> a.height - b.height);

        // 테두리의 셀을 모두 PQ에 넣기
        //
        for (int i = 0; i < rows; i++) {
            pq.offer(new Cell(i, 0, heights[i][0]));
            pq.offer(new Cell(i, cols - 1, heights[i][cols - 1]));
            visited[i][0] = true;
            visited[i][cols - 1] = true;
        }
        for (int j = 1; j < cols - 1; j++) {
            pq.offer(new Cell(0, j, heights[0][j]));
            pq.offer(new Cell(rows - 1, j, heights[rows - 1][j]));
            visited[0][j] = true;
            visited[rows - 1][j] = true;
        }

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int answer = 0;

        while (!pq.isEmpty()) {
            Cell cell = pq.poll();

            for (int[] direction : directions) {
                int x = cell.row + direction[0];
                int y = cell.col + direction[1];

                if (x > 0 && x < rows - 1 && y > 0 && y < cols - 1 && !visited[x][y]) {
                    visited[x][y] = true;
                    answer += Math.max(0, cell.height - heights[x][y]);
                    pq.offer(new Cell(x, y, Math.max(cell.height, heights[x][y])));
                }
            }
        }

        return answer;
    }

    class Cell {
        int row;
        int col;
        int height;

        Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }
}
