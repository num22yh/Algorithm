import java.util.ArrayDeque;
import java.io.*;

import java.io.*;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] okenSu = new int[n];
        Deque<int[]> stack = new ArrayDeque<>(); // [인덱스, 값]

        // 초기값을 -1로 설정
        for (int i = 0; i < n; i++) {
            okenSu[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            int curNum = Integer.parseInt(input[i]);

            while (!stack.isEmpty() && stack.peek()[1] < curNum) {
                int index = stack.pop()[0];
                okenSu[index] = curNum;
            }

            stack.push(new int[]{i, curNum});
        }

        for (int num : okenSu) {
            sb.append(num).append(" ");
        }

        System.out.println(sb);
    }
}
