import java.io.*;
import java.util.ArrayDeque;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayDeque<Integer> toPrint = new ArrayDeque<>();

        for(int i=n-1; i>-1; i--){
            int curNum = Integer.parseInt(input[i]);

            while(!stack.isEmpty() && stack.peek()<= curNum){
                stack.pop();
            }

            if(stack.isEmpty()){
                toPrint.push(-1);
            }else{ //stack.peek() > curNum
                toPrint.push(stack.peek());
            }

            stack.push(curNum);
        }

        while(!toPrint.isEmpty()){
            sb.append(toPrint.pop());
            sb.append(" ");
        }
        System.out.println(sb);
    }
}