import java.io.*;
import java.util.*;

public class Main{

    static ArrayList<ArrayList<Integer>> map = new ArrayList<>();
    static boolean[] visited;
    static int[] time;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        final int maxNode = 100000;
        
        visited = new boolean[maxNode+1];
        time = new int[maxNode+1];

        int minTime = bfs(N,K);

        System.out.println(minTime);
    }

    private static int bfs(int N, int K){
        int minTime=0;
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        queue.offer(N);
        visited[N] = true;
        time[N] = 0;

        while(!queue.isEmpty()){
            int current = queue.poll();

            if(current == K){
                minTime = time[current];
                break;
            }

            // 이동 가능한 위치 탐색
            int[] nextPositions = {current - 1, current + 1, current * 2};

            for (int next : nextPositions) {
                if (next >= 0 && next <= 100000 && !visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                    time[next] = time[current] + 1;
                }
            }
        }


        return minTime;
    }
}