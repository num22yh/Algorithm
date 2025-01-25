import java.io.*;
import java.util.*;

public class Main {

    static int N ;
    static char[][] map;
    static int max = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //입력받기
        N = Integer.parseInt(br.readLine());//보드의 크기 N (최대 50) , 사탕의 개수 최대 2500
        map = new char[N][N];
        //N개의 줄에 사탕의 색상(빨간색 C, 파란색 P, 초록색 Z, 노란색 Y)
        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                map[i][j] = line[j];
            }
        }

        int[] dx = new int[]{-1,1,0,0}; //상 하 좌 우
        int[] dy = new int[]{0,0,-1,1};

        // 2500 개 중 인접한 2개 선택 (최대 2500*4 =10000)
        for(int fx = 0; fx<N; fx++){
            for(int fy=0; fy<N; fy++){
                int[] first = new int[]{fx,fy};
                max = Math.max(max,countHorizontal(first));
                max = Math.max(max,countVertical(first));

                for(int i=0; i<4; i++){
                    int sx = fx + dx[i];
                    int sy = fy+ dy[i];
                    int[] second = new int[]{sx,sy};

                    if(sx>=0 && sy>=0 && sx<N && sy<N && map[fx][fy] != map[sx][sy]){

                        // 서로다른 2 자리의 사탕 바꾸기
                        changeCandies(first,second);
                        // 바뀐 두 좌표를 출발점으로 상,하,좌,우로 최대 몇 개까지 갈 수 있는지 세기
                        max = Math.max(max,countHorizontal(first));
                        max = Math.max(max,countVertical(first));
                        max = Math.max(max,countHorizontal(second));
                        max = Math.max(max,countVertical(second));

                        //바꿨던 사탕 원상복구
                        returnCandies(first,second);
                    }
                }
            }
        }
        //출력하기
        System.out.println(max);//상근이가 먹을 수 있는 사탕의 최대 개수
    }

    static void changeCandies(int[] first, int[] second){
        // 기존의 사탕들
        char firstCandy = map[first[0]][first[1]];
        char secondCandy = map[second[0]][second[1]];
        // 사탕 위치 서로 바꾸기
        map[first[0]][first[1]] = secondCandy;
        map[second[0]][second[1]] = firstCandy;
    }

    static void returnCandies(int[] first, int[] second){
        // 기존의 사탕들
        char firstCandy = map[first[0]][first[1]];
        char secondCandy = map[second[0]][second[1]];
        // 사탕 위치 원상복구
        map[first[0]][first[1]] = secondCandy;
        map[second[0]][second[1]] = firstCandy;

    }

    static int countVertical(int[] curCandy){

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        int maxCandy = 1;
        int[] dx = new int[]{-1,1};

        queue.add(curCandy);
        int sx = curCandy[0];
        int sy = curCandy[1];
        char curColor = map[sx][sy];
        visited[sx][sy] = true;

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            for(int i=0; i<2; i++){
                int nx = cx + dx[i];
                int ny = cy;

                if(nx>=0 && nx<N && ny>=0 && ny<N && map[nx][ny] == curColor && !visited[nx][ny]){
                    queue.add(new int[]{nx,ny});
                    maxCandy++;
                    visited[nx][ny] = true;
                }
            }
        }
        return maxCandy;

    }

    static int countHorizontal(int[] curCandy){

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        int maxCandy = 1;
        int[] dy = new int[]{-1,1};

        queue.add(curCandy);
        int sx = curCandy[0];
        int sy = curCandy[1];
        char curColor = map[sx][sy];
        visited[sx][sy] = true;

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            for(int i=0; i<2; i++){
                int nx = cx;
                int ny = cy + dy[i];

                if(nx>=0 && nx<N && ny>=0 && ny<N && map[nx][ny] == curColor && !visited[nx][ny]){
                    queue.add(new int[]{nx,ny});
                    maxCandy++;
                    visited[nx][ny] = true;
                }
            }
        }
        return maxCandy;
    }
}