import java.io.*;
import java.util.*;

public class Main {
    static final int row = 12;
    static final int col = 6;
    static char[][] map = new char[row][col];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        for (int r = 0; r < row; r++) {
            map[r] = br.readLine().toCharArray();
        }

        int bombCount = 0;
        while (true) {
            boolean hasBomb = doBomb();
            if (hasBomb) {
                bombCount++;
                fallPuyo();
            } else {
                break;
            }
        }

        System.out.println(bombCount);
    }

    // 연쇄 탐색 및 뿌요 제거
    static boolean doBomb() {
        boolean flag = false;
        boolean[][] visited = new boolean[row][col];
        int[] dx = {-1, 0, 1, 0}; // 상 우 하 좌
        int[] dy = {0, 1, 0, -1};

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (map[r][c] != '.' && !visited[r][c]) {
                    List<int[]> puyoList = new ArrayList<>();
                    Queue<int[]> queue = new LinkedList<>();
                    
                    queue.add(new int[]{r, c});
                    visited[r][c] = true;
                    puyoList.add(new int[]{r, c});
                    char curColor = map[r][c];

                    while (!queue.isEmpty()) {
                        int[] current = queue.poll();
                        int cx = current[0];
                        int cy = current[1];

                        for (int i = 0; i < 4; i++) {
                            int nx = cx + dx[i];
                            int ny = cy + dy[i];

                            if (nx >= 0 && ny >= 0 && nx < row && ny < col && !visited[nx][ny] && map[nx][ny] == curColor) {
                                visited[nx][ny] = true;
                                queue.add(new int[]{nx, ny});
                                puyoList.add(new int[]{nx, ny});
                            }
                        }
                    }

                    if (puyoList.size() >= 4) {
                        flag = true;
                        for (int[] p : puyoList) {
                            map[p[0]][p[1]] = '.';
                        }
                    }
                }
            }
        }

        return flag;
    }

    // 중력 적용
    static void fallPuyo() {
        for (int c = 0; c < col; c++) { // 각 열마다 처리
            for (int r = row - 1; r > 0; r--) { // 아래에서 위로 확인
                if (map[r][c] == '.') { // 빈 칸이면 위에서 내려와야 함
                    int nr = r;
                    while (nr > 0 && map[nr][c] == '.') {
                        nr--; // 위로 올라가며 블록 찾기
                    }
                    if (map[nr][c] != '.') { // 위에서 뿌요를 찾았으면 교체
                        map[r][c] = map[nr][c];
                        map[nr][c] = '.';
                    }
                }
            }
        }
    }
}
