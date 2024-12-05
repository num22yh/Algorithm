import java.util.ArrayDeque;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long count =0;
        ArrayDeque<int[]> stack = new ArrayDeque<>(); //[값, 같은 수의 연속 등장횟수]

        for (int i=0; i<n; i++){
            int curNum = Integer.parseInt(br.readLine());
            int sameNum = 1;

            while(!stack.isEmpty() && stack.peek()[0] <= curNum){
                int[] top = stack.pop();
                count += top[1];
                if(top[0]==curNum){
                    sameNum = top[1] + 1;
                }

            }

            if(!stack.isEmpty()){
                count++;
            }

            stack.push(new int[]{curNum, sameNum});
        }

        System.out.println(count);
    }
}