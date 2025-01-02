import java.io.*;
import java.util.ArrayDeque;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i =0; i<T; i++){
            String[] firstLine = br.readLine().split(" ");
            int M = Integer.parseInt(firstLine[0]); // 가로의 길이
            int N = Integer.parseInt(firstLine[1]); // 세로의 길이
            int K = Integer.parseInt(firstLine[2]); // 배추 개수

            int[][] map = new int[N][M];
            boolean[][] visited = new boolean[N][M];
            int count = 0;
            // 배추밭 정보 입력 받기
            for(int j=0; j<K; j++){
                String[] XY = br.readLine().split(" ");
                int Y = Integer.parseInt(XY[0]);
                int X = Integer.parseInt(XY[1]);
                map[X][Y] = 1;
            }

            for(int row=0; row<N; row++){
                for(int col=0; col<M; col++){
                    if(map[row][col]==1 && !visited[row][col]){
                        bfs(map,visited,row,col,N,M);
                        count++;
                    }
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);

    }

    static void bfs(int[][] map, boolean[][] visited, int start_x, int start_y, int N, int M){
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int[] dx = new int[]{-1,0,1,0};//상,우,하,좌
        int[] dy = new int[]{0,1,0,-1};

        // 시작점
        visited[start_x][start_y] = true;
        queue.offer(new int[]{start_x,start_y});

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int cur_x = cur[0];
            int cur_y = cur[1];

            for(int i=0; i<4; i++){
                int next_x = cur_x + dx[i];
                int next_y = cur_y + dy[i];

                if(next_x>=0 && next_y>=0 && next_x<N && next_y<M && map[next_x][next_y] == 1 && !visited[next_x][next_y]){
                    visited[next_x][next_y] = true;
                    queue.offer(new int[]{next_x,next_y});
                }
            }

        }
    }
}