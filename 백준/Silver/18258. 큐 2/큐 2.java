import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());
        int ans = 0;

        for (int i = 0; i<N; i++){
            String[] commend = br.readLine().split(" ");
            if (commend[0].equals("push")){
                int x = Integer.parseInt(commend[1]);
                queue.offer(x);
            } else{
                if(commend[0].equals("pop")){
                    ans = queue.isEmpty()? -1 : queue.poll();
                } else if(commend[0].equals("size")){
                    ans = queue.size();
                } else if(commend[0].equals("empty")){
                    ans = queue.isEmpty()? 1 : 0;
                } else if (commend[0].equals("front")){
                    ans = queue.isEmpty()? -1 : queue.peek();
                } else{
                    //back
                    ans = queue.isEmpty()? -1 : queue.peekLast();
                }

                sb.append(ans + "\n");
            }
        }

        System.out.println(sb);
    }
}