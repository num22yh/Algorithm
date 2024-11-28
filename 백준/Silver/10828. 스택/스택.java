import java.io.*;
import java.util.ArrayDeque;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i=0; i<N; i++){
            String commend = br.readLine();
            if(commend.equals("pop")){
                if(!stack.isEmpty()){
                    sb.append(stack.pop()+"\n");
                }else{
                    sb.append("-1"+"\n");
                }
            }else if (commend.equals("size")){
                sb.append(stack.size()+"\n");
            }else if (commend.equals("empty")){
                if(stack.isEmpty()){
                    sb.append("1"+"\n");
                }else{
                    sb.append("0"+"\n");
                }
            }else if(commend.equals("top")){
                if(!stack.isEmpty()){
                    sb.append(stack.peek()+"\n");
                }else{
                    sb.append("-1"+"\n");
                }
            }else{
                String[] cmdPush = commend.split(" ");
                String X = cmdPush[1];
                stack.push(Integer.parseInt(X));
            }
        }

        System.out.println(sb);

    }
}