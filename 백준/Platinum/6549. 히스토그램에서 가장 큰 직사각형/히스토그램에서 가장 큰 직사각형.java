import java.io.*;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            if (n == 0) break;

            ArrayDeque<int[]> stack = new ArrayDeque<>();
            long maxArea = 0;

            for (int i = 1; i <= n; i++) {
                int curHeight = Integer.parseInt(input[i]);

                while (!stack.isEmpty() && stack.peek()[1] > curHeight) {
                    int[] top = stack.pop();
                    int width = stack.isEmpty() ? i - 1 : i - stack.peek()[0] - 1;
                    maxArea = Math.max(maxArea, (long) top[1] * width);
                }

                stack.push(new int[]{i, curHeight});
            }

            while (!stack.isEmpty()) {
                int[] top = stack.pop();
                int width = stack.isEmpty() ? n : n - stack.peek()[0];
                maxArea = Math.max(maxArea, (long) top[1] * width);
            }

            sb.append(maxArea).append("\n");
        }
        System.out.print(sb);
    }
}
