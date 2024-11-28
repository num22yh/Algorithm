import java.io.*;
import java.util.ArrayDeque;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int k = Integer.parseInt(br.readLine());

        for (int i=0; i<k; i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                stack.pop();
            }else{
                stack.push(num);
            }
        }

        int result = 0;
        while(!stack.isEmpty()){
            result +=stack.pop();
        }

        System.out.println(result);
    }
}