import java.util.ArrayDeque;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] okenSu = new int[n]; //[오큰수]
        ArrayDeque<int[]> stack = new ArrayDeque<>(); // 인덱스, 수열의 수

        for (int i=0; i<n ; i++){
            int curNum = Integer.parseInt(input[i]);

            while(!stack.isEmpty() && stack.peek()[1]<curNum){
                // 날 오큰수로 갖는 수
                okenSu[stack.peek()[0]] = curNum;
                stack.pop();

            }

            stack.push(new int[]{i,curNum});
        }

        for (int i : okenSu){
            int num = (i==0)? -1 : i;
            sb.append(num+" ");
        }

        System.out.println(sb);

    }
}