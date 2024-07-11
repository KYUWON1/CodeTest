package Programmers.Week14;

import java.util.LinkedList;
import java.util.Queue;

/*
    미로 게임을 하려고한다. 시작점에서 도착지까지 도착하면되고, 밤에는 몬스터가 배치되어 위협을 가한다

    -미로는 2차원 정수 배열 maze 로 주어지며, 이 미로의 각 위치는 다음 중 한가지로 주어진다
    - 0 이동할 수 있는 일반 길
    - 1 이동할 수 없는 벽
    - 2 밤에 나타나 주변을 위협하는 몬스터

    플레이어는 항상 좌측상단 0.0 에서 시작하고, 도착지는 우측 하단이다
    플레이어는 한 턴에 상, 하, 좌, 우, 정지 중 하나를 선택하여 이동할수있다
    게임이 시작시에는 "낮" 상태로 시작하며, 5턴마다 낮과 밤이 바뀐다.
    미로에 2로 표기되어있는 몬스터는 밤에만 등장하며, 몬스터가 등장한 지역의 상 하 좌 우, 등장지역 총 5칸에 위협을 가한다
    이때, 도착점에 도착하는 최소 턴 수를 구하고, 탈출할수 없는 경우 -1을 반환하시오

 */
public class Programmers13802 {
    // 이동 방식
    final static int[] dx = {-1, 1, 0, 0, 0}; // 상, 하, 좌, 우 ,정지
    final static int[] dy = {0, 0, -1, 1, 0};

    class Point {
        int x, y, turn, phase;

        Point(int x, int y, int turn, int phase) {
            this.x = x;
            this.y = y;
            this.turn = turn;
            this.phase = phase; // 0은 낮, 1은 밤
        }
    }

    public int solution(int[][] maze) {
        // 미로의 도착지점
        int n = maze.length;
        int m = maze[0].length;

        Queue<Point> que = new LinkedList<>();
        boolean[][][] visited = new boolean[n][m][2]; // 방문 체크

        que.add(new Point(0, 0, 0, 0));
        visited[0][0][0] = true;

        while (!que.isEmpty()) {
            Point curr = que.poll();
            // 도착지점 도착시
            if (curr.x == n - 1 && curr.y == m - 1) {
                return curr.turn-1;
            }

            int nextPhase = (curr.turn + 1) / 5 % 2; // 다음 턴의 낮/밤
            // 이동 로직
            for (int i = 0; i < 5; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny][nextPhase] && maze[nx][ny] != 1) {
                    // 밤인데, 안전하거나, 아침일때 이동
                    if (curr.phase == 0 || (curr.phase == 1 && isSafe(maze, nx, ny, n, m))) {
                        que.offer(new Point(nx, ny, curr.turn + 1, nextPhase));
                        visited[nx][ny][nextPhase] = true;
                    } else if((curr.phase == 1 && !isSafe(maze, nx, ny, n, m))){
                        que.offer(new Point(curr.x, curr.y, curr.turn + 1, nextPhase));
                    }
                }
            }
        }
        // 도착 불가능
        return -1;
    }

    // 몬스터 주변이 안전한지 체크
    private static boolean isSafe(int[][] maze, int x, int y, int n, int m) {
        if (maze[x][y] == 2)
            return false; // 몬스터 위치
        for (int i = 0; i < 5; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && maze[nx][ny] == 2)
                return false;
        }
        return true;
    }

}
