import java.io.*;
import java.util.ArrayDeque;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        int curIndx = 0;

        for(String s : input){
            int curTower = Integer.parseInt(s);
            curIndx++;

            if(stack.peek()==null){
                sb.append(0+" ");
            }else if(stack.peek()[1] >= curTower){
                sb.append(stack.peek()[0]+" ");
            }else{ // stack.peek()[0] < curTower
                while(stack.peek()!= null && stack.peek()[1] < curTower){
                    stack.pop();
                }
                if(stack.peek()==null){
                    sb.append(0+" ");
                }else{
                    sb.append(stack.peek()[0]+" ");
                }

            }

            stack.push(new int[]{curIndx,curTower});
        }

        System.out.println(sb);


    }
}