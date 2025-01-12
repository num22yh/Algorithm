import java.util.*;

public class Main {
    static int k;
    static char[] operators;
    static boolean[] visited = new boolean[10];
    static List<String> results = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        operators = new char[k];
        for (int i = 0; i < k; i++) {
            operators[i] = sc.next().charAt(0);
        }

        backtrack("", 0);

        Collections.sort(results);

        System.out.println(results.get(results.size() - 1)); // 최대값
        System.out.println(results.get(0));                 // 최소값
    }

    static void backtrack(String num, int depth) {
        if (depth == k + 1) {
            results.add(num);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (!visited[i]) {
                if (depth == 0 || isValid(num.charAt(depth - 1) - '0', i, operators[depth - 1])) {
                    visited[i] = true;
                    backtrack(num + i, depth + 1);
                    visited[i] = false;
                }
            }
        }
    }

    static boolean isValid(int a, int b, char op) {
        if (op == '<') return a < b;
        if (op == '>') return a > b;
        return false;
    }
}
