import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());
        for (int i =0; i<n; i++){
            String[] commend = br.readLine().split(" ");

            if (commend[0].equals("push")){
                int x = Integer.parseInt(commend[1]);
                queue.offer(x);
            } else if (commend[0].equals("pop")){
                if (queue.isEmpty()){
                    sb.append("-1"+"\n");
                }else{
                    sb.append(queue.poll()+"\n");
                }
            }else if (commend[0].equals("size")){
                sb.append(queue.size()+"\n");
            }else if (commend[0].equals("empty")){
                int ans = queue.isEmpty() ? 1 : 0;
                sb.append(ans+"\n");
            }else if (commend[0].equals("front")){
                if(queue.isEmpty()){
                    sb.append("-1"+"\n");
                }else{
                    sb.append(queue.peek()+"\n");
                }
            }else{ //back
                if(queue.isEmpty()){
                    sb.append("-1"+"\n");
                }else{
                    sb.append(queue.peekLast()+"\n");
                }
            }

        }

        System.out.println(sb);
    }
}