import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] map;
    static boolean[][] visited;
    static int[][] time;
    static ArrayDeque<int[]> queue = new ArrayDeque<>();
    static int[] dx = {-1, 0, 1, 0}; // 상, 우, 하, 좌
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        R = Integer.parseInt(firstLine[0]);
        C = Integer.parseInt(firstLine[1]);

        map = new char[R][C];
        visited = new boolean[R][C];
        time = new int[R][C];

        int[] start = null;

        for (int i = 0; i < R; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                map[i][j] = line[j];
                if (line[j] == 'F') {
                    queue.offer(new int[]{i, j, 1}); // 불은 먼저 큐에 넣기
                } else if (line[j] == 'J') {
                    start = new int[]{i, j, 0}; // 지훈의 시작점
                }
            }
        }

        if (start != null) {
            queue.offer(start);
            visited[start[0]][start[1]] = true;
        }

        int result = bfs();

        if (result == -1) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(result);
        }
    }

    static int bfs() {
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int who = current[2]; // 1: 불, 0: 지훈

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위를 벗어난 경우 (지훈이 탈출한 경우)
                if (who == 0 && (nx < 0 || ny < 0 || nx >= R || ny >= C)) {
                    return time[x][y] + 1; // 즉시 반환
                }

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                    continue;
                }

                if (who == 1) {
                    // 🔥 불 확산
                    if (map[nx][ny] == '.' || map[nx][ny] == 'J') {
                        map[nx][ny] = 'F';
                        queue.offer(new int[]{nx, ny, 1});
                    }
                } else {
                    // 🏃 지훈 이동
                    if (!visited[nx][ny] && map[nx][ny] == '.') {
                        visited[nx][ny] = true;
                        time[nx][ny] = time[x][y] + 1;
                        queue.offer(new int[]{nx, ny, 0});
                    }
                }
            }
        }

        return -1; // 탈출 불가능
    }
}
