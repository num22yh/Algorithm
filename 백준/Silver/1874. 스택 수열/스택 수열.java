import java.io.*;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> stack1 = new ArrayDeque<>();
        ArrayDeque<Integer> stack2 = new ArrayDeque<>();

        for (int i = n; i > 0; i--) {
            stack1.push(i);
        }

        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());

            if (stack2.peek() != null && stack2.peek() == k) {
                stack2.pop();
                sb.append("-" + "\n");
            } else {
                if (stack1.peek() == null || stack1.peek() > k) {
                    sb = new StringBuilder();
                    sb.append("NO");
                    break;
                }
                while (stack1.peek()!=null && stack1.peek() <= k) {
                    stack2.push(stack1.pop());
                    sb.append("+" + "\n");
                    if(stack2.peek()==k){
                        stack2.pop();
                        sb.append("-" + "\n");
                    }

                }

            }
        }

        System.out.println(sb);
    }
}