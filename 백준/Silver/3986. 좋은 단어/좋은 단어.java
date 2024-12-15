import java.util.ArrayDeque;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;

        int N = Integer.parseInt(br.readLine());

        for(int i =0; i<N; i++){
            char[] input = br.readLine().toCharArray();

            ArrayDeque<Character> stack = new ArrayDeque<>();

            for(char c : input){
                if(!stack.isEmpty()&&stack.peek()==c){
                    stack.pop();
                }else {
                    stack.push(c);
                }
            }

            if(stack.isEmpty()){
                count++;
            }
        }

        System.out.println(count);
    }
}