import java.util.ArrayDeque;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            ArrayDeque<Character> stack = new ArrayDeque<>();
            char[] input = br.readLine().toCharArray();

            for(char c : input){

                if(c==')'){
                   if(!stack.isEmpty()&&stack.peek()=='('){
                       stack.pop();
                   }else{
                       stack.push(c);
                       break;
                   }
                }else{
                    stack.push(c);
                }
            }

            if(!stack.isEmpty()){
                sb.append("NO\n");
            }else{
                sb.append("YES\n");
            }
        }

        System.out.println(sb);
    }
}