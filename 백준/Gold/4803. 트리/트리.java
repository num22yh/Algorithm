import java.io.*;
import java.util.*;

public class Main {
    static int caseCount = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String[] firstLine = br.readLine().split(" ");
            //종료조건
            if (firstLine[0].equals("0") && firstLine[1].equals("0")) {
                break;
            }

            int n = Integer.parseInt(firstLine[0]);// 정점의 개수 n, (1번~n번)
            int m = Integer.parseInt(firstLine[1]);// 간선의 개수 m

            List<List<Integer>> tree = new ArrayList<>(); // tree를 인접리스트로 표현
            boolean[] visited = new boolean[n + 1]; //방문 여부를 기록할 배열
            int[] parent = new int[n + 1]; //부모노드를 기록할 배열
            int treeCount = 0;

            // 정점 1번 ~ N번까지 인접리스트로 표현 (0번인덱스는 사용 안함)
            for (int i = 0; i < n + 1; i++) {
                tree.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                String[] edges = br.readLine().split(" ");
                int s = Integer.parseInt(edges[0]);
                int e = Integer.parseInt(edges[1]);
                tree.get(s).add(e);
                tree.get(e).add(s); // tree는 양방향 엣지
            }

            for (int i = 1; i < n + 1; i++) {
                if (!visited[i]) {
                    boolean isTree = bfs(n, m, tree, visited, parent, i);
                    if (isTree) {
                        treeCount++;
                    }
                }
            }

            if (treeCount == 0) {
                sb.append("Case ").append(caseCount).append(": No trees.\n");
            } else if (treeCount == 1) {
                sb.append("Case ").append(caseCount).append(": There is one tree.\n");
            } else {
                sb.append("Case ").append(caseCount).append(": A forest of ").append(treeCount).append(" trees.\n");
            }

            caseCount++;

        }

        System.out.println(sb);

    }

    static boolean bfs(int n, int m, List<List<Integer>> tree, boolean[] visited, int[] parent, int startNode) {

        Queue<Integer> queue = new LinkedList<>();
        visited[startNode] = true;
        
        queue.offer(startNode);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int next : tree.get(current)) {
                if (visited[next]) {
                    if (next != parent[current]) {
                        return false;
                    }
                } else {
                    queue.offer(next);
                    visited[next] = true;
                    parent[next] = current;
                }
            }
        }

        return true;

    }
}