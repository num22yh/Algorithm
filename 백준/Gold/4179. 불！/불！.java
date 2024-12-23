import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] map;
    static boolean[][] visited;
    static int[][] time;
    static ArrayDeque<int[]> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        R = Integer.parseInt(firstLine[0]);
        C = Integer.parseInt(firstLine[1]);

        map = new char[R][C];
        visited = new boolean[R][C];
        time = new int[R][C];

        int[] start = null;

        for (int row = 0; row < R; row++) {
            char[] line = br.readLine().toCharArray();
            for (int col = 0; col < C; col++) {
                map[row][col] = line[col];
                if (line[col] == 'J') {
                    start = new int[]{row, col, 0};
                } else if (line[col] == 'F') {
                    queue.offer(new int[]{row, col, 1}); // 불 먼저 큐에 넣기
                }
            }
        }

        if (start != null) {
            queue.offer(start); // 지훈 시작점 큐에 넣기
            visited[start[0]][start[1]] = true;
        }

        int result = bfs();

        System.out.println(result == -1 ? "IMPOSSIBLE" : result);
    }

    static int bfs() {
        int[] dx = {-1, 0, 1, 0}; // 상, 우, 하, 좌
        int[] dy = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            int who = current[2]; // 1: 불, 0: 지훈

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (who == 1) { // 불 이동
                    if (nx >= 0 && ny >= 0 && nx < R && ny < C && (map[nx][ny] == '.' || map[nx][ny] == 'J')) {
                        map[nx][ny] = 'F';
                        queue.offer(new int[]{nx, ny, 1});
                    }
                } else { // 지훈 이동
                    if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                        return time[cx][cy] + 1; // 탈출 성공
                    }
                    if (map[nx][ny] == '.' && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        time[nx][ny] = time[cx][cy] + 1;
                        queue.offer(new int[]{nx, ny, 0});
                    }
                }
            }
        }

        return -1; // 탈출 불가능
    }
}
