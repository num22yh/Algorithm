import java.io.*;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int current = 1; // 스택에 푸시할 숫자
        boolean isPossible = true;

        for (int i = 0; i < n; i++) {
            int target = Integer.parseInt(br.readLine());

            // 스택에 푸시해야 할 경우
            while (current <= target) {
                stack.push(current++);
                sb.append("+\n");
            }

            // 스택의 최상단이 목표 숫자인 경우 팝
            if (stack.peek() != null && stack.peek() == target) {
                stack.pop();
                sb.append("-\n");
            } else {
                // 목표 숫자를 만들 수 없는 경우
                isPossible = false;
                break;
            }
        }

        // 결과 출력
        if (isPossible) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }
    }
}
