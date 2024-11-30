import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 건물의 개수
        long[] heights = new long[n]; // 건물 높이 배열

        for (int i = 0; i < n; i++) {
            heights[i] = scanner.nextLong();
        }

        // 스택을 사용하여 보이는 건물 계산
        Stack<Long> stack = new Stack<>();
        long count = 0;

        for (int i = 0; i < n; i++) {
            // 현재 건물보다 작은 건물은 스택에서 제거
            while (!stack.isEmpty() && stack.peek() <= heights[i]) {
                stack.pop();
            }
            
            // 스택에 남아 있는 건물 수를 더함
            count += stack.size();

            // 현재 건물을 스택에 추가
            stack.push(heights[i]);
        }

        System.out.println(count);
        scanner.close();
    }
}
