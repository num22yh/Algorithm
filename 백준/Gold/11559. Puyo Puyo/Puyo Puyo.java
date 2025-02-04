import java.io.*;
import java.util.*;

public class Main{
    static final int row = 12;
    static final int col = 6;
    static char[][] map = new char[12][6];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력받기
        for (int r = 0; r<row; r++){
            char[] line = br.readLine().toCharArray();
            for(int c=0; c<col; c++){
                map[r][c] = line[c];// 총 12개의 행, 6개의 열
            }
        }
        // .은 빈공간, R, G, B, P, Y 의 뿌요
        int bombCount = 0;
        while(true){
            boolean hasBomb = doBomb();

            if(hasBomb){
                bombCount++;
               fallPuyo();
            }else{
                break;
            }
        }

        System.out.println(bombCount);

    }

    // 연쇄 탐색 + 터뜨림
    static boolean doBomb(){
        boolean flag = false;
        boolean[][] visited = new boolean[row][col];
        int[] dx = new int[]{-1,0,1,0}; // 상 우 하 좌
        int[] dy = new int[]{0,1,0,-1};
        LinkedList<int[]> bombQueue = new LinkedList<>();

        LinkedList<int[]> queue = new LinkedList<>();
        for(int r=0; r<row; r++){
            for(int c=0; c<col; c++){
                if(map[r][c]!='.' && !visited[r][c]){
                    int count = 1;
                    visited[r][c] = true;
                    queue.add(new int[]{r,c});

                    while(!queue.isEmpty()){
                        int[] current = queue.poll();
                        int cx = current[0];
                        int cy = current[1];
                        char curColor = map[cx][cy];
                        for(int i=0; i<4; i++){
                            int nx = cx + dx[i];
                            int ny = cy + dy[i];
                            if(nx>-1 && ny>-1 && nx<row && ny<col && !visited[nx][ny] && map[nx][ny] == curColor ){
                                visited[nx][ny] = true;
                                queue.add(new int[]{nx,ny});
                                count ++;
                            }
                        }
                    }

                    if(count >= 4){
                        changePuyoToDot(r,c);
                        flag = true;
                    }

                }
            }
        }

        return flag;
    }

    // 터뜨림
    static void changePuyoToDot(int r, int c){
        boolean[][] visited = new boolean[row][col];
        int[] dx = new int[]{-1,0,1,0}; // 상 우 하 좌
        int[] dy = new int[]{0,1,0,-1};

        LinkedList<int[]> queue = new LinkedList<>();

        visited[r][c] = true;
        queue.add(new int[]{r,c});
        char curColor = map[r][c];

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            map[cx][cy] = '.';

            for(int i=0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx>-1 && ny>-1 && nx<row && ny<col && !visited[nx][ny] && map[nx][ny] == curColor ){
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx,ny});
                }
            }
        }
    }

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