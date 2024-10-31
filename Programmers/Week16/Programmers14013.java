package Programmers.Week16;

import java.util.PriorityQueue;

/*
    적당한 난이도의 등산코스를 짜는 프로그램을 만드려고한다.
    2차원 배열 height에는 각 위치의 높이가 기록되어있다
    출발점은 항상 좌상단(0,0)이고, 도착점은 우하단이다.
    등산코스는 상하좌우중 한 칸씩 이동할수있고, 한 칸 이동할때, 필요한 노력치는 높이의 차이이다.
    출발점부터 도착지로 가는 코스를 짤 때, 필요한 노력치의 최대값이 최소가 되도록 하려고한다
    이떄 노력치의 값을 구하시오.
    
    >> 다익스트라 알거리즘
 */
public class Programmers14013 {
    public int solution(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        int[][] efforts = new int[rows][cols];
        boolean[][] visited = new boolean[rows][cols];

        // 초기화
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                efforts[i][j] = Integer.MAX_VALUE;
            }
        }
        efforts[0][0] = 0;

        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> a.effort - b.effort);
        pq.add(new Cell(0, 0, 0));

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!pq.isEmpty()) {
            Cell cell = pq.poll();
            int row = cell.row;
            int col = cell.col;

            if (visited[row][col]) continue;
            visited[row][col] = true;

            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                    int newEffort = Math.max(cell.effort, Math.abs(heights[newRow][newCol] - heights[row][col]));

                    if (newEffort < efforts[newRow][newCol]) {
                        efforts[newRow][newCol] = newEffort;
                        pq.offer(new Cell(newRow, newCol, newEffort));
                    }
                }
            }
        }

        return efforts[rows - 1][cols - 1];
    }

    class Cell {
        int row;
        int col;
        int effort;

        Cell(int row, int col, int effort) {
            this.row = row;
            this.col = col;
            this.effort = effort;
        }
    }
}
