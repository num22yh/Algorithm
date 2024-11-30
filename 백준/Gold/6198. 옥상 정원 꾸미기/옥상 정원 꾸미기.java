import java.io.*;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        int[] input = new int[n];

        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }

        long result = 0;

        for (int i = n - 1; i > -1; i--) {
            int curHeight = input[i];
            int canSee = 0;

            while (!stack.isEmpty() && (stack.peek()[1] < curHeight)) {

                    int[] removedBuilding = stack.pop();
                    canSee += (removedBuilding[0] + 1);
                    
            }

            stack.push(new int[]{canSee, curHeight});
            result += canSee;
        }

        System.out.print(result);


    }

}