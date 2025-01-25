import java.io.*;
import java.util.*;


public class Main {

    static int R, C;
    static char[][] map;
    static boolean[][] visited;
    static int[] direction;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        //입력받기
        String[] firstLine = bufferedReader.readLine().split(" ");
        R = Integer.parseInt(firstLine[0]);// 방의 크기 R, C (3 ≤ R, C ≤ 1,000) , 방의 크기 최대 10^6 칸
        C = Integer.parseInt(firstLine[1]);

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            char[] line = map[i];
            Arrays.fill(line, '*');
        }

        int k = Integer.parseInt(bufferedReader.readLine());// 장애물의 개수 k ( 0 ≤ k ≤ 1,000 )
        for (int i = 0; i < k; i++) {
            String[] secondLine = bufferedReader.readLine().split(" ");
            int br = Integer.parseInt(secondLine[0]);
            int bc = Integer.parseInt(secondLine[1]);// k개의 줄에 장애물의 위치 좌표 br, bc
            map[br][bc] = 'x';
        }

        String[] thirdLine = bufferedReader.readLine().split(" ");// 로봇의 시작위치 좌표 sr, sc
        int sr = Integer.parseInt(thirdLine[0]);
        int sc = Integer.parseInt(thirdLine[1]);

        String[] fourthLine = bufferedReader.readLine().split(" ");
        direction = new int[4];
        for (int i = 0; i < 4; i++) {
            direction[i] = Integer.parseInt(fourthLine[i]);// 이동방향 순서 ( 1 : 상, 2 : 하 , 3: 좌 : 4: 우 ), 총 4개 입력
        }

        // 로봇의 마지막 위치좌표 r, c 출력
        int[] lastPosition = moveRobot(sr, sc);
        System.out.println(lastPosition[0] + " " + lastPosition[1]);

    }

    static int[] dx = new int[]{0, -1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, 0, -1, 1}; // 0, 상 하 좌 우
    static int diPoint = 0;

    static int[] moveRobot(int sr, int sc) {

        visited[sr][sc] = true;

        boolean canMove = findCanMove(sr,sc);

        if(!canMove){
            int[] lastSpot = new int[]{sr,sc};
            return lastSpot;
        }

        while(true){

            int nx = sr + dx[direction[diPoint]];
            int ny = sc + dy[direction[diPoint]];

            if(nx<0 || ny<0 || nx>=R || ny>=C || map[nx][ny] == 'x'|| visited[nx][ny]){
                if(diPoint == 3){
                    diPoint = 0;
                }else{
                    diPoint++;
                }
            }else{
                int[] lastSpot = moveRobot(nx,ny);
                return lastSpot;
            }

        }


    }

    static boolean findCanMove(int cx, int cy){
        int blockCount=0;
        for(int i=1; i<5; i++){
            int nx = cx + dx[i];
            int ny = cy + dy[i];

            if(nx < 0 || ny < 0 || nx >= R || ny >= C || map[nx][ny] == 'x' || visited[nx][ny]){
                blockCount++;
            }
        }

        if(blockCount == 4){
            return false;
        }else{
            return true;
        }
    }
}