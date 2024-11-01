import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());

        // 배열 정렬
        Arrays.sort(arr);

        // 두 포인터 초기화
        int start = 0;
        int end = n - 1;
        int count = 0;

        // 탐색 시작
        while (start < end) {
            int sum = arr[start] + arr[end];
            if (sum < x) {
                start++;
            } else if (sum > x) {
                end--;
            } else {
                count++;
                start++;
                end--;
            }
        }

       
        System.out.println(count);
    }
}
