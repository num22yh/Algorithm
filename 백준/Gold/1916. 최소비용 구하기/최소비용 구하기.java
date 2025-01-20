import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;


public class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<List<int[]>> map = new ArrayList<>(); // start : [end, cost], [end,cost] ...
        // 노드의 개수만큼 리스트 추가
        for(int i=0; i<N+1; i++){ //도시번호 1~N, 0번은 안쓸 예정
            map.add(new ArrayList<>());
        }

        // 버스 정보 받아 인접리스트 생성하기
        for(int i=0; i<M; i++){
            String[] line = br.readLine().split(" ");
            int start = Integer.parseInt(line[0]);
            int end = Integer.parseInt(line[1]);
            int cost = Integer.parseInt(line[2]);
            map.get(start).add(new int[]{end, cost});
        }

        String[] lastLine = br.readLine().split(" ");
        int startCity = Integer.parseInt(lastLine[0]);
        int endCity = Integer.parseInt(lastLine[1]);

        // 최단 거리 배열 및 초기화
        int[] distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[startCity] = 0;

        // 우선순위 큐 (거리 기준 오름차순)
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        heap.add(new int[]{startCity, 0});

        // 다익스트라 알고리즘
        while (!heap.isEmpty()) {
            int[] current = heap.poll();
            int currentNode = current[0];
            int currentDistance = current[1];

            // 이미 처리된 노드라면 무시
            if (currentDistance > distance[currentNode]) continue;

            // 인접 노드 탐색
            for (int[] neighbor : map.get(currentNode)) {
                int nextNode = neighbor[0];
                int nextDistance = currentDistance + neighbor[1];

                // 최단 거리 갱신
                if (nextDistance < distance[nextNode]) {
                    distance[nextNode] = nextDistance;
                    heap.add(new int[]{nextNode, nextDistance});
                }
            }
        }

        // 결과 출력
        System.out.println(distance[endCity]);
    }


    
}